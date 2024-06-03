package br.feira.service;

import java.util.List;
import java.util.UUID;

import br.feira.domain.entities.bo.CustomerBO;
import br.feira.domain.entities.dtos.CustomerDTO;
import br.feira.domain.entities.mappers.CustomerMapper;
import br.feira.domain.usecases.customer.CreateCustomer;
import br.feira.domain.usecases.customer.DeleteCustomer;
import br.feira.domain.usecases.customer.FindCustomerAll;
import br.feira.domain.usecases.customer.FindCustomerBy;
import br.feira.domain.usecases.customer.UpdateCustomer;
import br.feira.infra.database.postgres.repositories.PgCustomerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CustomerService extends AbstractService {

    @Inject
    PgCustomerRepository repository;

    @Transactional
    public CustomerDTO create(CustomerDTO dto) {
        var create = new CreateCustomer(repository);

        return create.execute(dto);
    }

    public List<CustomerDTO> listAll() {
        var list = new FindCustomerAll(repository);

        return list.execute();

    }

    public CustomerDTO findById(UUID id) {
        var findById = new FindCustomerBy(repository);

        return findById.execute(id);
    }

    @Transactional
    public CustomerDTO merge(UUID id, CustomerDTO dto) {
        var update = new UpdateCustomer(repository);

        return update.execute(id, dto);
    }

    @Transactional
    public void delete(UUID id) {
        CustomerBO user = repository.findById(id);

        var dto = CustomerMapper.toDTO(user);

        var delete = new DeleteCustomer(repository);

        delete.execute(dto);
    }
}
