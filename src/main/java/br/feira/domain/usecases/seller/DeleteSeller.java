package br.feira.domain.usecases.seller;

import br.feira.domain.entities.dtos.SellerDTO;
import br.feira.domain.repositories.ISellerRepository;

import java.util.UUID;

public class DeleteSeller {

    private ISellerRepository repository;

    public DeleteSeller(ISellerRepository repository) {
        this.repository = repository;
    }

    public void execute(SellerDTO dto) {
        repository.delete(dto.getId().transform(UUID::fromString));
    }
}
