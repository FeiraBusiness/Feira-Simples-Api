package br.feira.infra.database.postgres.model;

import br.feira.domain.entities.enums.EnumPaymentType;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "FS_PAYMENT")
public class PgPayment extends PanacheEntityBase {

    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    private PgOrder order;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE_PAYMENT")
    private EnumPaymentType typePayment;

    @Column(name = "VALUE")
    private BigDecimal value;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

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

    public EnumPaymentType getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(EnumPaymentType typePayment) {
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
        return updatedAt;
    }

    public void setupdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
