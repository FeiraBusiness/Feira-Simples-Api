package br.feira.domain.entities.dtos;

import br.feira.domain.entities.enums.EnumTypePayment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentDTO {

    private String id;
    private EnumTypePayment paymentType;
    private BigDecimal value;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnumTypePayment getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(EnumTypePayment paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
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
