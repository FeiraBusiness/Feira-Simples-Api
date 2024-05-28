package br.feira.domain.entities.enums;

public enum EnumOrderStatus {

    PENDING("PENDING"),
    PROCESSING("PROCESSING"),
    COMPLETED("COMPLETED");

    private String key;

    EnumOrderStatus(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
