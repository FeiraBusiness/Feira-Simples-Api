package br.feira.domain.usecases.user;

import br.feira.domain.dtos.UserDTO;
import br.feira.domain.entities.UserBO;
import br.feira.domain.mappers.UserMapper;
import br.feira.domain.repositories.IUserRepository;

public class CreateUser {

    private IUserRepository repository;

    public CreateUser(IUserRepository repository) {
        this.repository = repository;
    }

    public UserDTO execute(UserDTO dto) {
        UserBO bo = UserMapper.toBO(dto);

        bo = repository.create(bo);

        return UserMapper.toDTO(bo);
    }

}