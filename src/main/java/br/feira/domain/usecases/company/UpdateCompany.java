package br.feira.domain.usecases.company;

import br.feira.domain.entities.bo.CompanyBO;
import br.feira.domain.entities.dtos.CompanyDTO;
import br.feira.domain.entities.mappers.CompanyMapper;
import br.feira.domain.repositories.ICompanyRepository;

import java.util.UUID;

public class UpdateCompany {

    private ICompanyRepository repository;

    public UpdateCompany(ICompanyRepository repository) {
        this.repository = repository;
    }

    public CompanyDTO execute(UUID id, CompanyDTO dto) {
        CompanyBO bo = repository.findById(id);

        if (bo == null) {
            throw new RuntimeException("Opa! Registro não encontrado");
        }

        bo = CompanyMapper.toBO(dto);

        repository.merge(bo);

        return CompanyMapper.toDTO(bo);
    }
}
