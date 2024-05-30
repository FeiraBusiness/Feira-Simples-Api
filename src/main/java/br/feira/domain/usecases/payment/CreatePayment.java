package br.feira.domain.usecases.payment;

import br.feira.domain.entities.bo.PaymentBO;
import br.feira.domain.entities.dtos.PaymentDTO;
import br.feira.domain.entities.mappers.PaymentMapper;
import br.feira.domain.repositories.IPaymentRepository;

public class CreatePayment {

    private IPaymentRepository repository;

    public CreatePayment(IPaymentRepository repository) {
        this.repository = repository;
    }

    public PaymentDTO execute(PaymentDTO dto) {
        PaymentBO bo = PaymentMapper.toBO(dto);

        bo = repository.create(bo);

        return PaymentMapper.toDTO(bo);
    }
}
