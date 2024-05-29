package br.feira.domain.entities.bo;

import java.time.LocalDateTime;
import java.util.UUID;

public class BranchBO {

    private UUID id;
    private String name;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BranchBO(String id, String name, Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id != null ? UUID.fromString(id) : UUID.randomUUID();
        this.name = name;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public Boolean getActive() {
        return isActive;
    }

    public LocalDateTime getcreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
