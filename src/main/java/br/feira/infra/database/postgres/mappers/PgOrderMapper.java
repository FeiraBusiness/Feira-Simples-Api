package br.feira.infra.database.postgres.mappers;

import java.util.List;
import java.util.stream.Collectors;

import br.feira.domain.entities.bo.OrderBO;
import br.feira.infra.database.postgres.model.PgOrder;
import br.feira.infra.database.postgres.model.PgOrderItem;

public class PgOrderMapper {

    public static PgOrder toEntity(OrderBO bo) {
        var panache = new PgOrder();
        List<PgOrderItem> items = bo.getItems().stream()
                .map(PgOrderItemMapper::toEntity)
                .toList();

        items.forEach(item -> item.setOrder(panache));

        panache.setId(bo.getId());
        panache.setUser(PgUserMapper.toEntity(bo.getUser()));
        panache.setItems(items);
        panache.setStatus(bo.getStatus());
        panache.setCreatedAt(bo.getCreatedAt());
        panache.setUpdatedAt(bo.getUpdatedAt());

        return panache;
    }

    public static OrderBO toDomain(PgOrder entity) {
        var bo = new OrderBO(
                entity.getId().toString(),
                PgUserMapper.toDomain(entity.getUser()),
                entity.getItems().stream().map(PgOrderItemMapper::toDomain).collect(Collectors.toList()),
                entity.getStatus(),
                entity.getCreatedAt(),
                entity.getUpdatedAt());

        return bo;
    }
}
