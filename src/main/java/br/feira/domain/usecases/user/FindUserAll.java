package br.feira.domain.usecases.user;

import java.util.List;
import java.util.stream.Collectors;

import br.feira.domain.entities.bo.UserBO;
import br.feira.domain.entities.dtos.UserDTO;
import br.feira.domain.entities.mappers.UserMapper;
import br.feira.domain.repositories.IUserRepository;

public class FindUserAll {

    private IUserRepository repository;

    public FindUserAll(IUserRepository repository) {
        this.repository = repository;
    }

    public List<UserDTO> execute() {
        List<UserBO> list = repository.listAll();
        
        return list.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

}
