package br.feira.infra.database.postgres.mappers;

import br.feira.domain.entities.bo.AddressBO;
import br.feira.infra.database.postgres.model.PgAddress;

public class PgPaymentMapper {

    public static PgAddress toEntity(AddressBO bo) {
        var panache = new PgAddress();

        panache.setId(bo.getId());
        panache.setZipCode(bo.getZipCode());
        panache.setStreet(bo.getStreet());
        panache.setNumber(bo.getNumber());
        panache.setComplement(bo.getComplement());
        panache.setNeighborhood(bo.getNeighborhood());
        panache.setCity(bo.getCity());
        panache.setState(bo.getState());
        panache.setCountry(bo.getCountry());
        panache.setcreatedAt(bo.getcreatedAt());
        panache.setUpdatedAt(bo.getUpdatedAt());

        return panache;

    }

    public static AddressBO toDomain(PgAddress entity) {
        var addressBO = new AddressBO(
                entity.getId().toString(),
                entity.getZipCode(),
                entity.getStreet(),
                entity.getNumber(),
                entity.getComplement(),
                entity.getNeighborhood(),
                entity.getCity(),
                entity.getState(),
                entity.getCountry(),
                entity.getcreatedAt(),
                entity.getUpdatedAt());

        return addressBO;
    }

}
