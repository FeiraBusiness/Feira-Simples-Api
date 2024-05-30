package br.feira.domain.usecases.payment;

import br.feira.domain.entities.dtos.PaymentDTO;
import br.feira.domain.repositories.IPaymentRepository;

import java.util.UUID;

public class DeletePayment {

    private IPaymentRepository repository;

    public DeletePayment(IPaymentRepository repository) {
        this.repository = repository;
    }

    public void execute(PaymentDTO dto) {
        repository.delete(dto.getId().transform(UUID::fromString));
    }

}
