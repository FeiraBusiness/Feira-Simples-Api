package br.feira.domain.usecases.user;

import java.util.UUID;

import br.feira.domain.entities.dtos.UserDTO;
import br.feira.domain.repositories.IUserRepository;

public class DeleteUser {

    private IUserRepository repository;

    public DeleteUser(IUserRepository repository) {
        this.repository = repository;
    }

    public void execute(UserDTO dto) {
        repository.delete(dto.getId().transform(UUID::fromString));
    }

}
