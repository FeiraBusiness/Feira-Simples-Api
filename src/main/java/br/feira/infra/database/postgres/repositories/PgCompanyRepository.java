package br.feira.infra.database.postgres.repositories;

import br.feira.domain.entities.bo.CompanyBO;
import br.feira.domain.repositories.ICompanyRepository;
import br.feira.infra.database.postgres.mappers.PgCompanyMapper;
import br.feira.infra.database.postgres.model.PgCompany;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class PgCompanyRepository implements ICompanyRepository {

    @Override
    public CompanyBO create(CompanyBO bo) {
        var panache = PgCompanyMapper.toEntity(bo);

        panache.persist();

        return PgCompanyMapper.toDomain(panache);
    }

    @Override
    public List<CompanyBO> listAll() {
        List<PgCompany> list = PgCompany.listAll();

        // Criar uma função para fazer isso sem precisar usar duas vezes o mapper;
        return list.stream().map(PgCompanyMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public CompanyBO findById(UUID id) {
        PgCompany panache = PgCompany.findById(id);

        if (panache == null) {
            throw new NotFoundException("User ID " + id + " not found!");
        }

        return PgCompanyMapper.toDomain(panache);
    }

    @Override
    public CompanyBO merge(CompanyBO bo) {
        PgCompany panache = PgCompanyMapper.toEntity(bo);

        panache.persist();

        return PgCompanyMapper.toDomain(panache);
    }

    @Override
    public void delete(UUID id) {
        PgCompany panache = PgCompany.findById(id);

        if (panache == null) {
            throw new NotFoundException("User not found");
        }

        panache.delete();

    }

}
