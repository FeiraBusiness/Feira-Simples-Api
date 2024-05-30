package br.feira.infra.database.postgres.repositories;

import br.feira.domain.entities.bo.PaymentBO;
import br.feira.domain.repositories.IPaymentRepository;
import br.feira.infra.database.postgres.mappers.PgPaymentMapper;
import br.feira.infra.database.postgres.model.PgPayment;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped

public class PgPaymentRepository implements IPaymentRepository {


    @Override
    public PaymentBO create(PaymentBO bo) {
        var panache = PgPaymentMapper.toEntity(bo);

        panache.persist();

        return PgPaymentMapper.toDomain(panache);
    }

    @Override
    public List<PaymentBO> listAll() {
        List<PgPayment> list = PgPayment.listAll();

        // Criar uma função para fazer isso sem precisar usar duas vezes o mapper;
        return list.stream().map(PgPaymentMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public PaymentBO findById(UUID id) {
        PgPayment panache = PgPayment.findById(id);

        if (panache == null) {
            throw new NotFoundException("Payment ID " + id + " not found!");
        }

        return PgPaymentMapper.toDomain(panache);
    }

    @Override
    public PaymentBO merge(PaymentBO bo) {
        PgPayment panache = PgPaymentMapper.toEntity(bo);

        panache.persist();

        return PgPaymentMapper.toDomain(panache);
    }

    @Override
    public void delete(UUID id) {
        PgPayment panache = PgPayment.findById(id);

        if (panache == null) {
            throw new NotFoundException("Payment not found");
        }

        panache.delete();

    }
}
