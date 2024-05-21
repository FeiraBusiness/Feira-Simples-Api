package br.feira.infra.database.postgres.mappers;

import br.feira.domain.entities.AddressBO;
import br.feira.infra.database.postgres.model.PgAddress;

public class PgAddressMapper {

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
                entity.getCreatedAt(),
                entity.getUpdatedAt());

        return addressBO;
    }

    public static PgAddress toEntity(AddressBO bo) {
        var panacheAddress = new PgAddress();

        panacheAddress.setId(bo.getId());
        panacheAddress.setZipCode(bo.getZipCode());
        panacheAddress.setStreet(bo.getStreet());
        panacheAddress.setNumber(bo.getNumber());
        panacheAddress.setComplement(bo.getComplement());
        panacheAddress.setNeighborhood(bo.getNeighborhood());
        panacheAddress.setCity(bo.getCity());
        panacheAddress.setState(bo.getState());
        panacheAddress.setCountry(bo.getCountry());
        panacheAddress.setCreatedAt(bo.getCreatedAt());
        panacheAddress.setUpdatedAt(bo.getUpdatedAt());

        return panacheAddress;

    }

}
