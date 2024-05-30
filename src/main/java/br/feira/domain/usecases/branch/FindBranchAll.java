package br.feira.domain.usecases.branch;

import br.feira.domain.entities.bo.BranchBO;
import br.feira.domain.entities.dtos.BranchDTO;
import br.feira.domain.entities.mappers.BranchMapper;
import br.feira.domain.repositories.IBranchRepository;

import java.util.List;
import java.util.stream.Collectors;

public class FindBranchAll {

    private IBranchRepository repository;

    public FindBranchAll(IBranchRepository repository) {
        this.repository = repository;
    }

    public List<BranchDTO> execute() {
        List<BranchBO> list = repository.listAll();

        return list.stream()
                .map(BranchMapper::toDTO)
                .collect(Collectors.toList());
    }
}
