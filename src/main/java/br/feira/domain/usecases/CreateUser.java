package br.feira.domain.usecases;

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
    UserBO userBO = UserMapper.toBO(dto);

    userBO = repository.create(userBO);

    return UserMapper.toDTO(userBO);
  }

}