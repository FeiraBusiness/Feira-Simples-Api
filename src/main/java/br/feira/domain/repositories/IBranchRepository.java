package br.feira.domain.repositories;

import br.feira.domain.entities.bo.BranchBO;

import java.util.List;
import java.util.UUID;

public interface IBranchRepository {

    BranchBO create(BranchBO bo);

    List<BranchBO> listAll();

    BranchBO findById(UUID id);

    BranchBO merge(BranchBO bo);

    void delete(UUID id);

}
