package br.feira.infra.database.postgres.mappers;

import br.feira.domain.entities.bo.BranchBO;
import br.feira.infra.database.postgres.model.PgBranch;

public class PgBranchMapper {

    public static PgBranch toEntity(BranchBO bo) {
        var panache = new PgBranch();

        panache.setId(bo.getId());
        panache.setName(bo.getName());
        panache.setIsActive(bo.getActive());
        panache.setCreatedAt(bo.getUpdatedAt());
        panache.setUpdateAt(bo.getUpdatedAt());

        return panache;

    }

    public static BranchBO toDomain(PgBranch entity) {
        var bo = new BranchBO(
                entity.getId().toString(),
                entity.getName(),
                entity.getIsActive(),
                entity.getCreatedAt(),
                entity.getUpdateAt());

        return bo;
    }

}
