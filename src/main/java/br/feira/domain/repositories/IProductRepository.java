package br.feira.domain.repositories;

import java.util.List;
import java.util.UUID;

import br.feira.domain.entities.ProductBO;

public interface IProductRepository {

    ProductBO create(ProductBO bo);

    List<ProductBO> listAll();

    ProductBO findById(UUID id);

    ProductBO update(UUID id, ProductBO bo);

    ProductBO delete(UUID id);

}
