package br.feira.domain.entities.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.feira.domain.entities.bo.CustomerBO;
import br.feira.domain.entities.dtos.AddressDTO;
import br.feira.domain.entities.dtos.CustomerDTO;

public class CustomerMapper {

    public static CustomerDTO toDTO(CustomerBO bo) {
        CustomerDTO dto = new CustomerDTO();
        List<AddressDTO> addresses = new ArrayList<>();

        if (bo.getAddress() != null) {
            addresses = bo.getAddress()
                    .stream()
                    .map(AddressMapper::toDTO)
                    .collect(Collectors.toList());
        }

        dto.setId(bo.getId().toString());
        dto.setName(bo.getName());
        dto.setEmail(bo.getEmail());
        dto.setCpfCnpj(bo.getCpfCnpj());
        dto.setGender(bo.getGender());
        dto.setPassword(bo.getPassword());
        dto.setPhoneNumber(bo.getPhoneNumber());
        dto.setIsActive(bo.getIsActive());
        dto.setAddress(addresses);
        dto.setDateOfBirth(bo.getDateOfBirth());
        dto.setCreateAt(bo.getCreatedAt());
        dto.setupdatedAt(bo.getUpdatedAt());

        return dto;
    }

    public static CustomerBO toBO(CustomerDTO dto) {
        List<AddressDTO> addresses = new ArrayList<>();

        if (dto.getAddress() != null) {
            throw new RuntimeException("");
        }

        return new CustomerBO(
                dto.getId(),
                dto.getName(),
                dto.getEmail(),
                dto.getCpfCnpj(),
                dto.getGender(),
                dto.getPassword(),
                dto.getPhoneNumber(),
                dto.getIsActive(),
                dto.getAddress().stream().map(AddressMapper::toBO).collect(Collectors.toList()),
                dto.getDateOfBirth(),
                dto.getCreatedAt(),
                dto.getUpdatedAt());
    }
}
