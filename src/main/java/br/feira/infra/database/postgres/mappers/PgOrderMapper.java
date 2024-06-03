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
        panache.setCustomer(PgCustomerMapper.toEntity(bo.getCustomer()));
        panache.setSeller(PgSellerMapper.toEntity(bo.getSeller()));
        panache.setDiscount(bo.getDiscount());
        panache.setIncrease(bo.getIncrease());
        panache.setNetValue(bo.getNetValue());
        panache.setItems(items);
        panache.setStatus(bo.getStatus());
        panache.setcreatedAt(bo.getcreatedAt());
        panache.setUpdatedAt(bo.getUpdatedAt());

        return panache;
    }

    public static OrderBO toDomain(PgOrder entity) {
        var bo = new OrderBO(
                entity.getId().toString(),
                PgCustomerMapper.toDomain(entity.getCustomer()),
                PgSellerMapper.toDomain(entity.getSeller()),
                entity.getDiscount(),
                entity.getIncrease(),
                entity.getNetValue(),
                entity.getItems().stream().map(PgOrderItemMapper::toDomain).collect(Collectors.toList()),
                entity.getStatus(),
                entity.getcreatedAt(),
                entity.getUpdatedAt());

        return bo;
    }
}
