package br.feira.infra.database.postgres.mappers;

import br.feira.domain.entities.bo.PaymentBO;
import br.feira.infra.database.postgres.model.PgPayment;

public class PgPaymentMapper {

    public static PgPayment toEntity(PaymentBO bo) {
        var panache = new PgPayment();

        panache.setId(bo.getId());
        panache.setValue(bo.getValue());
        panache.setTypePayment(bo.getPaymentType());
        panache.setcreatedAt(bo.getCreatedAt());
        panache.setupdatedAt(bo.getUpdatedAt());

        return panache;

    }

    public static PaymentBO toDomain(PgPayment entity) {
        var bo = new PaymentBO(
                entity.getId().toString(),
                entity.getValue(),
                entity.getTypePayment(),
                entity.getcreatedAt(),
                entity.getUpdatedAt());

        return bo;
    }

}
