package br.feira.domain.usecases.payment;

import br.feira.domain.entities.bo.PaymentBO;
import br.feira.domain.entities.dtos.PaymentDTO;
import br.feira.domain.entities.mappers.PaymentMapper;
import br.feira.domain.repositories.IPaymentRepository;

import java.util.UUID;

public class UpdatePayment {

    private IPaymentRepository repository;

    public UpdatePayment(IPaymentRepository repository) {
        this.repository = repository;
    }

    public PaymentDTO execute(UUID id, PaymentDTO dto) {
        PaymentBO bo = repository.findById(id);

        if (bo == null) {
            throw new RuntimeException("Opa! Registro não encontrado");
        }

        bo = repository.merge(bo);

        return PaymentMapper.toDTO(bo);
    }
}
