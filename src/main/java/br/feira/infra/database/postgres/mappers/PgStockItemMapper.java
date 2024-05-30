package br.feira.infra.database.postgres.mappers;

import br.feira.domain.entities.bo.StockItemBO;
import br.feira.infra.database.postgres.model.PgStockItem;

public class PgStockItemMapper {

    public static PgStockItem toEntity(StockItemBO bo) {
        var panache = new PgStockItem();

        panache.setId(bo.getId());
        panache.setProduct(PgProductMapper.toEntity(bo.getProduct()));
        panache.setUnitQuantity(bo.getUnitQuantity());
        panache.setcreatedAt(bo.getCreatedAt());
        panache.setupdatedAt(bo.getUpdatedAt());

        return panache;

    }

    public static StockItemBO toDomain(PgStockItem entity) {
        var bo = new StockItemBO(
                entity.getId().toString(),
                PgProductMapper.toDomain(entity.getProduct()),
                entity.getUnitQuantity(),
                entity.getcreatedAt(),
                entity.getUpdatedAt());

        return bo;
    }

}
