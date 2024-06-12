package br.feira.domain.entities.mappers;

import br.feira.domain.entities.bo.OrderBO;
import br.feira.domain.entities.dtos.OrderDTO;
import br.feira.domain.entities.dtos.OrderItemDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderDTO toDTO(OrderBO bo) {
        OrderDTO dto = new OrderDTO();
        List<OrderItemDTO> items = new ArrayList<>();

        if (bo.getItems() != null) {
            items = bo.getItems().stream()
                    .map(OrderItemMapper::toDTO)
                    .collect(Collectors.toList());
        }

        dto.setId(bo.getId().toString());
        dto.setCustomer(bo.getCustomer());
        dto.setSeller(bo.getSeller());
        dto.setDiscount(bo.getDiscount());
        dto.setIncrease(bo.getIncrease());
        dto.setNetValue(bo.getNetValue());
        dto.setItems(items);
        dto.setEnumOrderStatus(bo.getStatus());
        dto.setcreatedAt(bo.getcreatedAt());
        dto.setUpdatedAt(bo.getUpdatedAt());

        return dto;
    }

    public static OrderBO toBO(OrderDTO dto) {
        return new OrderBO(
                dto.getId(),
                dto.getCustomer(),
                dto.getSeller(),
                dto.getDiscount(),
                dto.getIncrease(),
                dto.getNetValue(),
                dto.getItems().stream().map(OrderItemMapper::toBO).collect(Collectors.toList()),
                dto.getEnumOrderStatus(),
                dto.getcreatedAt(),
                dto.getUpdatedAt());
    }

}
