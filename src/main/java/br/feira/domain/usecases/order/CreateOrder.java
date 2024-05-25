package br.feira.domain.usecases.order;

import br.feira.domain.dtos.OrderDTO;
import br.feira.domain.entities.OrderBO;
import br.feira.domain.mappers.OrderMapper;
import br.feira.domain.repositories.IOrderRepository;

public class CreateOrder {

    private IOrderRepository repository;

    public CreateOrder(IOrderRepository repository) {
        this.repository = repository;
    }

    public OrderDTO execute(OrderDTO dto) {
        OrderBO bo = OrderMapper.toBO(dto);

        bo = repository.create(bo);

        return OrderMapper.toDTO(bo);
    }

}
