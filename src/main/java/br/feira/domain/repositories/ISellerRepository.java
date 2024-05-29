package br.feira.domain.repositories;

import br.feira.domain.entities.bo.SellerBO;

import java.util.List;
import java.util.UUID;

public interface ISellerRepository {

    SellerBO create(SellerBO bo);

    List<SellerBO> listAll();

    SellerBO findById(UUID id);

    SellerBO merge(SellerBO bo);

    void delete(UUID id);

}
