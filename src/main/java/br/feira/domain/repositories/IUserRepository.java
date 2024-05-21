package br.feira.domain.repositories;

import br.feira.domain.entities.UserBO;

public interface IUserRepository {

  UserBO create(UserBO bo);

}
