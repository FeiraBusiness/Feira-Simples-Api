package br.feira.infra.database.postgres.mappers;

import br.feira.domain.entities.bo.OrderItemBO;
import br.feira.infra.database.postgres.model.PgOrderItem;

public class PgOrderItemMapper {

    public static PgOrderItem toEntity(OrderItemBO bo) {
        var panache = new PgOrderItem();

        panache.setId(bo.getId());
        panache.setQuantity(bo.getQuantity());
        panache.setPrice(bo.getPrice());
        panache.setProduct(PgProductMapper.toEntity(bo.getProduct()));
        panache.setCreateAt(bo.getCreatedAt());
        panache.setUpdateAt(bo.getUpdatedAt());

        return panache;
    }

    public static OrderItemBO toDomain(PgOrderItem entity) {
        var bo = new OrderItemBO(
                entity.getId().toString(),
                entity.getQuantity(),
                entity.getPrice(),
                PgProductMapper.toDomain(entity.getProduct()),
                entity.getCreatedAt(),
                entity.getUpdatedAt());

        return bo;
    }
}
