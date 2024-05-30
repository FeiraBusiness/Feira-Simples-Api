package br.feira.domain.usecases.payment;

import br.feira.domain.entities.bo.PaymentBO;
import br.feira.domain.entities.dtos.PaymentDTO;
import br.feira.domain.entities.mappers.PaymentMapper;
import br.feira.domain.repositories.IPaymentRepository;

import java.util.List;
import java.util.stream.Collectors;

public class FindPaymentAll {

    private IPaymentRepository repository;

    public FindPaymentAll(IPaymentRepository repository) {
        this.repository = repository;
    }

    public List<PaymentDTO> execute() {
        List<PaymentBO> list = repository.listAll();

        return list.stream()
                .map(PaymentMapper::toDTO)
                .collect(Collectors.toList());
    }
}
