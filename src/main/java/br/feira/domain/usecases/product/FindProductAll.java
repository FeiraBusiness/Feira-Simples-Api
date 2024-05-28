package br.feira.domain.usecases.product;

import java.util.List;

import br.feira.domain.entities.dtos.ProductDTO;
import br.feira.domain.repositories.IProductRepository;

public class FindProductAll {

    private IProductRepository repository;

    public FindProductAll(IProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductDTO> execute() {
        return null;
    }

}
