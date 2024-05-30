package br.feira.domain.usecases.branch;

import br.feira.domain.entities.dtos.BranchDTO;
import br.feira.domain.entities.mappers.BranchMapper;
import br.feira.domain.repositories.IBranchRepository;

import java.util.UUID;

public class FindBranchBy {

    private IBranchRepository repository;

    public FindBranchBy(IBranchRepository repository) {
        this.repository = repository;
    }

    public BranchDTO execute(UUID id) {
        var entity = repository.findById(id);

        if (entity == null) {
            // throw
        }

        return BranchMapper.toDTO(entity);
    }
}
