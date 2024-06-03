package br.feira.infra.database.postgres.repositories;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.feira.domain.entities.bo.CustomerBO;
import br.feira.domain.repositories.ICustomerRepository;
import br.feira.infra.database.postgres.mappers.PgCustomerMapper;
import br.feira.infra.database.postgres.model.PgCustomer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PgCustomerRepository implements ICustomerRepository {

    @Override
    public CustomerBO create(CustomerBO bo) {
        var panache = PgCustomerMapper.toEntity(bo);

        panache.persist();

        return PgCustomerMapper.toDomain(panache);
    }

    @Override
    public List<CustomerBO> listAll() {
        List<PgCustomer> list = PgCustomer.listAll();

        // Criar uma função para fazer isso sem precisar usar duas vezes o mapper;
        return list.stream().map(PgCustomerMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public CustomerBO findById(UUID id) {
        PgCustomer panache = PgCustomer.findById(id);

        if (panache == null) {
            throw new NotFoundException("User ID " + id + " not found!");
        }

        return PgCustomerMapper.toDomain(panache);
    }

    @Override
    public CustomerBO merge(CustomerBO bo) {
        PgCustomer panache = PgCustomerMapper.toEntity(bo);

        PgCustomer.getEntityManager().persist(panache);

        return PgCustomerMapper.toDomain(panache);
    }

    @Override
    public void delete(UUID id) {
        PgCustomer panache = PgCustomer.findById(id);

        if (panache == null) {
            throw new NotFoundException("User not found");
        }

        panache.delete();
    }

}
