package br.feira.domain.entities.mappers;

import br.feira.domain.entities.bo.StockItemBO;
import br.feira.domain.entities.dtos.StockItemDTO;

public class StockItemMapper {

    public static StockItemDTO toDTO(StockItemBO bo) {
        StockItemDTO dto = new StockItemDTO();

        dto.setId(bo.getId().toString());
        dto.setProduct(ProductMapper.toDTO(bo.getProduct()));
        dto.setUnitQuantity(bo.getUnitQuantity());
        dto.setcreatedAt(bo.getCreatedAt());
        dto.setupdatedAt(bo.getUpdatedAt());


        return dto;
    }

    public static StockItemBO toBO(StockItemDTO dto) {
        return new StockItemBO(
                dto.getId(),
                ProductMapper.toBO(dto.getProduct()),
                dto.getUnitQuantity(),
                dto.getcreatedAt(),
                dto.getUpdatedAt());

    }

}
