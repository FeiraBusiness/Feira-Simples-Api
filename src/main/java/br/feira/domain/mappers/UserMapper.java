package br.feira.domain.mappers;

import br.feira.domain.dtos.UserDTO;
import br.feira.domain.entities.UserBO;

import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO toDTO(UserBO userBO) {
        UserDTO user = new UserDTO();

        user.setId(userBO.getId().toString());
        user.setName(userBO.getName());
        user.setEmail(userBO.getEmail());
        user.setCpfCnpj(userBO.getCpfCnpj());
        user.setGender(userBO.getGender());
        user.setPassword(userBO.getPassword());
        user.setPhoneNumber(userBO.getPhoneNumber());
        user.setIsActive(userBO.getIsActive());
        user.setAddress(userBO.getAddress().stream().map(AddressMapper::toDTO).collect(Collectors.toList()));
        user.setDateOfBirth(userBO.getDateOfBirth());
        user.setCreateAt(userBO.getCreateAt());
        user.setUpdateAt(userBO.getUpdateAt());

        return user;
    }

    public static UserBO toBO(UserDTO userDTO) {
        return new UserBO(userDTO.getId(), userDTO.getName(), userDTO.getEmail(), userDTO.getCpfCnpj(), userDTO.getGender(), userDTO.getPassword(), userDTO.getPhoneNumber(), userDTO.getIsActive(), userDTO.getAddress().stream().map(AddressMapper::toBO).collect(Collectors.toList()), userDTO.getDateOfBirth(), userDTO.getCreateAt(), userDTO.getUpdateAt());

    }
}
