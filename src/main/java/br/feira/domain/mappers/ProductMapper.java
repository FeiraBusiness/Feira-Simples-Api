package br.feira.domain.mappers;

import br.feira.domain.dtos.ProductDTO;
import br.feira.domain.entities.ProductBO;

public class ProductMapper {

    public static ProductDTO toDTO(ProductBO bo) {
        ProductDTO dto = new ProductDTO();

        dto.setId(bo.getId().toString());
        dto.setCode(bo.getCode());
        dto.setName(bo.getName());
        dto.setDescription(bo.getDescription());
        dto.setValue(bo.getValue());
        dto.setCategory(bo.getCategory());
        dto.setStockBalance(bo.getStockBalance());
        dto.setImageUrl(bo.getImageUrl());
        dto.setWeight(bo.getWeight());
        dto.setDiscount(bo.getDiscount());
        dto.setRating(bo.getRating());
        dto.setIsActive(bo.getIsActive());
        dto.setExpirationDate(bo.getExpirationDate());
        dto.setCreatedAt(bo.getCreatedAt());
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
                dto.getStockBalance(),
                dto.getImageUrl(),
                dto.getWeight(),
                dto.getDiscount(),
                dto.getRating(),
                dto.getIsActive(),
                dto.getExpirationDate(),
                dto.getCreatedAt(),
                dto.getUpdatedAt());
    }

}
