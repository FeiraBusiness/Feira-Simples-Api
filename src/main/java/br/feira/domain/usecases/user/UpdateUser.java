package br.feira.domain.usecases.user;

import java.util.UUID;

import br.feira.domain.entities.bo.UserBO;
import br.feira.domain.entities.dtos.UserDTO;
import br.feira.domain.entities.mappers.UserMapper;
import br.feira.domain.repositories.IUserRepository;

public class UpdateUser {

    private IUserRepository repository;

    public UpdateUser(IUserRepository repository) {
        this.repository = repository;
    }

    public UserDTO execute(UUID id, UserDTO dto) {
        UserBO bo = repository.findById(id);

        if (bo == null) {
            throw new RuntimeException("Opa! Registro não encontrado");

        }

        bo = UserMapper.toBO(dto);

        repository.merge(bo);

        return UserMapper.toDTO(bo);
    }
}
