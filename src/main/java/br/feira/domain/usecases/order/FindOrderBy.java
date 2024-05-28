package br.feira.domain.usecases.order;

import java.util.UUID;

import br.feira.domain.entities.dtos.OrderDTO;
import br.feira.domain.entities.mappers.OrderMapper;
import br.feira.domain.repositories.IOrderRepository;

public class FindOrderBy {

    private IOrderRepository repository;

    public FindOrderBy(IOrderRepository repository) {
        this.repository = repository;
    }

    public OrderDTO execute(UUID id) {
        var entity = repository.findById(id);

        if (entity == null) {
            // throw
        }

        return OrderMapper.toDTO(entity);
    }

}
