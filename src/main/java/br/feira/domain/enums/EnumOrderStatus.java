package br.feira.domain.enums;

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
