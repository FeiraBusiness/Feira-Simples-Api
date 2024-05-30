package br.feira.domain.usecases.seller;

import br.feira.domain.entities.bo.SellerBO;
import br.feira.domain.entities.dtos.SellerDTO;
import br.feira.domain.entities.mappers.SellerMapper;
import br.feira.domain.repositories.ISellerRepository;

import java.util.List;
import java.util.stream.Collectors;

public class FindSellerAll {

    private ISellerRepository repository;

    public FindSellerAll(ISellerRepository repository) {
        this.repository = repository;
    }

    public List<SellerDTO> execute() {
        List<SellerBO> list = repository.listAll();

        return list.stream()
                .map(SellerMapper::toDTO)
                .collect(Collectors.toList());
    }
}
