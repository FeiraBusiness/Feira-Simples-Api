package br.feira.domain.entities.mappers;

import java.util.List;
import java.util.stream.Collectors;

import br.feira.domain.entities.bo.OrderBO;
import br.feira.domain.entities.dtos.OrderDTO;
import br.feira.domain.entities.dtos.OrderItemDTO;

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
        dto.setCustomer(CustomerMapper.toDTO(bo.getCustomer()));
        dto.setItems(items);
        dto.setEnumOrderStatus(bo.getStatus());
        dto.setcreatedAt(bo.getcreatedAt());
        dto.setUpdatedAt(bo.getUpdatedAt());

        return dto;
    }

    public static OrderBO toBO(OrderDTO dto) {
        return new OrderBO(
                dto.getId(),
                CustomerMapper.toBO(dto.getCustomer()),
                dto.getItems().stream().map(OrderItemMapper::toBO).collect(Collectors.toList()),
                dto.getEnumOrderStatus(),
                dto.getcreatedAt(),
                dto.getUpdatedAt());
    }

}
