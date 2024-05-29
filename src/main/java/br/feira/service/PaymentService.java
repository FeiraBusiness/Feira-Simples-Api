package br.feira.service;

import br.feira.domain.entities.bo.PaymentBO;
import br.feira.domain.repositories.IPaymentRepository;

import java.util.List;
import java.util.UUID;

public class PaymentService implements IPaymentRepository {

    @Override
    public PaymentBO create(PaymentBO bo) {
        return null;
    }

    @Override
    public List<PaymentBO> listAll() {
        return null;
    }

    @Override
    public PaymentBO findById(UUID id) {
        return null;
    }

    @Override
    public PaymentBO merge(PaymentBO bo) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
