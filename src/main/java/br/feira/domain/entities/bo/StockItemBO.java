package br.feira.domain.entities.bo;

import java.time.LocalDateTime;
import java.util.UUID;

public class StockItemBO {

    private UUID id;
    private Integer unitQuantity;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public StockItemBO(String id, Integer unitQuantity, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id != null ? UUID.fromString(id) : UUID.randomUUID();
        this.unitQuantity = unitQuantity;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public UUID getId() {
        return id;
    }

    public Integer getUnitQuantity() {
        return unitQuantity;
    }

    public LocalDateTime getcreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updateAt;
    }
}
