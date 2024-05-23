package br.feira.service;

import br.feira.infra.database.postgres.repositories.PgProductRepository;
import br.feira.infra.database.postgres.repositories.PgUserRepository;
import jakarta.inject.Inject;

public abstract class AbstractService {

    @Inject
    PgUserRepository pgUserRepository;

    @Inject
    PgProductRepository pgProductRepository;

    @Inject
    DbFactory dbFactory;
}
