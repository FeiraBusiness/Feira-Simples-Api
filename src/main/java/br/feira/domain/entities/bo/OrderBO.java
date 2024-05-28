package br.feira.domain.entities.bo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import br.feira.domain.entities.dtos.SellerDTO;
import br.feira.domain.entities.enums.EnumOrderStatus;

public class OrderBO {

    private UUID id;
    private UserBO user;
    private SellerDTO seller;
    private BigDecimal discount;
    private BigDecimal increase;
    private BigDecimal netValue;
    private List<OrderItemBO> items;
    private EnumOrderStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public OrderBO(String id, UserBO user, List<OrderItemBO> items, EnumOrderStatus status,
            LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id != null ? UUID.fromString(id) : UUID.randomUUID();
        this.user = user;
        this.items = items;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public UserBO getUser() {
        return user;
    }

    public List<OrderItemBO> getItems() {
        return items;
    }

    public EnumOrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
