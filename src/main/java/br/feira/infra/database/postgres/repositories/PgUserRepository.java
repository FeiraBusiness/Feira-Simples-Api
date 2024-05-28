package br.feira.infra.database.postgres.repositories;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.feira.domain.entities.bo.UserBO;
import br.feira.domain.repositories.IUserRepository;
import br.feira.infra.database.postgres.mappers.PgUserMapper;
import br.feira.infra.database.postgres.model.PgUser;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PgUserRepository implements IUserRepository {

    @Override
    public UserBO create(UserBO bo) {
        var panache = PgUserMapper.toEntity(bo);

        panache.persist();

        return PgUserMapper.toDomain(panache);
    }

    @Override
    public List<UserBO> listAll() {
        List<PgUser> list = PgUser.listAll();

        // Criar uma função para fazer isso sem precisar usar duas vezes o mapper;
        return list.stream().map(PgUserMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public UserBO findById(UUID id) {
        PgUser panache = PgUser.findById(id);

        if (panache == null) {
            throw new NotFoundException("User ID " + id + " not found!");
        }

        return PgUserMapper.toDomain(panache);
    }

    @Override
    public UserBO merge(UserBO bo) {
        PgUser panache = PgUserMapper.toEntity(bo);

        panache.persist();

        return PgUserMapper.toDomain(panache);
    }

    @Override
    public void delete(UUID id) {
        PgUser panache = PgUser.findById(id);

        if (panache == null) {
            throw new NotFoundException("User not found");
        }

        panache.delete();

    }

}
