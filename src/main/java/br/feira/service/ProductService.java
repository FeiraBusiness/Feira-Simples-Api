package br.feira.service;

import br.feira.domain.dtos.ProductDTO;
import br.feira.domain.entities.ProductBO;
import br.feira.domain.mappers.ProductMapper;
import br.feira.domain.usecases.product.CreateProduct;
import br.feira.domain.usecases.product.DeleteProduct;
import br.feira.domain.usecases.product.UpdateProduct;
import br.feira.infra.database.postgres.repositories.PgProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ProductService extends AbstractService {

    @Inject
    PgProductRepository repository;

    @Transactional
    public ProductDTO create(ProductDTO dto) {
        var create = new CreateProduct(repository);

        return create.execute(dto);
    }

    public List<ProductBO> listAll() {
        return repository.listAll();
    }

    public ProductBO findById(UUID id) {
        return repository.findById(id);
    }

    @Transactional
    public ProductDTO update(UUID id, ProductDTO dto) {
        var update = new UpdateProduct(repository);

        return update.execute(id, dto);
    }

    @Transactional
    public ProductDTO delete(UUID id) {
        ProductBO product = repository.findById(id);

        var dto = ProductMapper.toDTO(product);

        var delete = new DeleteProduct(repository);

        return delete.execute(dto);
    }
}
