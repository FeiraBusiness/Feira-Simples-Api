package br.feira.domain.usecases.company;

import br.feira.domain.entities.dtos.CompanyDTO;
import br.feira.domain.entities.mappers.CompanyMapper;
import br.feira.domain.repositories.ICompanyRepository;

import java.util.UUID;

public class FindCompanytBy {
    private ICompanyRepository repository;

    public FindCompanytBy(ICompanyRepository repository) {
        this.repository = repository;
    }

    public CompanyDTO execute(UUID id) {
        var entity = repository.findById(id);

        if (entity == null) {
            // throw
        }

        return CompanyMapper.toDTO(entity);
    }
}
