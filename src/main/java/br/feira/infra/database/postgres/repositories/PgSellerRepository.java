package br.feira.infra.database.postgres.repositories;

import br.feira.domain.entities.bo.SellerBO;
import br.feira.domain.repositories.ISellerRepository;

import java.util.List;
import java.util.UUID;

public class PgSellerRepository implements ISellerRepository {

    @Override
    public SellerBO create(SellerBO bo) {
        return null;
    }

    @Override
    public List<SellerBO> listAll() {
        return null;
    }

    @Override
    public SellerBO findById(UUID id) {
        return null;
    }

    @Override
    public SellerBO merge(SellerBO bo) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
