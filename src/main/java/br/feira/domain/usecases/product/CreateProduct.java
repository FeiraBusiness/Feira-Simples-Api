package br.feira.domain.usecases.product;

import br.feira.domain.entities.bo.ProductBO;
import br.feira.domain.entities.dtos.ProductDTO;
import br.feira.domain.entities.mappers.ProductMapper;
import br.feira.domain.repositories.IProductRepository;

public class CreateProduct {

    private IProductRepository repository;

    public CreateProduct(IProductRepository repository) {
        this.repository = repository;
    }

    public ProductDTO execute(ProductDTO dto) {
        ProductBO bo = ProductMapper.toBO(dto);

        bo = repository.create(bo);

        return ProductMapper.toDTO(bo);
    }

}