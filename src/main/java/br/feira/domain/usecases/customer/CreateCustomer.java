package br.feira.domain.usecases.customer;

import br.feira.domain.entities.bo.CustomerBO;
import br.feira.domain.entities.dtos.CustomerDTO;
import br.feira.domain.entities.mappers.CustomerMapper;
import br.feira.domain.repositories.ICustomerRepository;

public class CreateCustomer {

    private ICustomerRepository repository;

    public CreateCustomer(ICustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerDTO execute(CustomerDTO dto) {
        CustomerBO bo = CustomerMapper.toBO(dto);

        bo = repository.create(bo);

        return CustomerMapper.toDTO(bo);
    }

}