package br.feira.domain.entities;

import br.feira.domain.enums.EnumOrderStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class OrderBO {

    private UUID id;
    private UserBO user;
    private LocalDateTime date;
    private List<OrderItemBO> items;
    private EnumOrderStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public OrderBO(String id, UserBO user, LocalDateTime date, List<OrderItemBO> items, EnumOrderStatus status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id != null ? UUID.fromString(id) : UUID.randomUUID();
        this.user = user;
        this.date = date;
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

    public LocalDateTime getDate() {
        return date;
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
