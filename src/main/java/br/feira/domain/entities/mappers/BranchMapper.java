package br.feira.domain.entities.mappers;

import br.feira.domain.entities.bo.BranchBO;
import br.feira.domain.entities.dtos.BranchDTO;

public class BranchMapper {

    public static BranchDTO toDTO(BranchBO bo) {
        BranchDTO dto = new BranchDTO();

        dto.setId(bo.getId().toString());
        dto.setName(bo.getName());
        dto.setActive(bo.getActive());
        dto.setcreatedAt(bo.getcreatedAt());
        dto.setUpdatedAt(bo.getUpdatedAt());

        return dto;
    }

    public static BranchBO toBO(BranchDTO dto) {
        return new BranchBO(
                dto.getId(),
                dto.getName(),
                dto.getActive(),
                dto.getcreatedAt(),
                dto.getUpdatedAt());
    }

}
