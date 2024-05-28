package br.feira.service;

import java.util.List;
import java.util.UUID;

import br.feira.domain.entities.bo.ProductBO;
import br.feira.domain.entities.dtos.ProductDTO;
import br.feira.domain.entities.mappers.ProductMapper;
import br.feira.domain.usecases.product.CreateProduct;
import br.feira.domain.usecases.product.DeleteProduct;
import br.feira.domain.usecases.product.FindProductBy;
import br.feira.domain.usecases.product.UpdateProduct;
import br.feira.infra.database.postgres.repositories.PgProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProductService extends AbstractService {

    @Inject
    PgProductRepository repository;

    @Transactional
    public ProductDTO create(ProductDTO dto) {
        var create = new CreateProduct(repository);

        return create.execute(dto);
    }

    public List<ProductDTO> listAll() {
        // return repository.listAll();
        return null;
    }

    public ProductDTO findById(UUID id) {
        var find = new FindProductBy(repository);

        return find.execute(id);
    }

    @Transactional
    public ProductDTO merge(UUID id, ProductDTO dto) {
        var update = new UpdateProduct(repository);

        return update.execute(id, dto);
    }

    @Transactional
    public void delete(UUID id) {
        ProductBO product = repository.findById(id);

        var dto = ProductMapper.toDTO(product);

        var delete = new DeleteProduct(repository);

        delete.execute(dto);
    }
}
