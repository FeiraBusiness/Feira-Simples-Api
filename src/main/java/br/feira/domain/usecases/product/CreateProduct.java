package br.feira.domain.usecases.product;

import br.feira.domain.dtos.ProductDTO;
import br.feira.domain.entities.ProductBO;
import br.feira.domain.mappers.ProductMapper;
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