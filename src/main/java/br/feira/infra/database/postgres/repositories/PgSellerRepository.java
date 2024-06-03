package br.feira.infra.database.postgres.repositories;

import br.feira.domain.entities.bo.SellerBO;
import br.feira.domain.repositories.ISellerRepository;
import br.feira.infra.database.postgres.mappers.PgSellerMapper;
import br.feira.infra.database.postgres.model.PgSeller;
import br.feira.infra.database.postgres.model.PgCustomer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class PgSellerRepository implements ISellerRepository {

    @Override
    public SellerBO create(SellerBO bo) {
        var panache = PgSellerMapper.toEntity(bo);

        panache.persist();

        return PgSellerMapper.toDomain(panache);
    }

    @Override
    public List<SellerBO> listAll() {
        List<PgSeller> list = PgCustomer.listAll();

        // Criar uma função para fazer isso sem precisar usar duas vezes o mapper;
        return list.stream().map(PgSellerMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public SellerBO findById(UUID id) {
        PgSeller panache = PgCustomer.findById(id);

        if (panache == null) {
            throw new NotFoundException("User ID " + id + " not found!");
        }

        return PgSellerMapper.toDomain(panache);
    }

    @Override
    public SellerBO merge(SellerBO bo) {
        PgSeller panache = PgSellerMapper.toEntity(bo);

        PgSeller.getEntityManager().merge(panache);

        return PgSellerMapper.toDomain(panache);
    }

    @Override
    public void delete(UUID id) {
        PgSeller panache = PgSeller.findById(id);

        if (panache == null) {
            throw new NotFoundException("User not found");
        }

        panache.delete();

    }
}
