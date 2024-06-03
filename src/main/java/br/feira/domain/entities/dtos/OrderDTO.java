package br.feira.domain.entities.dtos;

import br.feira.domain.entities.bo.SellerBO;
import br.feira.domain.entities.enums.EnumOrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {

    private String id;
    private CustomerDTO customer;
    private SellerBO seller;
    private BigDecimal discount;
    private BigDecimal increase;
    private BigDecimal netValue;
    private List<OrderItemDTO> items;
    private EnumOrderStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public SellerBO getSeller() {
        return seller;
    }

    public void setSeller(SellerBO seller) {
        this.seller = seller;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getIncrease() {
        return increase;
    }

    public void setIncrease(BigDecimal increase) {
        this.increase = increase;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public void setNetValue(BigDecimal netValue) {
        this.netValue = netValue;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> orderItems) {
        this.items = orderItems;
    }

    public EnumOrderStatus getEnumOrderStatus() {
        return status;
    }

    public void setEnumOrderStatus(EnumOrderStatus enumOrderStatus) {
        this.status = enumOrderStatus;
    }

    public LocalDateTime getcreatedAt() {
        return createdAt;
    }

    public void setcreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
