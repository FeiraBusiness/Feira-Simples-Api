package br.feira.domain.mappers;

import br.feira.domain.dtos.UserDTO;
import br.feira.domain.entities.UserBO;

import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO toDTO(UserBO bo) {
        UserDTO user = new UserDTO();

        user.setId(bo.getId().toString());
        user.setName(bo.getName());
        user.setEmail(bo.getEmail());
        user.setCpfCnpj(bo.getCpfCnpj());
        user.setGender(bo.getGender());
        user.setPassword(bo.getPassword());
        user.setPhoneNumber(bo.getPhoneNumber());
        user.setIsActive(bo.getIsActive());
        user.setAddress(bo.getAddress().stream().map(AddressMapper::toDTO).collect(Collectors.toList()));
        user.setDateOfBirth(bo.getDateOfBirth());
        user.setCreateAt(bo.getCreateAt());
        user.setUpdateAt(bo.getUpdateAt());

        return user;
    }

    public static UserBO toBO(UserDTO dto) {
        return new UserBO(dto.getId(), dto.getName(), dto.getEmail(), dto.getCpfCnpj(), dto.getGender(), dto.getPassword(), dto.getPhoneNumber(), dto.getIsActive(), dto.getAddress().stream().map(AddressMapper::toBO).collect(Collectors.toList()), dto.getDateOfBirth(), dto.getCreateAt(), dto.getUpdateAt());
    }
}
