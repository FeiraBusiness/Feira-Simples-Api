package br.feira.domain.entities.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.feira.domain.entities.bo.SellerBO;
import br.feira.domain.entities.enums.EnumOrderStatus;

public class OrderDTO {

    private String id;
    private UserDTO user;
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
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
