package br.feira.domain.entities.bo;

import br.feira.domain.entities.dtos.SellerDTO;
import br.feira.domain.entities.enums.EnumOrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class OrderBO {

    private UUID id;
    private CustomerBO customer;
    private SellerDTO seller;
    private BigDecimal discount;
    private BigDecimal increase;
    private BigDecimal netValue;
    private List<OrderItemBO> items;
    private EnumOrderStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public OrderBO(String id, CustomerBO customer, List<OrderItemBO> items, EnumOrderStatus status,
                   LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id != null ? UUID.fromString(id) : UUID.randomUUID();
        this.customer = customer;
        this.items = items;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public CustomerBO getCustomer() {
        return customer;
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
