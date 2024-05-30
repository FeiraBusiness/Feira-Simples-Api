package br.feira.domain.usecases.company;

import br.feira.domain.entities.bo.CompanyBO;
import br.feira.domain.entities.dtos.CompanyDTO;
import br.feira.domain.entities.mappers.CompanyMapper;
import br.feira.domain.repositories.ICompanyRepository;

public class CreateCompany {

    private ICompanyRepository repository;

    public CreateCompany(ICompanyRepository repository) {
        this.repository = repository;
    }

    public CompanyDTO execute(CompanyDTO dto) {
        CompanyBO bo = CompanyMapper.toBO(dto);

        bo = repository.create(bo);

        return CompanyMapper.toDTO(bo);
    }
}
