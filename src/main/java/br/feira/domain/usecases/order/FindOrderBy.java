package br.feira.domain.usecases.order;

import java.util.UUID;

import br.feira.domain.dtos.OrderDTO;
import br.feira.domain.mappers.OrderMapper;
import br.feira.domain.repositories.IOrderRepository;

public class FindOrderBy {

    private IOrderRepository repository;

    public FindOrderBy(IOrderRepository repository) {
        this.repository = repository;
    }

    public OrderDTO execute(UUID id) {
        var order = repository.findById(id);

        if (order == null) {
            //throw
        }

        return OrderMapper.toDTO(order);
    }

}
