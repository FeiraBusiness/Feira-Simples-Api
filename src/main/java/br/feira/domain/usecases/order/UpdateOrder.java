package br.feira.domain.usecases.order;

import java.util.UUID;

import br.feira.domain.entities.bo.OrderBO;
import br.feira.domain.entities.dtos.OrderDTO;
import br.feira.domain.entities.mappers.CompanyMapper;
import br.feira.domain.entities.mappers.OrderMapper;
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

        bo = OrderMapper.toBO(dto);

        repository.merge(bo);

        return OrderMapper.toDTO(bo);
    }
}
