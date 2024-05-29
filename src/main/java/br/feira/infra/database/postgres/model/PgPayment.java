package br.feira.infra.database.postgres.model;

import br.feira.domain.entities.enums.EnumTypePayment;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "FS_PAYMENT")
public class PgPayment {

    @Id
    private UUID id;

    @OneToOne
    private PgOrder order;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE_PAYMENT")
    private EnumTypePayment typePayment;

    @Column(name = "VALUE")
    private BigDecimal value;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_AT")
    private LocalDateTime updateAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PgOrder getOrder() {
        return order;
    }

    public void setOrder(PgOrder order) {
        this.order = order;
    }

    public EnumTypePayment getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(EnumTypePayment typePayment) {
        this.typePayment = typePayment;
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
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
