package br.feira.infra.database.postgres.mappers;

import br.feira.domain.entities.bo.UserBO;
import br.feira.infra.database.postgres.model.PgAddress;
import br.feira.infra.database.postgres.model.PgUser;

import java.util.List;
import java.util.stream.Collectors;

public class PgUserMapper {

    public static PgUser toEntity(UserBO bo) {
        var panache = new PgUser();

        panache.setId(bo.getId());
        panache.setName(bo.getName());
        panache.setEmail(bo.getEmail());
        panache.setCpfCnpj(bo.getCpfCnpj());
        panache.setGender(bo.getGender());
        panache.setPassword(bo.getPassword());
        panache.setPhoneNumber(bo.getPhoneNumber());
        panache.setIsActive(bo.getIsActive());
        List<PgAddress> addresses = bo.getAddress().stream().map(PgAddressMapper::toEntity).toList();
        addresses.forEach(address -> address.setUser(panache));
        panache.setAddress(addresses);
        panache.setDateOfBirth(bo.getDateOfBirth());
        panache.setcreatedAt(bo.getCreatedAt());
        panache.setUpdateAt(bo.getUpdatedAt());

        return panache;
    }

    public static UserBO toDomain(PgUser entity) {
        var bo = new UserBO(
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
                entity.getcreatedAt(),
                entity.getUpdatedAt());

        return bo;
    }
}
