package br.feira.domain.repositories;

import java.util.List;
import java.util.UUID;

import br.feira.domain.entities.UserBO;

public interface IUserRepository {

    UserBO create(UserBO bo);

    List<UserBO> listAll();

    UserBO findById(UUID id);

    UserBO merge(UserBO bo);

    UserBO delete(UUID id);

}
