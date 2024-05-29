package br.feira.infra.database.postgres.repositories;

import br.feira.domain.entities.bo.BranchBO;
import br.feira.domain.repositories.IBranchRepository;

import java.util.List;
import java.util.UUID;

public class PgBranchRepository implements IBranchRepository {
    @Override
    public BranchBO create(BranchBO bo) {
        return null;
    }

    @Override
    public List<BranchBO> listAll() {
        return null;
    }

    @Override
    public BranchBO findById(UUID id) {
        return null;
    }

    @Override
    public BranchBO merge(BranchBO bo) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
