package br.feira.infra.database.postgres.repositories;

import java.util.List;
import java.util.UUID;

import br.feira.domain.entities.bo.OrderBO;
import br.feira.domain.repositories.IOrderRepository;
import br.feira.domain.utils.MapperUtil;
import br.feira.infra.database.postgres.mappers.PgOrderMapper;
import br.feira.infra.database.postgres.model.PgOrder;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PgOrderRepository implements IOrderRepository {

    @Override
    public OrderBO create(OrderBO bo) {
        var panache = PgOrderMapper.toEntity(bo);

        panache.persist();

        return PgOrderMapper.toDomain(panache);
    }

    @Override
    public List<OrderBO> listAll() {
        List<PgOrder> list = PgOrder.listAll();

        return MapperUtil.mapList(list, PgOrderMapper::toDomain);
    }

    @Override
    public OrderBO findById(UUID id) {
        PgOrder panache = PgOrder.findById(id);

        if (panache == null) {
            throw new NotFoundException("Order ID " + id + " not found!");
        }

        return PgOrderMapper.toDomain(panache);
    }

    @Override
    public OrderBO merge(OrderBO bo) {
        PgOrder panache = PgOrderMapper.toEntity(bo);

        PgOrder.getEntityManager().merge(panache);

        return PgOrderMapper.toDomain(panache);

    }

    @Override
    public void delete(UUID id) {
        PgOrder panache = PgOrder.findById(id);

        if (panache == null) {
            throw new NotFoundException("Order not found");
        }

        panache.delete();
    }

}
