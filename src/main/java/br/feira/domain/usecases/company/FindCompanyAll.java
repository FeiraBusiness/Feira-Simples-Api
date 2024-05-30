package br.feira.domain.usecases.company;

import br.feira.domain.entities.bo.CompanyBO;
import br.feira.domain.entities.dtos.CompanyDTO;
import br.feira.domain.entities.mappers.CompanyMapper;
import br.feira.domain.repositories.ICompanyRepository;

import java.util.List;
import java.util.stream.Collectors;

public class FindCompanyAll {

    private ICompanyRepository repository;

    public FindCompanyAll(ICompanyRepository repository) {
        this.repository = repository;
    }

    public List<CompanyDTO> execute() {
        List<CompanyBO> list = repository.listAll();

        return list.stream()
                .map(CompanyMapper::toDTO)
                .collect(Collectors.toList());
    }
}
