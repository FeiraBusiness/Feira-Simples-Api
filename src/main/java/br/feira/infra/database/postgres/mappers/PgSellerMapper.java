package br.feira.infra.database.postgres.mappers;

import br.feira.domain.entities.bo.SellerBO;
import br.feira.infra.database.postgres.model.PgSeller;

public class PgSellerMapper {

    public static PgSeller toEntity(SellerBO bo) {
        var panache = new PgSeller();

        panache.setId(bo.getId());
        panache.setName(bo.getName());
        panache.setEmail(bo.getEmail());
        panache.setCpfCnpj(bo.getCpfCnpj());
        panache.setGender(bo.getGender());
        panache.setPassword(bo.getPassword());
        panache.setPhoneNumber(bo.getPhoneNumber());
        panache.setIsActive(bo.getIsActive());
        panache.setDateOfBirth(bo.getDateOfBirth());
        panache.setcreatedAt(bo.getcreatedAt());
        panache.setupdatedAt(bo.getUpdatedAt());

        return panache;
    }

    public static SellerBO toDomain(PgSeller entity) {
        var bo = new SellerBO(
                entity.getId().toString(),
                entity.getName(),
                entity.getEmail(),
                entity.getCpfCnpj(),
                entity.getGender(),
                entity.getPassword(),
                entity.getPhoneNumber(),
                entity.getIsActive(),
                entity.getDateOfBirth(),
                entity.getcreatedAt(),
                entity.getUpdatedAt());

        return bo;
    }

}
