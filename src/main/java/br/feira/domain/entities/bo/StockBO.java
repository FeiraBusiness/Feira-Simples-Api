package br.feira.domain.entities.bo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class StockBO {

    private UUID id;
    private List<StockItemBO> items;
    private Integer totalAmount;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;

    public StockBO(String id, List<StockItemBO> items, Integer totalAmount, LocalDateTime createAt, LocalDateTime updatedAt) {
        this.id = id != null ? UUID.fromString(id) : UUID.randomUUID();
        this.items = items;
        this.totalAmount = totalAmount;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public List<StockItemBO> getItems() {
        return items;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getCreatedAt() {
        return createAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
