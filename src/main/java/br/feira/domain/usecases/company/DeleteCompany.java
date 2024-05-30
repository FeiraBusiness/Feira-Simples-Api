package br.feira.domain.usecases.company;

import br.feira.domain.entities.dtos.CompanyDTO;
import br.feira.domain.repositories.ICompanyRepository;

import java.util.UUID;

public class DeleteCompany {

    private ICompanyRepository repository;

    public DeleteCompany(ICompanyRepository repository) {
        this.repository = repository;
    }

    public void execute(CompanyDTO dto) {
        repository.delete(dto.getId().transform(UUID::fromString));
    }

}
