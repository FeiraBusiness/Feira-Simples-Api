package br.feira.domain.entities.mappers;

import br.feira.domain.entities.bo.StockItemBO;
import br.feira.domain.entities.dtos.StockItemDTO;

public class StockItemMapper {

    public static StockItemDTO toDTO(StockItemBO bo) {
        StockItemDTO dto = new StockItemDTO();

        dto.setId(bo.getId().toString());
        dto.setUnitQuantity(bo.getUnitQuantity());
        dto.setcreatedAt(bo.getcreatedAt());
        dto.setUpdateAt(bo.getUpdatedAt());


        return dto;
    }

    public static StockItemBO toBO(StockItemDTO dto) {
        return new StockItemBO(
                dto.getId(),
                dto.getUnitQuantity(),
                dto.getcreatedAt(),
                dto.getUpdatedAt());

    }

}
