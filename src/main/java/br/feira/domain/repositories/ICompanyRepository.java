package br.feira.domain.repositories;

import br.feira.domain.entities.bo.CompanyBO;

import java.util.List;
import java.util.UUID;

public interface ICompanyRepository {

    CompanyBO create(CompanyBO bo);

    List<CompanyBO> listAll();

    CompanyBO findById(UUID id);

    CompanyBO merge(CompanyBO bo);

    void delete(UUID id);

}
