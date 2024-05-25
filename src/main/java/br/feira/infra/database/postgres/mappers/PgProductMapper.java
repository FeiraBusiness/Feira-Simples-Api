package br.feira.infra.database.postgres.mappers;

import br.feira.domain.entities.ProductBO;
import br.feira.infra.database.postgres.model.PgProduct;

public class PgProductMapper {

    public static PgProduct toEntity(ProductBO bo) {
        var panache = new PgProduct();

        panache.setId(bo.getId());
        panache.setCode(bo.getCode());
        panache.setName(bo.getName());
        panache.setDescription(bo.getDescription());
        panache.setValue(bo.getValue());
        panache.setCategory(bo.getCategory());
        panache.setStockBalance(bo.getStockBalance());
        panache.setImageUrl(bo.getImageUrl());
        panache.setWeight(bo.getWeight());
        panache.setDiscount(bo.getDiscount());
        panache.setRating(bo.getRating());
        panache.setIsActive(bo.getIsActive());
        panache.setExpirationDate(bo.getExpirationDate());
        panache.setCreatedAt(bo.getCreatedAt());
        panache.setUpdatedAt(bo.getUpdatedAt());

        return panache;
    }

    public static ProductBO toDomain(PgProduct entity) {
        var bo = new ProductBO(
                entity.getId().toString(),
                entity.getCode(),
                entity.getName(),
                entity.getDescription(),
                entity.getValue(),
                entity.getCategory(),
                entity.getStockBalance(),
                entity.getImageUrl(),
                entity.getWeight(),
                entity.getDiscount(),
                entity.getRating(),
                entity.getIsActive(),
                entity.getExpirationDate(),
                entity.getCreatedAt(),
                entity.getUpdatedAt());

        return bo;
    }

}
