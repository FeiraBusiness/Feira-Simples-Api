package br.feira.service;

import br.feira.domain.entities.bo.SellerBO;
import br.feira.domain.entities.dtos.SellerDTO;
import br.feira.domain.entities.mappers.UserMapper;
import br.feira.domain.usecases.user.*;
import br.feira.infra.database.postgres.repositories.PgSellerRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

public class SellerService extends AbstractService {

    @Inject
    PgSellerRepository repository;

    @Transactional
    public SellerDTO create(SellerDTO dto) {
        var create = new CreateUser(repository);

        return create.execute(dto);
    }

    public List<SellerDTO> listAll() {
        var list = new FindUserAll(repository);

        return list.execute();

    }

    public SellerDTO findById(UUID id) {
        var findById = new FindUserBy(repository);

        return findById.execute(id);
    }

    @Transactional
    public SellerDTO merge(UUID id, SellerDTO dto) {
        var update = new UpdateUser(repository);

        return update.execute(id, dto);
    }

    @Transactional
    public void delete(UUID id) {
        SellerBO user = repository.findById(id);

        var dto = UserMapper.toDTO(user);

        var delete = new DeleteUser(repository);

        delete.execute(dto);
    }

}
