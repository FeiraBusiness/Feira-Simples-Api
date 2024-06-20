package br.feira.domain.entities.bo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import br.feira.domain.entities.enums.EnumOrderStatus;

public class OrderBO {

    private UUID id;
    private UUID seller;
    private UUID customer;
    private BigDecimal discount;
    private BigDecimal increase;
    private BigDecimal netValue;
    private List<OrderItemBO> items;
    private EnumOrderStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public OrderBO(String id, UUID customer, UUID seller, BigDecimal discount, BigDecimal increase,
            BigDecimal netValue, List<OrderItemBO> items, EnumOrderStatus status, LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = id != null ? UUID.fromString(id) : UUID.randomUUID();
        this.customer = customer;
        this.seller = seller;
        this.discount = discount;
        this.increase = increase;
        this.netValue = netValue;
        this.items = items;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public UUID getCustomer() {
        return customer;
    }

    public UUID getSeller() {
        return seller;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public BigDecimal getIncrease() {
        return increase;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public List<OrderItemBO> getItems() {
        return items;
    }

    public EnumOrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getcreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
