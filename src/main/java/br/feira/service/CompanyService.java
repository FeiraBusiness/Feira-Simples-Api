package br.feira.service;

import br.feira.domain.entities.bo.CompanyBO;
import br.feira.domain.entities.dtos.CompanyDTO;
import br.feira.domain.entities.mappers.CompanyMapper;
import br.feira.domain.usecases.company.*;
import br.feira.infra.database.postgres.repositories.PgCompanyRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class CompanyService extends AbstractService {

    @Inject
    PgCompanyRepository repository;

    public CompanyDTO create(CompanyDTO dto) {
        var bo = new CreateCompany(repository);

        return bo.execute(dto);
    }

    public List<CompanyDTO> listAll() {
        var list = new FindCompanyAll(repository);

        return list.execute();
    }

    public CompanyDTO findById(UUID id) {
        var find = new FindCompanytBy(repository);

        return find.execute(id);
    }

    @Transactional
    public CompanyDTO merge(UUID id, CompanyDTO dto) {
        var update = new UpdateCompany(repository);

        return update.execute(id, dto);
    }

    @Transactional
    public void delete(UUID id) {
        CompanyBO bo = repository.findById(id);

        var dto = CompanyMapper.toDTO(bo);

        var delete = new DeleteCompany(repository);

        delete.execute(dto);
    }


}
