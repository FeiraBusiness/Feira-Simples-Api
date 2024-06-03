package br.feira.infra.database.postgres.mappers;

import br.feira.domain.entities.bo.CustomerBO;
import br.feira.infra.database.postgres.model.PgAddress;
import br.feira.infra.database.postgres.model.PgCustomer;

import java.util.List;
import java.util.stream.Collectors;

public class PgCustomerMapper {

    public static PgCustomer toEntity(CustomerBO bo) {
        var panache = new PgCustomer();

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
        panache.setupdatedAt(bo.getUpdatedAt());

        return panache;
    }

    public static CustomerBO toDomain(PgCustomer entity) {
        var bo = new CustomerBO(
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
