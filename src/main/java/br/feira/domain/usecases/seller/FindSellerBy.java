package br.feira.domain.usecases.seller;

import br.feira.domain.entities.dtos.SellerDTO;
import br.feira.domain.entities.mappers.SellerMapper;
import br.feira.domain.repositories.ISellerRepository;

import java.util.UUID;

public class FindSellerBy {
    private ISellerRepository repository;

    public FindSellerBy(ISellerRepository repository) {
        this.repository = repository;
    }

    public SellerDTO execute(UUID id) {
        var entity = repository.findById(id);

        if (entity == null) {
            // throw
        }

        return SellerMapper.toDTO(entity);
    }
}
