package br.feira.infra.database.postgres.mappers;

import br.feira.domain.entities.OrderBO;
import br.feira.infra.database.postgres.model.PgOrder;
import br.feira.infra.database.postgres.model.PgOrderItem;

import java.util.List;
import java.util.stream.Collectors;

public class PgOrderMapper {

    public static PgOrder toEntity(OrderBO bo) {
        var panache = new PgOrder();

        panache.setId(bo.getId());
        panache.setUser(PgUserMapper.toEntity(bo.getUser()));
        panache.setDate(bo.getDate());
        List<PgOrderItem> items = bo.getItems().stream().map(PgOrderItemMapper::toEntity).toList();
        items.forEach(address -> address.setOrder(panache));
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
                entity.getDate(),
                entity.getItems().stream().map(PgOrderItemMapper::toDomain).collect(Collectors.toList()),
                entity.getStatus(),
                entity.getCreatedAt(),
                entity.getUpdatedAt());

        return bo;
    }
}
