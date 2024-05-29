package br.feira.domain.entities.dtos;

import java.time.LocalDateTime;

public class StockItemDTO {

    private String id;
    private Integer unitQuantity;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUnitQuantity() {
        return unitQuantity;
    }

    public void setUnitQuantity(Integer unitQuantity) {
        this.unitQuantity = unitQuantity;
    }

    public LocalDateTime getcreatedAt() {
        return createdAt;
    }

    public void setcreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
