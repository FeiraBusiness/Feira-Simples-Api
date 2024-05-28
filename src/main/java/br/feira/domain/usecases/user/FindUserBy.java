package br.feira.domain.usecases.user;

import java.util.UUID;

import br.feira.domain.entities.dtos.UserDTO;
import br.feira.domain.entities.mappers.UserMapper;
import br.feira.domain.repositories.IUserRepository;

public class FindUserBy {

    private IUserRepository repository;

    public FindUserBy(IUserRepository repository) {
        this.repository = repository;
    }

    public UserDTO execute(UUID id) {
        var entity = repository.findById(id);

        if (entity == null) {
            // throw
        }

        return UserMapper.toDTO(entity);
    }

}
