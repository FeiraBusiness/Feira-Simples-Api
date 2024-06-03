package br.feira.service;

import br.feira.infra.database.postgres.repositories.*;
import jakarta.inject.Inject;

public abstract class AbstractService {

    @Inject
    PgCustomerRepository pgUserRepository;

    @Inject
    PgProductRepository pgProductRepository;

    @Inject
    PgPaymentRepository pgPaymentRepository;

    @Inject
    PgOrderRepository pgOrderRepository;

    @Inject
    PgSellerRepository pgSellerRepository;

    @Inject
    PgCompanyRepository pgCompanyRepository;

    @Inject
    PgBranchRepository pgBranchRepository;

    @Inject
    DbFactory dbFactory;
}
