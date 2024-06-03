package br.feira.domain.entities.mappers;

import br.feira.domain.entities.bo.AddressBO;
import br.feira.domain.entities.bo.StockBO;
import br.feira.domain.entities.dtos.AddressDTO;
import br.feira.domain.entities.dtos.StockDTO;

public class StockMapper {

    public static StockDTO toDTO(StockBO bo) {
        StockDTO dto = new StockDTO();

        

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
                dto.getcreatedAt(),
                dto.getUpdatedAt());
    }

}
