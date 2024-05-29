package br.feira.domain.entities.bo;

import br.feira.domain.entities.enums.EnumStatusPayment;
import br.feira.domain.entities.vo.UuidVO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentBO {
    private UUID id;
    private EnumStatusPayment staus;
    private BigDecimal value;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PaymentBO(String id, EnumStatusPayment staus, BigDecimal value, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id != null ? UUID.fromString(id) : UUID.randomUUID();
        this.staus = staus;
        this.value = value;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public EnumStatusPayment getStaus() {
        return staus;
    }

    public void setStaus(EnumStatusPayment staus) {
        this.staus = staus;
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
