package br.feira.infra.database.postgres.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "FS_STOCKITEM")
public class PgStockItem extends PanacheEntityBase {

    @Id
    private UUID id;

    @OneToOne
    private PgProduct product;

    @ManyToOne(fetch = FetchType.LAZY)
    private PgStock stock;

    @Column(name = "UNIT_QUANTITY")
    private Integer unitQuantity;

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

    public PgProduct getProduct() {
        return product;
    }

    public void setProduct(PgProduct product) {
        this.product = product;
    }

    public PgStock getStock() {
        return stock;
    }

    public void setStock(PgStock stock) {
        this.stock = stock;
    }

    public Integer getUnitQuantity() {
        return unitQuantity;
    }

    public void setUnitQuantity(Integer unitQuantity) {
        this.unitQuantity = unitQuantity;
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
