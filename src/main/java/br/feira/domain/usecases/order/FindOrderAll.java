package br.feira.domain.usecases.order;

import java.util.List;
import java.util.stream.Collectors;

import br.feira.domain.entities.bo.OrderBO;
import br.feira.domain.entities.dtos.OrderDTO;
import br.feira.domain.entities.mappers.OrderMapper;
import br.feira.domain.repositories.IOrderRepository;

public class FindOrderAll {

    private IOrderRepository repository;

    public FindOrderAll(IOrderRepository repository) {
        this.repository = repository;
    }

    public List<OrderDTO> execute() {
        List<OrderBO> list = repository.listAll();

        return list.stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
    }

}
