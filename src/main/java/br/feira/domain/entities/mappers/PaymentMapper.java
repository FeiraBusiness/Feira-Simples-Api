package br.feira.domain.entities.mappers;

import br.feira.domain.entities.bo.PaymentBO;
import br.feira.domain.entities.dtos.PaymentDTO;

public class PaymentMapper {

    public static PaymentDTO toDTO(PaymentBO bo) {
        PaymentDTO dto = new PaymentDTO();

        dto.setId(bo.getId().toString());
        dto.setPaymentType(bo.getPaymentType());
        dto.setValue(bo.getValue());
        dto.setcreatedAt(bo.getCreatedAt());
        dto.setUpdatedAt(bo.getUpdatedAt());

        return dto;
    }

    public static PaymentBO toBO(PaymentDTO dto) {
        return new PaymentBO(
                dto.getId(),
                dto.getValue(),
                dto.getPaymentType(),
                dto.getcreatedAt(),
                dto.getUpdatedAt());
    }

}
