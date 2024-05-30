package br.feira.service;

import br.feira.domain.entities.bo.SellerBO;
import br.feira.domain.entities.dtos.SellerDTO;
import br.feira.domain.entities.mappers.SellerMapper;
import br.feira.domain.usecases.seller.*;
import br.feira.infra.database.postgres.repositories.PgSellerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class SellerService extends AbstractService {

    @Inject
    PgSellerRepository repository;

    @Transactional
    public SellerDTO create(SellerDTO dto) {
        var create = new CreateSeller(repository);

        return create.execute(dto);
    }

    public List<SellerDTO> listAll() {
        var list = new FindSellerAll(repository);

        return list.execute();

    }

    public SellerDTO findById(UUID id) {
        var findById = new FindSellerBy(repository);

        return findById.execute(id);
    }

    @Transactional
    public SellerDTO merge(UUID id, SellerDTO dto) {
        var update = new UpdateSeller(repository);

        return update.execute(id, dto);
    }

    @Transactional
    public void delete(UUID id) {
        SellerBO bo = repository.findById(id);

        var dto = SellerMapper.toDTO(bo);

        var delete = new DeleteSeller(repository);

        delete.execute(dto);
    }

}
