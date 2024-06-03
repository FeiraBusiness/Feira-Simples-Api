package br.feira.domain.usecases.customer;

import java.util.List;
import java.util.stream.Collectors;

import br.feira.domain.entities.bo.CustomerBO;
import br.feira.domain.entities.dtos.CustomerDTO;
import br.feira.domain.entities.mappers.CustomerMapper;
import br.feira.domain.repositories.ICustomerRepository;

public class FindCustomerAll {

    private ICustomerRepository repository;

    public FindCustomerAll(ICustomerRepository repository) {
        this.repository = repository;
    }

    public List<CustomerDTO> execute() {
        List<CustomerBO> list = repository.listAll();
        
        return list.stream()
                .map(CustomerMapper::toDTO)
                .collect(Collectors.toList());
    }

}
