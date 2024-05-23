package br.feira.domain.repositories;

import br.feira.domain.entities.ProductBO;
import br.feira.domain.entities.UserBO;

import java.util.List;
import java.util.UUID;

public interface IProductRepository {

    ProductBO create(ProductBO bo);

    List<ProductBO> listAll();

    ProductBO findById(UUID id);

    ProductBO update(UUID id, ProductBO bo);

    ProductBO delete(UUID id);

}
