package br.feira.domain.entities.bo;

import java.time.LocalDateTime;
import java.util.UUID;

public class StockItemBO {

    private UUID id;
    private ProductBO product;
    private Integer unitQuantity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public StockItemBO(String id, ProductBO product, Integer unitQuantity, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id != null ? UUID.fromString(id) : UUID.randomUUID();
        this.product = product;
        this.unitQuantity = unitQuantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public ProductBO getProduct() {
        return product;
    }

    public Integer getUnitQuantity() {
        return unitQuantity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
