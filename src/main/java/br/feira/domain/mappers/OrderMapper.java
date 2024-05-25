package br.feira.domain.mappers;

import java.util.List;
import java.util.stream.Collectors;

import br.feira.domain.dtos.OrderDTO;
import br.feira.domain.dtos.OrderItemDTO;
import br.feira.domain.entities.OrderBO;

public class OrderMapper {

    public static OrderDTO toDTO(OrderBO bo) {
        OrderDTO dto = new OrderDTO();
        List<OrderItemDTO> items = null;

        if (bo.getItems() != null) {// Fazer validacao
            items = bo.getItems().stream()
                    .map(OrderItemMapper::toDTO)
                    .collect(Collectors.toList());
        }

        dto.setId(bo.getId().toString());
        dto.setUser(UserMapper.toDTO(bo.getUser()));
        dto.setItems(items);
        dto.setEnumOrderStatus(bo.getStatus());
        dto.setCreatedAt(bo.getCreatedAt());
        dto.setUpdatedAt(bo.getUpdatedAt());

        return dto;
    }

    public static OrderBO toBO(OrderDTO dto) {
        return new OrderBO(dto.getId(), UserMapper.toBO(dto.getUser()),
                dto.getItems().stream().map(OrderItemMapper::toBO).collect(Collectors.toList()),
                dto.getEnumOrderStatus(), dto.getCreatedAt(), dto.getUpdatedAt());
    }

}
