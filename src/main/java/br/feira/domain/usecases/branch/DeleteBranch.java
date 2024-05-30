package br.feira.domain.usecases.branch;

import br.feira.domain.entities.dtos.BranchDTO;
import br.feira.domain.repositories.IBranchRepository;

import java.util.UUID;

public class DeleteBranch {

    private IBranchRepository repository;

    public DeleteBranch(IBranchRepository repository) {
        this.repository = repository;
    }

    public void execute(BranchDTO dto) {
        repository.delete(dto.getId().transform(UUID::fromString));
    }

}
