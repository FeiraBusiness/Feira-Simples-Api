package br.feira.domain.usecases.product;

import br.feira.domain.entities.bo.ProductBO;
import br.feira.domain.entities.dtos.ProductDTO;
import br.feira.domain.entities.mappers.ProductMapper;
import br.feira.domain.repositories.IProductRepository;

import java.util.UUID;

public class UpdateProduct {

    private IProductRepository repository;

    public UpdateProduct(IProductRepository repository) {
        this.repository = repository;
    }

    public ProductDTO execute(UUID id, ProductDTO dto) {
        ProductBO bo = repository.findById(id);

        if (bo == null) {
            throw new RuntimeException("Opa! Registro não encontrado");
        }

        bo = ProductMapper.toBO(dto);

        repository.merge(bo);

        return ProductMapper.toDTO(bo);
    }
}
