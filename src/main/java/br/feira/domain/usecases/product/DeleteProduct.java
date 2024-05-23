package br.feira.domain.usecases.product;

import br.feira.domain.dtos.ProductDTO;
import br.feira.domain.entities.ProductBO;
import br.feira.domain.mappers.ProductMapper;
import br.feira.domain.repositories.IProductRepository;

import java.util.UUID;

public class DeleteProduct {

    private IProductRepository repository;

    public DeleteProduct(IProductRepository repository) {
        this.repository = repository;
    }

    public ProductDTO execute(ProductDTO dto) {
        ProductBO productBO = repository.delete(dto.getId().transform(UUID::fromString));

        return ProductMapper.toDTO(productBO);
    }

}
