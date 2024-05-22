package br.feira.service;

import br.feira.domain.dtos.UserDTO;
import br.feira.domain.entities.UserBO;
import br.feira.domain.mappers.UserMapper;
import br.feira.domain.usecases.CreateUser;
import br.feira.domain.usecases.DeleteUser;
import br.feira.domain.usecases.UpdateUser;
import br.feira.infra.database.postgres.repositories.PgUserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserService extends AbstractService {

    @Inject
    PgUserRepository pgUserRepository;

    @Transactional
    public UserDTO create(UserDTO dto) {
        var createUser = new CreateUser(pgUserRepository);

        return createUser.execute(dto);
    }

    public List<UserBO> listAll() {
        return pgUserRepository.listAll();
    }

    public UserBO findById(UUID id) {
        return pgUserRepository.findById(id);
    }

    @Transactional
    public UserDTO update(UUID id, UserDTO dto) {
        var updateUser = new UpdateUser(pgUserRepository);

        return updateUser.execute(id, dto);
    }

    @Transactional
    public UserDTO delete(UUID id) {
        UserBO user = pgUserRepository.findById(id);

        var dto = UserMapper.toDTO(user);

        var deleteUser = new DeleteUser(pgUserRepository);

        return deleteUser.execute(dto);
    }
}
