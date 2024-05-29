package br.feira.domain.entities.bo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class StockBO {

    private UUID id;
    private List<OrderItemBO> items;
    private Integer totalAmount;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public StockBO(String id, List<OrderItemBO> items, Integer totalAmount, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id != null ? UUID.fromString(id) : UUID.randomUUID();
        this.items = items;
        this.totalAmount = totalAmount;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public UUID getId() {
        return id;
    }

    public List<OrderItemBO> getItems() {
        return items;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getCreatedAt() {
        return createAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updateAt;
    }
}
