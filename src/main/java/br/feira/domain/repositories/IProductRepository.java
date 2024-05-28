package br.feira.domain.repositories;

import java.util.List;
import java.util.UUID;

import br.feira.domain.entities.bo.ProductBO;

public interface IProductRepository {

    ProductBO create(ProductBO bo);

    List<ProductBO> listAll();

    ProductBO findById(UUID id);

    ProductBO merge(ProductBO bo);

    void delete(UUID id);

}
