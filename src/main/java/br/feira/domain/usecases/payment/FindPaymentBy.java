package br.feira.domain.usecases.payment;

import br.feira.domain.entities.dtos.PaymentDTO;
import br.feira.domain.entities.mappers.PaymentMapper;
import br.feira.domain.repositories.IPaymentRepository;

import java.util.UUID;

public class FindPaymentBy {

    private IPaymentRepository repository;

    public FindPaymentBy(IPaymentRepository repository) {
        this.repository = repository;
    }

    public PaymentDTO execute(UUID id) {
        var entity = repository.findById(id);

        if (entity == null) {
            // throw
        }

        return PaymentMapper.toDTO(entity);
    }
}
