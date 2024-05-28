package br.feira.domain.usecases.order;

import java.util.List;
import br.feira.domain.entities.dtos.OrderDTO;
import br.feira.domain.repositories.IOrderRepository;

public class FindOrderAll {

    private IOrderRepository repository;

    public FindOrderAll(IOrderRepository repository) {
        this.repository = repository;
    }

    public List<OrderDTO> execute() {
        return null;
    }

}
