package br.feira.domain.usecases.product;

import java.util.List;
import java.util.stream.Collectors;

import br.feira.domain.entities.bo.ProductBO;
import br.feira.domain.entities.dtos.ProductDTO;
import br.feira.domain.entities.mappers.ProductMapper;
import br.feira.domain.repositories.IProductRepository;

public class FindProductAll {

    private IProductRepository repository;

    public FindProductAll(IProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductDTO> execute() {
        List<ProductBO> list = repository.listAll();

        return list.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

}
