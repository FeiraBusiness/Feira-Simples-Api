package br.feira.domain.usecases.customer;

import java.util.UUID;

import br.feira.domain.entities.dtos.CustomerDTO;
import br.feira.domain.entities.mappers.CustomerMapper;
import br.feira.domain.repositories.ICustomerRepository;

public class FindCustomerBy {

    private ICustomerRepository repository;

    public FindCustomerBy(ICustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerDTO execute(UUID id) {
        var entity = repository.findById(id);

        if (entity == null) {
            // throw
        }

        return CustomerMapper.toDTO(entity);
    }

}
