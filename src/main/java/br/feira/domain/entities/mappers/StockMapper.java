package br.feira.domain.entities.mappers;

import br.feira.domain.entities.bo.StockBO;
import br.feira.domain.entities.dtos.StockDTO;
import br.feira.domain.entities.dtos.StockItemDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StockMapper {

    public static StockDTO toDTO(StockBO bo) {
        StockDTO dto = new StockDTO();
        List<StockItemDTO> items = new ArrayList<>();

        if (bo.getItems() != null) {
            items = bo.getItems().stream()
                    .map(StockItemMapper::toDTO)
                    .collect(Collectors.toList());
        }

        dto.setId(bo.getId().toString());
        dto.setItems(items);
        dto.setTotalAmount(bo.getTotalAmount());
        dto.setCreateAt(bo.getCreatedAt());
        dto.setupdatedAt(bo.getUpdatedAt());

        return dto;
    }

    public static StockBO toBO(StockDTO dto) {
        return new StockBO(
                dto.getId(),
                dto.getItems().stream().map(StockItemMapper::toBO).collect(Collectors.toList()),
                dto.getTotalAmount(),
                dto.getCreatedAt(),
                dto.getUpdatedAt());
    }

}
