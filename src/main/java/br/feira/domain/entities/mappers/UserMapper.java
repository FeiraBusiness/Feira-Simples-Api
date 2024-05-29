package br.feira.domain.entities.mappers;

import java.util.stream.Collectors;

import br.feira.domain.entities.bo.UserBO;
import br.feira.domain.entities.dtos.UserDTO;

public class UserMapper {

    public static UserDTO toDTO(UserBO bo) {
        UserDTO dto = new UserDTO();

        dto.setId(bo.getId().toString());
        dto.setName(bo.getName());
        dto.setEmail(bo.getEmail());
        dto.setCpfCnpj(bo.getCpfCnpj());
        dto.setGender(bo.getGender());
        dto.setPassword(bo.getPassword());
        dto.setPhoneNumber(bo.getPhoneNumber());
        dto.setIsActive(bo.getIsActive());
        dto.setAddress(bo.getAddress().stream().map(AddressMapper::toDTO).collect(Collectors.toList()));
        dto.setDateOfBirth(bo.getDateOfBirth());
        dto.setCreateAt(bo.getCreatedAt());
        dto.setUpdateAt(bo.getUpdatedAt());

        return dto;
    }

    public static UserBO toBO(UserDTO dto) {
        return new UserBO(dto.getId(), dto.getName(), dto.getEmail(), dto.getCpfCnpj(), dto.getGender(),
                dto.getPassword(), dto.getPhoneNumber(), dto.getIsActive(),
                dto.getAddress().stream().map(AddressMapper::toBO).collect(Collectors.toList()), dto.getDateOfBirth(),
                dto.getCreatedAt(), dto.getUpdatedAt());
    }
}
