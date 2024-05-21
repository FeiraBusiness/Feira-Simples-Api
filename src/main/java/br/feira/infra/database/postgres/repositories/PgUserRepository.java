package br.feira.infra.database.postgres.repositories;

import br.feira.domain.entities.UserBO;
import br.feira.domain.repositories.IUserRepository;
import br.feira.infra.database.postgres.mappers.PgUserMapper;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PgUserRepository implements IUserRepository {

    @Override
    public UserBO create(UserBO bo) {
        var panacheUser = PgUserMapper.toEntity(bo);

        panacheUser.persist();

        return PgUserMapper.toDomain(panacheUser);
    }

}
