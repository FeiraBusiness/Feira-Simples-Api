package br.feira.domain.mappers;

import br.feira.domain.dtos.AddressDTO;
import br.feira.domain.entities.AddressBO;

public class AddressMapper {

    public static AddressDTO toDTO(AddressBO bo) {
        AddressDTO address = new AddressDTO();

        address.setId(bo.getId().toString());
        address.setStreet(bo.getStreet());
        address.setNumber(bo.getNumber());
        address.setComplement(bo.getComplement());
        address.setNeighborhood(bo.getNeighborhood());
        address.setCity(bo.getCity());
        address.setState(bo.getState());
        address.setCountry(bo.getCountry());
        address.setZipCode(bo.getZipCode());
        address.setCreatedAt(bo.getCreatedAt());
        address.setUpdatedAt(bo.getUpdatedAt());

        return address;
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
