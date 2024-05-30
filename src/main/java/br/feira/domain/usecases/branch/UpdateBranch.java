package br.feira.domain.usecases.branch;

import br.feira.domain.entities.bo.BranchBO;
import br.feira.domain.entities.dtos.BranchDTO;
import br.feira.domain.entities.mappers.BranchMapper;
import br.feira.domain.repositories.IBranchRepository;

import java.util.UUID;

public class UpdateBranch {

    private IBranchRepository repository;

    public UpdateBranch(IBranchRepository repository) {
        this.repository = repository;
    }

    public BranchDTO execute(UUID id, BranchDTO dto) {
        BranchBO bo = repository.findById(id);

        if (bo == null) {
            throw new RuntimeException("Opa! Registro não encontrado");
        }

        bo = repository.merge(bo);

        return BranchMapper.toDTO(bo);
    }
}
