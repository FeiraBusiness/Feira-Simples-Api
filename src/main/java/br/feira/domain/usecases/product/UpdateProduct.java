package br.feira.domain.usecases.product;

import br.feira.domain.dtos.ProductDTO;
import br.feira.domain.entities.ProductBO;
import br.feira.domain.mappers.ProductMapper;
import br.feira.domain.repositories.IProductRepository;

import java.util.UUID;

public class UpdateProduct {

    private IProductRepository repository;

    public UpdateProduct(IProductRepository repository) {
        this.repository = repository;
    }

    public ProductDTO execute(UUID id, ProductDTO dto) {
        ProductBO bo = ProductMapper.toBO(dto);

        bo = repository.update(id, bo);

        return ProductMapper.toDTO(bo);
    }
}
