package br.feira.domain.usecases.branch;

import br.feira.domain.entities.bo.BranchBO;
import br.feira.domain.entities.dtos.BranchDTO;
import br.feira.domain.entities.mappers.BranchMapper;
import br.feira.domain.repositories.IBranchRepository;

public class CreateBranch {

    private IBranchRepository repository;

    public CreateBranch(IBranchRepository repository) {
        this.repository = repository;
    }

    public BranchDTO execute(BranchDTO dto) {
        BranchBO bo = BranchMapper.toBO(dto);

        bo = repository.create(bo);

        return BranchMapper.toDTO(bo);
    }
}
