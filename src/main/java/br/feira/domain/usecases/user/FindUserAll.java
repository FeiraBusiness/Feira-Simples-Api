package br.feira.domain.usecases.user;

import java.util.List;

import br.feira.domain.entities.dtos.UserDTO;
import br.feira.domain.repositories.IUserRepository;

public class FindUserAll {

    private IUserRepository repository;

    public FindUserAll(IUserRepository repository) {
        this.repository = repository;
    }

    public List<UserDTO> execute() {
        // return repository.listAll();
        return null;
    }

}
