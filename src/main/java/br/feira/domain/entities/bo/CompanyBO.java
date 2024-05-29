package br.feira.domain.entities.bo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CompanyBO {

    private UUID id;
    private String name;
    private Boolean isActive;
    private List<BranchBO> branchs;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CompanyBO(String id, String name, Boolean isActive, List<BranchBO> branchs, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id != null ? UUID.fromString(id) : UUID.randomUUID();
        this.name = name;
        this.isActive = isActive;
        this.branchs = branchs;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public List<BranchBO> getBranchs() {
        return branchs;
    }

    public LocalDateTime getcreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
