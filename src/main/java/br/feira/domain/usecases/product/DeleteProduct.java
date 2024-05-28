package br.feira.domain.usecases.product;

import java.util.UUID;

import br.feira.domain.entities.dtos.ProductDTO;
import br.feira.domain.repositories.IProductRepository;

public class DeleteProduct {

    private IProductRepository repository;

    public DeleteProduct(IProductRepository repository) {
        this.repository = repository;
    }

    public void execute(ProductDTO dto) {
        repository.delete(dto.getId().transform(UUID::fromString));
    }

}
