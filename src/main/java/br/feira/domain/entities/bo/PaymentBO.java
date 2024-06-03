package br.feira.domain.entities.bo;

import br.feira.domain.entities.enums.EnumPaymentType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentBO {
    private UUID id;
    private EnumPaymentType paymentType;
    private BigDecimal value;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PaymentBO(String id, BigDecimal value, EnumPaymentType paymentType, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id != null ? UUID.fromString(id) : UUID.randomUUID();
        this.value = value;
        this.paymentType = paymentType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public EnumPaymentType getPaymentType() {
        return paymentType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
