package br.feira.infra.database.postgres.repositories;

import br.feira.domain.entities.bo.BranchBO;
import br.feira.domain.repositories.IBranchRepository;
import br.feira.infra.database.postgres.mappers.PgBranchMapper;
import br.feira.infra.database.postgres.model.PgBranch;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class PgBranchRepository implements IBranchRepository {

    @Override
    public BranchBO create(BranchBO bo) {
        var panache = PgBranchMapper.toEntity(bo);

        panache.persist();

        return PgBranchMapper.toDomain(panache);
    }

    @Override
    public List<BranchBO> listAll() {
        List<PgBranch> list = PgBranch.listAll();

        // Criar uma função para fazer isso sem precisar usar duas vezes o mapper;
        return list.stream().map(PgBranchMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public BranchBO findById(UUID id) {
        PgBranch panache = PgBranch.findById(id);

        if (panache == null) {
            throw new NotFoundException("User ID " + id + " not found!");
        }

        return PgBranchMapper.toDomain(panache);
    }

    @Override
    public BranchBO merge(BranchBO bo) {
        PgBranch panache = PgBranchMapper.toEntity(bo);

        PgBranch.getEntityManager().merge(panache);

        return PgBranchMapper.toDomain(panache);
    }

    @Override
    public void delete(UUID id) {
        PgBranch panache = PgBranch.findById(id);

        if (panache == null) {
            throw new NotFoundException("User not found");
        }

        panache.delete();

    }
}
