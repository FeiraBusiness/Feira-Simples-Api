package br.feira.domain.usecases.seller;

import br.feira.domain.entities.bo.SellerBO;
import br.feira.domain.entities.dtos.SellerDTO;
import br.feira.domain.entities.mappers.SellerMapper;
import br.feira.domain.repositories.ISellerRepository;

public class CreateSeller {

    private ISellerRepository repository;

    public CreateSeller(ISellerRepository repository) {
        this.repository = repository;
    }

    public SellerDTO execute(SellerDTO dto) {
        SellerBO bo = SellerMapper.toBO(dto);

        bo = repository.create(bo);

        return SellerMapper.toDTO(bo);
    }
}
