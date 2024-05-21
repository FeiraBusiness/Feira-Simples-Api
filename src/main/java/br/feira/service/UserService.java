package br.feira.service;

import br.feira.domain.dtos.UserDTO;
import br.feira.domain.entities.UserBO;
import br.feira.domain.usecases.CreateUser;
import br.feira.infra.database.postgres.repositories.PgUserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserService extends AbstractService {

    @Inject
    PgUserRepository pgUserRepository;

    @Transactional
    public UserDTO create(UserDTO dto) {
        var createUser = new CreateUser(pgUserRepository);

        return createUser.execute(dto);
    }

    public List<UserDTO> findAll() {
        return pgUserRepository.findAll();
    }
}
