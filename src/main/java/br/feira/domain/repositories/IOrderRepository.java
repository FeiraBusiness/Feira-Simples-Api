package br.feira.domain.repositories;

import br.feira.domain.entities.OrderBO;

import java.util.List;
import java.util.UUID;

public interface IOrderRepository {

    OrderBO create(OrderBO bo);

    List<OrderBO> listAll();

    OrderBO findById(UUID id);

    OrderBO update(UUID id, OrderBO bo);

    OrderBO delete(UUID id);

}
