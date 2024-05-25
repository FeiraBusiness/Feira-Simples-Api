package br.feira.domain.usecases.user;

import br.feira.domain.dtos.UserDTO;
import br.feira.domain.entities.UserBO;
import br.feira.domain.mappers.UserMapper;
import br.feira.domain.repositories.IUserRepository;

import java.util.UUID;

public class DeleteUser {

    private IUserRepository repository;

    public DeleteUser(IUserRepository repository) {
        this.repository = repository;
    }

    public UserDTO execute(UserDTO dto) {
        UserBO bo = repository.delete(dto.getId().transform(UUID::fromString));

        return UserMapper.toDTO(bo);
    }

}
