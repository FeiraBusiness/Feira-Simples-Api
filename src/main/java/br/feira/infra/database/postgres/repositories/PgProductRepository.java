package br.feira.infra.database.postgres.repositories;

import br.feira.domain.entities.ProductBO;
import br.feira.domain.repositories.IProductRepository;
import br.feira.infra.database.postgres.mappers.PgProductMapper;
import br.feira.infra.database.postgres.model.PgProduct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class PgProductRepository implements IProductRepository {


    @Override
    public ProductBO create(ProductBO bo) {
        var panache = PgProductMapper.toEntity(bo);

        panache.persist();

        return PgProductMapper.toDomain(panache);
    }

    @Override
    public List<ProductBO> listAll() {
        List<PgProduct> list = PgProduct.listAll();

        return list.stream().map(PgProductMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public ProductBO findById(UUID id) {
        PgProduct panache = PgProduct.findById(id);

        if (panache == null) {
            throw new NotFoundException("Product ID " + id + " not found!");
        }
        return PgProductMapper.toDomain(panache);
    }

    @Override
    public ProductBO update(UUID id, ProductBO bo) {
        PgProduct panache = PgProduct.findById(id);

        panache = PgProductMapper.toEntity(bo);

        panache.persist();

        return PgProductMapper.toDomain(panache);
    }

    @Override
    public ProductBO delete(UUID id) {
        PgProduct panache = PgProduct.findById(id);

        panache.delete();

        return PgProductMapper.toDomain(panache);
    }
}