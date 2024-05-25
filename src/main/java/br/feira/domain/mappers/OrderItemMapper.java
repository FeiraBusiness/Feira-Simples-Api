package br.feira.domain.mappers;

import br.feira.domain.dtos.OrderItemDTO;
import br.feira.domain.entities.OrderItemBO;

public class OrderItemMapper {

    public static OrderItemDTO toDTO(OrderItemBO bo) {
        OrderItemDTO dto = new OrderItemDTO();

        dto.setId(bo.getId().toString());
        dto.setQuantity(bo.getQuantity());
        dto.setUnitaryValue(bo.getPrice());
        dto.setProduct(ProductMapper.toDTO(bo.getProduct()));

        return dto;
    }

    public static OrderItemBO toBO(OrderItemDTO dto) {
        return new OrderItemBO(dto.getId(), dto.getQuantity(), dto.getUnitaryValue(),
                ProductMapper.toBO(dto.getProduct()), dto.getCreateAt(), dto.getUpdateAt());
    }
    
}
