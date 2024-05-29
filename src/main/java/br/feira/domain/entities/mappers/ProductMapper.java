package br.feira.domain.entities.mappers;

import br.feira.domain.entities.bo.ProductBO;
import br.feira.domain.entities.dtos.ProductDTO;

public class ProductMapper {

    public static ProductDTO toDTO(ProductBO bo) {
        ProductDTO dto = new ProductDTO();

        dto.setId(bo.getId().toString());
        dto.setCode(bo.getCode());
        dto.setName(bo.getName());
        dto.setDescription(bo.getDescription());
        dto.setValue(bo.getValue());
        dto.setCategory(bo.getCategory());
        dto.setImageUrl(bo.getImageUrl());
        dto.setWeight(bo.getWeight());
        dto.setRating(bo.getRating());
        dto.setIsActive(bo.getIsActive());
        dto.setExpirationDate(bo.getExpirationDate());
        dto.setcreatedAt(bo.getcreatedAt());
        dto.setUpdatedAt(bo.getUpdatedAt());

        return dto;
    }

    public static ProductBO toBO(ProductDTO dto) {
        return new ProductBO(
                dto.getId(),
                dto.getCode(),
                dto.getName(),
                dto.getDescription(),
                dto.getValue(),
                dto.getCategory(),
                dto.getImageUrl(),
                dto.getWeight(),
                dto.getRating(),
                dto.getIsActive(),
                dto.getExpirationDate(),
                dto.getcreatedAt(),
                dto.getUpdatedAt());
    }

}
