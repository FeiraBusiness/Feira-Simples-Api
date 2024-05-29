package br.feira.domain.entities.vo;

import java.time.LocalDateTime;

public class createdAtVO {

    final LocalDateTime createdAt;

    public createdAtVO(final LocalDateTime createdAt) {
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
    }

    public LocalDateTime getValue() {
        return createdAt;
    }
}
