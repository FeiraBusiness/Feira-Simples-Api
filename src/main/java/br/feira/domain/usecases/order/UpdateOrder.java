package br.feira.domain.usecases.order;

import br.feira.domain.dtos.OrderDTO;
import br.feira.domain.entities.OrderBO;
import br.feira.domain.mappers.OrderMapper;
import br.feira.domain.repositories.IOrderRepository;

import java.util.UUID;

public class UpdateOrder {

    private IOrderRepository repository;

    public UpdateOrder(IOrderRepository repository) {
        this.repository = repository;
    }

    public OrderDTO execute(UUID id, OrderDTO dto) {
        OrderBO bo = OrderMapper.toBO(dto);

        bo = repository.update(id, bo);

        return OrderMapper.toDTO(bo);
    }
}
