package br.feira.infra.database.postgres.mappers;

import br.feira.domain.entities.UserBO;
import br.feira.infra.database.postgres.model.PgAddress;
import br.feira.infra.database.postgres.model.PgUser;

import java.util.List;
import java.util.stream.Collectors;

public class PgUserMapper {

    public static UserBO toDomain(PgUser entity) {
        var userBO = new UserBO(
                entity.getId().toString(),
                entity.getName(),
                entity.getEmail(),
                entity.getCpfCnpj(),
                entity.getGender(),
                entity.getPassword(),
                entity.getPhoneNumber(),
                entity.getIsActive(),
                entity.getAddress().stream().map(PgAddressMapper::toDomain).collect(Collectors.toList()),
                entity.getDateOfBirth(),
                entity.getCreatedAt(),
                entity.getUpdateAt());

        return userBO;
    }

    public static PgUser toEntity(UserBO bo) {
        var panacheUser = new PgUser();

        panacheUser.setId(bo.getId());
        panacheUser.setName(bo.getName());
        panacheUser.setEmail(bo.getEmail());
        panacheUser.setCpfCnpj(bo.getCpfCnpj());
        panacheUser.setGender(bo.getGender());
        panacheUser.setPassword(bo.getPassword());
        panacheUser.setPhoneNumber(bo.getPhoneNumber());
        panacheUser.setIsActive(bo.getIsActive());
        List<PgAddress> addresses = bo.getAddress().stream().map(PgAddressMapper::toEntity).toList();
        addresses.forEach(address -> address.setUser(panacheUser));
        panacheUser.setAddress(addresses);
//        panacheUser.setAddress(bo.getAddress().stream().map(PgAddressMapper::toEntity).collect(Collectors.toList()));
        panacheUser.setDateOfBirth(bo.getDateOfBirth());
        panacheUser.setCreatedAt(bo.getCreateAt());
        panacheUser.setUpdateAt(bo.getUpdateAt());

        return panacheUser;
    }
}
