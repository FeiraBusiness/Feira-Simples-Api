package br.feira.service;

import java.util.List;
import java.util.UUID;

import br.feira.domain.entities.bo.PaymentBO;
import br.feira.domain.entities.dtos.PaymentDTO;
import br.feira.domain.entities.mappers.PaymentMapper;
import br.feira.domain.usecases.payment.CreatePayment;
import br.feira.domain.usecases.payment.DeletePayment;
import br.feira.domain.usecases.payment.FindPaymentBy;
import br.feira.domain.usecases.payment.FindPaymentAll;
import br.feira.domain.usecases.payment.UpdatePayment;
import br.feira.infra.database.postgres.repositories.PgPaymentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PaymentService extends AbstractService {

    @Inject
    PgPaymentRepository repository;

    @Transactional
    public PaymentDTO create(PaymentDTO dto) {
        var bo = new CreatePayment(repository);

        return bo.execute(dto);
    }

    public List<PaymentDTO> listAll() {
        var list = new FindPaymentAll(repository);

        return list.execute();
    }

    public PaymentDTO findById(UUID id) {
        var find = new FindPaymentBy(repository);

        return find.execute(id);
    }

    @Transactional
    public PaymentDTO merge(UUID id, PaymentDTO dto) {
        var update = new UpdatePayment(repository);

        return update.execute(id, dto);
    }

    @Transactional
    public void delete(UUID id) {
        PaymentBO bo = repository.findById(id);

        var dto = PaymentMapper.toDTO(bo);

        var delete = new DeletePayment(repository);

        delete.execute(dto);
    }
}
