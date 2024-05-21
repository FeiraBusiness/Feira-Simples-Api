package br.feira.service;

import br.feira.domain.enums.EnumDBImpl;
import br.feira.domain.repositories.IUserRepository;
import io.quarkus.arc.All;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class DbFactory {

    @All
    private List<IUserRepository> implementations;

    private static final Map<EnumDBImpl, IUserRepository> serviceCache = new HashMap<>();

    public IUserRepository getImpl(EnumDBImpl impl) {
        IUserRepository repository = serviceCache.get(impl);

        if (repository == null) {
            throw new RuntimeException("dbImpl");
        }

        return repository;
    }

}
