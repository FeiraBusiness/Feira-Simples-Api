package br.feira.domain.repositories;

import br.feira.domain.entities.UserBO;

import java.util.List;
import java.util.UUID;

public interface IUserRepository {

    UserBO create(UserBO bo);

    List<UserBO> listAll();

    List<UserBO> findById(UUID id);
}
