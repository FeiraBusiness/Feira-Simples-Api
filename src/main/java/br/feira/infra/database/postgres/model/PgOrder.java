package br.feira.infra.database.postgres.model;

import br.feira.domain.enums.EnumOrderStatus;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "FF_ORDEM")
public class PgOrder extends PanacheEntityBase {

    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    private PgUser user;

    @Column
    private LocalDateTime date;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<PgOrderItem> items;

    @Column
    @Enumerated(EnumType.STRING)
    private EnumOrderStatus status;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATE_AT")
    private LocalDateTime updatedAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PgUser getUser() {
        return user;
    }

    public void setUser(PgUser user) {
        this.user = user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<PgOrderItem> getItems() {
        return items;
    }

    public void setItems(List<PgOrderItem> items) {
        this.items = items;
    }

    public EnumOrderStatus getStatus() {
        return status;
    }

    public void setStatus(EnumOrderStatus status) {
        this.status = status;
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
