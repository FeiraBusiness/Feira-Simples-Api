package br.feira.domain.usecases.seller;

import br.feira.domain.entities.bo.SellerBO;
import br.feira.domain.entities.dtos.SellerDTO;
import br.feira.domain.entities.mappers.SellerMapper;
import br.feira.domain.repositories.ISellerRepository;

import java.util.UUID;

public class UpdateSeller {

    private ISellerRepository repository;

    public UpdateSeller(ISellerRepository repository) {
        this.repository = repository;
    }

    public SellerDTO execute(UUID id, SellerDTO dto) {
        SellerBO bo = repository.findById(id);

        if (bo == null) {
            throw new RuntimeException("Opa! Registro não encontrado");

        }

        bo = SellerMapper.toBO(dto);

        repository.merge(bo);

        return SellerMapper.toDTO(bo);
    }
}
