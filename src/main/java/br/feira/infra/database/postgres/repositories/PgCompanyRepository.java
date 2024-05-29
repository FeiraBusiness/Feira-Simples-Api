package br.feira.infra.database.postgres.repositories;

import br.feira.domain.entities.bo.CompanyBO;
import br.feira.domain.repositories.ICompanyRepository;

import java.util.List;
import java.util.UUID;

public class PgCompanyRepository implements ICompanyRepository {
    @Override
    public CompanyBO create(CompanyBO bo) {
        return null;
    }

    @Override
    public List<CompanyBO> listAll() {
        return null;
    }

    @Override
    public CompanyBO findById(UUID id) {
        return null;
    }

    @Override
    public CompanyBO merge(CompanyBO bo) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
