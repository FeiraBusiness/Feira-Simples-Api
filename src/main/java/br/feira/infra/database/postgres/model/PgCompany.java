package br.feira.infra.database.postgres.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "FS_COMPANY")
public class PgCompany {

    @Id
    private UUID id;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<PgBranch> branches;

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

    public List<PgBranch> getBranches() {
        return branches;
    }

    public void setBranches(List<PgBranch> branches) {
        this.branches = branches;
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
