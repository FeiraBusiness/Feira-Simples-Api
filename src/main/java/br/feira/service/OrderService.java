package br.feira.service;

import java.util.List;
import java.util.UUID;

import br.feira.domain.entities.bo.OrderBO;
import br.feira.domain.entities.dtos.OrderDTO;
import br.feira.domain.entities.mappers.OrderMapper;
import br.feira.domain.usecases.order.CreateOrder;
import br.feira.domain.usecases.order.DeleteOrder;
import br.feira.domain.usecases.order.FindOrderAll;
import br.feira.domain.usecases.order.FindOrderBy;
import br.feira.domain.usecases.order.UpdateOrder;
import br.feira.infra.database.postgres.repositories.PgOrderRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class OrderService extends AbstractService {

    @Inject
    PgOrderRepository repository;

    @Transactional
    public OrderDTO create(OrderDTO dto) {
        var create = new CreateOrder(repository);

        return create.execute(dto);
    }

    public List<OrderDTO> listAll() {
        var list = new FindOrderAll(repository);

        return list.execute();
    }

    public OrderDTO findById(UUID id) {
        var find = new FindOrderBy(repository);

        return find.execute(id);
    }

    @Transactional
    public OrderDTO merge(UUID id, OrderDTO dto) {
        var update = new UpdateOrder(repository);

        return update.execute(id, dto);
    }

    @Transactional
    public void delete(UUID id) {
        OrderBO order = repository.findById(id);

        var dto = OrderMapper.toDTO(order);

        var delete = new DeleteOrder(repository);

        delete.execute(dto);
    }

}
