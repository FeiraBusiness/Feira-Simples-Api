package br.feira.domain.repositories;

import br.feira.domain.entities.bo.PaymentBO;

import java.util.List;
import java.util.UUID;

public interface IPaymentRepository {

    PaymentBO create(PaymentBO bo);

    List<PaymentBO> listAll();

    PaymentBO findById(UUID id);

    PaymentBO merge(PaymentBO bo);

    void delete(UUID id);

}
