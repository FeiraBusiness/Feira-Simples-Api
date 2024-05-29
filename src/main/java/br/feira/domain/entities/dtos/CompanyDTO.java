package br.feira.domain.entities.dtos;

import java.time.LocalDateTime;
import java.util.List;

public class CompanyDTO {

    private String id;
    private String name;
    private Boolean isActive;
    private List<BranchDTO> branchs;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<BranchDTO> getBranchs() {
        return branchs;
    }

    public void setBranchs(List<BranchDTO> branchs) {
        this.branchs = branchs;
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
