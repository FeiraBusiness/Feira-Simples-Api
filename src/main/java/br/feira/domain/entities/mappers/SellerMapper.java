package br.feira.domain.entities.mappers;

import br.feira.domain.entities.bo.SellerBO;
import br.feira.domain.entities.dtos.SellerDTO;

public class SellerMapper {

    public static SellerDTO toDTO(SellerBO bo) {
        SellerDTO dto = new SellerDTO();

        dto.setId(bo.getId().toString());
        dto.setName(bo.getName());
        dto.setEmail(bo.getEmail());
        dto.setCpfCnpj(bo.getCpfCnpj());
        dto.setGender(bo.getGender());
        dto.setPassword(bo.getPassword());
        dto.setPhoneNumber(bo.getPhoneNumber());
        dto.setimageUrl(bo.getimageUrl());
        dto.setIsActive(bo.getIsActive());
        dto.setDateOfBirth(bo.getDateOfBirth());
        dto.setcreatedAt(bo.getcreatedAt());
        dto.setUpdatedAt(bo.getUpdatedAt());

        return dto;
    }

    public static SellerBO toBO(SellerDTO dto) {
        return new SellerBO(
                dto.getId(),
                dto.getName(),
                dto.getEmail(),
                dto.getCpfCnpj(),
                dto.getGender(),
                dto.getPassword(),
                dto.getPhoneNumber(),
                dto.getimageUrl(),
                dto.getIsActive(),
                dto.getDateOfBirth(),
                dto.getcreatedAt(),
                dto.getUpdatedAt());
    }

}
