package br.feira.domain.usecases.customer;

import java.util.UUID;

import br.feira.domain.entities.dtos.CustomerDTO;
import br.feira.domain.repositories.ICustomerRepository;

public class DeleteCustomer {

    private ICustomerRepository repository;

    public DeleteCustomer(ICustomerRepository repository) {
        this.repository = repository;
    }

    public void execute(CustomerDTO dto) {
        repository.delete(dto.getId().transform(UUID::fromString));
    }

}
