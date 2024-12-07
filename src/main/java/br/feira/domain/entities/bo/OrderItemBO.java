package br.feira.domain.entities.bo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class OrderItemBO {

    private UUID id;
    private int quantity;
    private BigDecimal price;
    private ProductBO product;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;

    public OrderItemBO(String id, int quantity, BigDecimal price, ProductBO product, LocalDateTime createAt, LocalDateTime updatedAt) {
        this.id = id != null ? UUID.fromString(id) : UUID.randomUUID();
        this.quantity = quantity;
        this.price = price;
        this.product = product;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductBO getProduct() {
        return product;
    }

    public LocalDateTime getCreatedAt() {
        return createAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
