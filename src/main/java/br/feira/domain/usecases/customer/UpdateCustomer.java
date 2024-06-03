package br.feira.domain.usecases.customer;

import java.util.UUID;

import br.feira.domain.entities.bo.CustomerBO;
import br.feira.domain.entities.dtos.CustomerDTO;
import br.feira.domain.entities.mappers.CustomerMapper;
import br.feira.domain.repositories.ICustomerRepository;

public class UpdateCustomer {

    private ICustomerRepository repository;

    public UpdateCustomer(ICustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerDTO execute(UUID id, CustomerDTO dto) {
        CustomerBO bo = repository.findById(id);

        if (bo == null) {
            throw new RuntimeException("Opa! Registro não encontrado");

        }

        bo = CustomerMapper.toBO(dto);

        repository.merge(bo);

        return CustomerMapper.toDTO(bo);
    }
}
