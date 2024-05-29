package br.feira.domain.entities.dtos;

import br.feira.domain.entities.enums.EnumStatusPayment;
import br.feira.domain.entities.vo.UuidVO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentDTO {

    private String id;
    private EnumStatusPayment staus;
    private BigDecimal value;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
