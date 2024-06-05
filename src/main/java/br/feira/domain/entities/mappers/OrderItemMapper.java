package br.feira.domain.entities.mappers;

import br.feira.domain.entities.bo.OrderItemBO;
import br.feira.domain.entities.dtos.OrderItemDTO;

public class OrderItemMapper {

    public static OrderItemDTO toDTO(OrderItemBO bo) {
        OrderItemDTO dto = new OrderItemDTO();

        dto.setId(bo.getId().toString());
        dto.setQuantity(bo.getQuantity());
        dto.setUnitaryValue(bo.getPrice());
        dto.setProduct(ProductMapper.toDTO(bo.getProduct()));
        dto.setCreateAt(bo.getCreatedAt());
        dto.setupdatedAt(bo.getUpdatedAt());

        return dto;
    }

    public static OrderItemBO toBO(OrderItemDTO dto) {
        return new OrderItemBO(
                dto.getId(),
                dto.getQuantity(),
                dto.getUnitaryValue(),
                ProductMapper.toBO(dto.getProduct()),
                dto.getCreatedAt(),
                dto.getUpdatedAt());
    }

}
