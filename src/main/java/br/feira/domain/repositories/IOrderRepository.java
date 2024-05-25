package br.feira.domain.repositories;

import java.util.List;
import java.util.UUID;

import br.feira.domain.entities.OrderBO;

public interface IOrderRepository {

    OrderBO create(OrderBO bo);

    List<OrderBO> listAll();

    OrderBO findById(UUID id);

    OrderBO update(UUID id, OrderBO bo);

    void delete(UUID id);

}
