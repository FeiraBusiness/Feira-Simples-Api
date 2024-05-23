package br.feira.domain.usecases.user;

import br.feira.domain.dtos.UserDTO;
import br.feira.domain.entities.UserBO;
import br.feira.domain.mappers.UserMapper;
import br.feira.domain.repositories.IUserRepository;

import java.util.UUID;

public class UpdateUser {

    private IUserRepository repository;

    public UpdateUser(IUserRepository repository) {
        this.repository = repository;
    }

    public UserDTO execute(UUID id, UserDTO dto) {
        UserBO userBO = UserMapper.toBO(dto);

        userBO = repository.update(id, userBO);

        return UserMapper.toDTO(userBO);
    }
}
