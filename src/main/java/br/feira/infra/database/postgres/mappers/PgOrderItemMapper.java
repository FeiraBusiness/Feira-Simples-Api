package br.feira.infra.database.postgres.mappers;

import br.feira.domain.entities.OrderItemBO;
import br.feira.infra.database.postgres.model.PgOrderItem;

public class PgOrderItemMapper {

    public static PgOrderItem toEntity(OrderItemBO bo) {
        var panache = new PgOrderItem();

        panache.setId(bo.getId());
//        panache.setOrder(PgOrderMapper.toEntity(bo.getOrder()));
        panache.setQuantity(bo.getQuantity());
        panache.setPrice(bo.getPrice());
        panache.setProduct(PgProductMapper.toEntity(bo.getProduct()));
        panache.setCreateAt(bo.getCreateAt());
        panache.setUpdateAt(bo.getUpdateAt());

        return panache;
    }

    public static OrderItemBO toDomain(PgOrderItem entity) {
        var bo = new OrderItemBO(
                entity.getId().toString(),
//                PgOrderMapper.toDomain(entity.getOrder()),
                entity.getQuantity(),
                entity.getPrice(),
                PgProductMapper.toDomain(entity.getProduct()),
                entity.getCreateAt(),
                entity.getUpdateAt());

        return bo;
    }
}
