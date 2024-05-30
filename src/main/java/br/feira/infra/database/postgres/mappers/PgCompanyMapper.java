package br.feira.infra.database.postgres.mappers;

import br.feira.domain.entities.bo.CompanyBO;
import br.feira.infra.database.postgres.model.PgBranch;
import br.feira.infra.database.postgres.model.PgCompany;

import java.util.List;
import java.util.stream.Collectors;

public class PgCompanyMapper {

    public static PgCompany toEntity(CompanyBO bo) {
        var panache = new PgCompany();

        panache.setId(bo.getId());
        panache.setName(bo.getName());
        panache.setIsActive(bo.getIsActive());
        List<PgBranch> branches = bo.getBranchs().stream().map(PgBranchMapper::toEntity).toList();
        branches.forEach(branche -> branche.setCompany(panache));
        panache.setcreatedAt(bo.getcreatedAt());
        panache.setupdatedAt(bo.getUpdatedAt());

        return panache;
    }

    public static CompanyBO toDomain(PgCompany entity) {
        var bo = new CompanyBO(
                entity.getId().toString(),
                entity.getName(),
                entity.getIsActive(),
                entity.getBranches().stream().map(PgBranchMapper::toDomain).collect(Collectors.toList()),
                entity.getcreatedAt(),
                entity.getUpdatedAt());

        return bo;
    }

}
