package br.feira.domain.dtos;

import br.feira.domain.enums.EnumOrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {

    private String id;
    private UserDTO user;
    private LocalDateTime date;
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public LocalDateTime getOrderDate() {
        return date;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.date = orderDate;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
