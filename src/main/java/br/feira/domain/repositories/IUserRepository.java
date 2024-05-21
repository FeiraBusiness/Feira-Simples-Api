package br.feira.domain.repositories;

import br.feira.domain.dtos.UserDTO;
import br.feira.domain.entities.UserBO;

import java.util.List;

public interface IUserRepository {

  UserBO create(UserBO bo);

  List<UserBO> listAll();

}
