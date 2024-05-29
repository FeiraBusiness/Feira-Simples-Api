package br.feira.service;

import java.util.List;
import java.util.UUID;

import br.feira.domain.entities.bo.UserBO;
import br.feira.domain.entities.dtos.UserDTO;
import br.feira.domain.entities.mappers.UserMapper;
import br.feira.domain.usecases.user.CreateUser;
import br.feira.domain.usecases.user.DeleteUser;
import br.feira.domain.usecases.user.FindUserAll;
import br.feira.domain.usecases.user.FindUserBy;
import br.feira.domain.usecases.user.UpdateUser;
import br.feira.infra.database.postgres.repositories.PgUserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserService extends AbstractService {

    @Inject
    PgUserRepository repository;

    @Transactional
    public UserDTO create(UserDTO dto) {
        var create = new CreateUser(repository);

        return create.execute(dto);
    }

    public List<UserDTO> listAll() {
        var list = new FindUserAll(repository);

        return list.execute();

    }

    public UserDTO findById(UUID id) {
        var findById = new FindUserBy(repository);

        return findById.execute(id);
    }

    @Transactional
    public UserDTO merge(UUID id, UserDTO dto) {
        var update = new UpdateUser(repository);

        return update.execute(id, dto);
    }

    @Transactional
    public void delete(UUID id) {
        UserBO user = repository.findById(id);

        var dto = UserMapper.toDTO(user);

        var delete = new DeleteUser(repository);

        delete.execute(dto);
    }
}
