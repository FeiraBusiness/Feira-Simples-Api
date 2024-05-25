package br.feira.service;

import br.feira.domain.dtos.OrderDTO;
import br.feira.domain.entities.OrderBO;
import br.feira.domain.mappers.OrderMapper;
import br.feira.domain.usecases.order.CreateOrder;
import br.feira.domain.usecases.order.DeleteOrder;
import br.feira.domain.usecases.order.UpdateOrder;
import br.feira.infra.database.postgres.repositories.PgOrderRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class OrderService extends AbstractService {

    @Inject
    PgOrderRepository repository;

    @Transactional
    public OrderDTO create(OrderDTO dto) {
        var create = new CreateOrder(repository);

        return create.execute(dto);
    }

    public List<OrderBO> listAll() {
        return repository.listAll();
    }

    public OrderBO findById(UUID id) {
        return repository.findById(id);
    }

    @Transactional
    public OrderDTO update(UUID id, OrderDTO dto) {
        var update = new UpdateOrder(repository);

        return update.execute(id, dto);
    }

    @Transactional
    public OrderDTO delete(UUID id) {
        OrderBO order = repository.findById(id);

        var dto = OrderMapper.toDTO(order);

        var delete = new DeleteOrder(repository);

        return delete.execute(dto);
    }

}
