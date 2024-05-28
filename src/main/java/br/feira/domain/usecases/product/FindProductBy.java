package br.feira.domain.usecases.product;

import java.util.UUID;

import br.feira.domain.entities.dtos.ProductDTO;
import br.feira.domain.entities.mappers.ProductMapper;
import br.feira.domain.repositories.IProductRepository;

public class FindProductBy {

    private IProductRepository repository;

    public FindProductBy(IProductRepository repository) {
        this.repository = repository;
    }

    public ProductDTO execute(UUID id) {
        var entity = repository.findById(id);

        if (entity == null) {
            // throw
        }

        return ProductMapper.toDTO(entity);
    }

}
