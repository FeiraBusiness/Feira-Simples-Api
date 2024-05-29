package br.feira.domain.entities.mappers;

import br.feira.domain.entities.bo.CompanyBO;
import br.feira.domain.entities.dtos.CompanyDTO;

import java.util.stream.Collectors;

public class CompanyMapper {

    public static CompanyDTO toDTO(CompanyBO bo) {
        CompanyDTO dto = new CompanyDTO();

        dto.setId(bo.getId().toString());
        dto.setName(bo.getName());
        dto.setActive(bo.getActive());
        dto.setBranchs(bo.getBranchs().stream().map(BranchMapper::toDTO).collect(Collectors.toList()));
        dto.setcreatedAt(bo.getcreatedAt());
        dto.setUpdatedAt(bo.getUpdatedAt());

        return dto;
    }

    public static CompanyBO toBO(CompanyDTO dto) {
        return new CompanyBO(
                dto.getId(),
                dto.getName(),
                dto.getActive(),
                dto.getBranchs().stream().map(BranchMapper::toBO).collect(Collectors.toList()),
                dto.getcreatedAt(),
                dto.getUpdatedAt());
    }

}
