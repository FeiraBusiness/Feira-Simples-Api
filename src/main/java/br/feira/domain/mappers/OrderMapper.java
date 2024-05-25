package br.feira.domain.mappers;

import br.feira.domain.dtos.OrderDTO;
import br.feira.domain.entities.OrderBO;

import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderDTO toDTO(OrderBO bo) {
        OrderDTO dto = new OrderDTO();

        dto.setId(bo.getId().toString());
        dto.setUser(UserMapper.toDTO(bo.getUser()));
        dto.setOrderDate(bo.getDate());
        dto.setItems(bo.getItems().stream().map(OrderItemMapper::toDTO).collect(Collectors.toList()));
        dto.setEnumOrderStatus(bo.getStatus());
        dto.setCreatedAt(bo.getCreatedAt());
        dto.setUpdatedAt(bo.getUpdatedAt());

        return dto;
    }

    public static OrderBO toBO(OrderDTO dto) {
        return new OrderBO(dto.getId(), UserMapper.toBO(dto.getUser()), dto.getOrderDate(), dto.getItems().stream().map(OrderItemMapper::toBO).collect(Collectors.toList()), dto.getEnumOrderStatus(), dto.getCreatedAt(), dto.getUpdatedAt());
    }

}
