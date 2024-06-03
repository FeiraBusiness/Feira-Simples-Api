package br.feira.domain.repositories;

import java.util.List;
import java.util.UUID;

import br.feira.domain.entities.bo.CustomerBO;

public interface ICustomerRepository {

    CustomerBO create(CustomerBO bo);

    List<CustomerBO> listAll();

    CustomerBO findById(UUID id);

    CustomerBO merge(CustomerBO bo);

    void delete(UUID id);

}
