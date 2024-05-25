package br.feira.domain.usecases.order;

import java.util.UUID;

import br.feira.domain.dtos.OrderDTO;
import br.feira.domain.entities.OrderBO;
import br.feira.domain.mappers.OrderMapper;
import br.feira.domain.repositories.IOrderRepository;

public class UpdateOrder {

    private IOrderRepository repository;

    public UpdateOrder(IOrderRepository repository) {
        this.repository = repository;
    }

    public OrderDTO execute(UUID id, OrderDTO dto) {
        OrderBO bo = repository.findById(id);

        if (bo == null) {
            throw new RuntimeException("Opa! Registro não encontrado");
        }

        bo = repository.update(id, bo);

        return OrderMapper.toDTO(bo);
    }
}
