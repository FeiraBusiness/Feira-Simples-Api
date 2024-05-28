package br.feira.domain.usecases.order;

import java.util.UUID;

import br.feira.domain.entities.dtos.OrderDTO;
import br.feira.domain.repositories.IOrderRepository;

public class DeleteOrder {

    private IOrderRepository repository;

    public DeleteOrder(IOrderRepository repository) {
        this.repository = repository;
    }

    public void execute(OrderDTO dto) {
        repository.delete(dto.getId().transform(UUID::fromString));
    }
}
