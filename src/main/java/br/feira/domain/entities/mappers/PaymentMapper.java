package br.feira.domain.entities.mappers;

import br.feira.domain.entities.bo.PaymentBO;
import br.feira.domain.entities.dtos.PaymentDTO;

public class PaymentMapper {

    public static PaymentDTO toDTO(PaymentBO bo) {
        PaymentDTO dto = new PaymentDTO();

        dto.setId(bo.getId().toString());
        dto.setStaus(bo.getStaus());
        dto.setValue(bo.getValue());
        dto.setcreatedAt(bo.getcreatedAt());
        dto.setUpdatedAt(bo.getUpdatedAt());

        return dto;
    }

    public static PaymentBO toBO(PaymentDTO dto) {
        return new PaymentBO(
                dto.getId(),
                dto.getStaus(),
                dto.getValue(),
                dto.getcreatedAt(),
                dto.getUpdatedAt());
    }

}
