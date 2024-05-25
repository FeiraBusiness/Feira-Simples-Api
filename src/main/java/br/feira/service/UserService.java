package br.feira.service;

import br.feira.domain.dtos.UserDTO;
import br.feira.domain.entities.UserBO;
import br.feira.domain.mappers.UserMapper;
import br.feira.domain.usecases.user.CreateUser;
import br.feira.domain.usecases.user.DeleteUser;
import br.feira.domain.usecases.user.UpdateUser;
import br.feira.infra.database.postgres.repositories.PgUserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserService extends AbstractService {

    @Inject
    PgUserRepository repository;

    @Transactional
    public UserDTO create(UserDTO dto) {
        var create = new CreateUser(repository);

        return create.execute(dto);
    }

    public List<UserBO> listAll() {
        return repository.listAll();
    }

    public UserBO findById(UUID id) {
        return repository.findById(id);
    }

    @Transactional
    public UserDTO update(UUID id, UserDTO dto) {
        var update = new UpdateUser(repository);

        return update.execute(id, dto);
    }

    @Transactional
    public UserDTO delete(UUID id) {
        UserBO user = repository.findById(id);

        var dto = UserMapper.toDTO(user);

        var delete = new DeleteUser(repository);

        return delete.execute(dto);
    }
}
