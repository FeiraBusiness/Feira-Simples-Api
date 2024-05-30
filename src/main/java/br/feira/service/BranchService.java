package br.feira.service;

import java.util.List;
import java.util.UUID;

import br.feira.domain.entities.bo.BranchBO;
import br.feira.domain.entities.dtos.BranchDTO;
import br.feira.domain.entities.mappers.BranchMapper;
import br.feira.domain.usecases.branch.CreateBranch;
import br.feira.domain.usecases.branch.DeleteBranch;
import br.feira.domain.usecases.branch.FindBranchAll;
import br.feira.domain.usecases.branch.FindBranchBy;
import br.feira.domain.usecases.branch.UpdateBranch;
import br.feira.infra.database.postgres.repositories.PgBranchRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class BranchService extends AbstractService {

    @Inject
    PgBranchRepository repository;

    @Transactional
    public BranchDTO create(BranchDTO dto) {
        var bo = new CreateBranch(repository);

        return bo.execute(dto);
    }

    public List<BranchDTO> listAll() {
        var list = new FindBranchAll(repository);

        return list.execute();
    }

    public BranchDTO findById(UUID id) {
        var find = new FindBranchBy(repository);

        return find.execute(id);
    }

    @Transactional
    public BranchDTO merge(UUID id, BranchDTO dto) {
        var update = new UpdateBranch(repository);

        return update.execute(id, dto);
    }

    @Transactional
    public void delete(UUID id) {
        BranchBO bo = repository.findById(id);

        var dto = BranchMapper.toDTO(bo);

        var delete = new DeleteBranch(repository);

        delete.execute(dto);
    }
}
