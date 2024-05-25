package br.feira.domain.usecases.order;

import br.feira.domain.dtos.OrderDTO;
import br.feira.domain.entities.OrderBO;
import br.feira.domain.mappers.OrderMapper;
import br.feira.domain.repositories.IOrderRepository;

import java.util.UUID;

public class DeleteOrder {

    private IOrderRepository repository;

    public DeleteOrder(IOrderRepository repository) {
        this.repository = repository;
    }

    public OrderDTO execute(OrderDTO dto) {
        OrderBO bo = repository.delete(dto.getId().transform(UUID::fromString));

        return OrderMapper.toDTO(bo);
    }
}
