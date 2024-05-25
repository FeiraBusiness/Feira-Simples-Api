package br.feira.domain.mappers;

import br.feira.domain.dtos.AddressDTO;
import br.feira.domain.entities.AddressBO;

public class AddressMapper {

    public static AddressDTO toDTO(AddressBO bo) {
        AddressDTO dto = new AddressDTO();

        dto.setId(bo.getId().toString());
        dto.setStreet(bo.getStreet());
        dto.setNumber(bo.getNumber());
        dto.setComplement(bo.getComplement());
        dto.setNeighborhood(bo.getNeighborhood());
        dto.setCity(bo.getCity());
        dto.setState(bo.getState());
        dto.setCountry(bo.getCountry());
        dto.setZipCode(bo.getZipCode());
        dto.setCreatedAt(bo.getCreatedAt());
        dto.setUpdatedAt(bo.getUpdatedAt());

        return dto;
    }

    public static AddressBO toBO(AddressDTO dto) {
        return new AddressBO(
                dto.getId(),
                dto.getStreet(),
                dto.getNumber(),
                dto.getComplement(),
                dto.getNeighborhood(),
                dto.getCity(),
                dto.getState(),
                dto.getCountry(),
                dto.getZipCode(),
                dto.getCreatedAt(),
                dto.getUpdatedAt());
    }

}
