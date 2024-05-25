package br.feira.domain.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderItemDTO {

    private String id;
//    private OrderDTO order;
    private int quantity;
    private BigDecimal price;
    private ProductDTO product;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public OrderDTO getOrder() {
//        return order;
//    }
//
//    public void setOrder(OrderDTO order) {
//        this.order = order;
//    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
