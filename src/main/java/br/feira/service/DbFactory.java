package br.feira.service;

import br.feira.domain.entities.enums.EnumDBImpl;
import br.feira.domain.repositories.ICustomerRepository;
import io.quarkus.arc.All;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class DbFactory {

    @All
    private List<ICustomerRepository> implementations;

    private static final Map<EnumDBImpl, ICustomerRepository> serviceCache = new HashMap<>();

    public ICustomerRepository getImpl(EnumDBImpl impl) {
        ICustomerRepository repository = serviceCache.get(impl);

        if (repository == null) {
            throw new RuntimeException("dbImpl");
        }

        return repository;
    }

}
