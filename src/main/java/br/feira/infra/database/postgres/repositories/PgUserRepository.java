package br.feira.infra.database.postgres.repositories;

import br.feira.domain.entities.UserBO;
import br.feira.domain.repositories.IUserRepository;
import br.feira.infra.database.postgres.mappers.PgUserMapper;
import br.feira.infra.database.postgres.model.PgUser;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class PgUserRepository implements IUserRepository {

    @Override
    public UserBO create(UserBO bo) {
        var panacheUser = PgUserMapper.toEntity(bo);

        panacheUser.persist();

        return PgUserMapper.toDomain(panacheUser);
    }

    @Override
    public List<UserBO> listAll() {
        List<PgUser> users = PgUser.listAll();

        //Criar uma função para fazer isso sem precisar usar duas vezes o mapper;
        return users.stream().map(PgUserMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<UserBO> findById(UUID id) {
        return PgUser.findById(id);
    }

}
