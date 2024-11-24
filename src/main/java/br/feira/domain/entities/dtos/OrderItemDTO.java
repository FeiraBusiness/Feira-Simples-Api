package br.feira.domain.entities.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderItemDTO {

    private String id;
    private int quantity;
    private BigDecimal unitaryValue;
    private ProductDTO product;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitaryValue() {
        return unitaryValue;
    }

    public void setUnitaryValue(BigDecimal price) {
        this.unitaryValue = price;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public LocalDateTime getCreatedAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setupdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
