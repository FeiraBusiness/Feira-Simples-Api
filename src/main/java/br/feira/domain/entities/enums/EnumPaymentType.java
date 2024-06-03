package br.feira.domain.entities.enums;

public enum EnumPaymentType {
    
    PIX("PIX", 0),
    MONEY("MONEY", 1),
    CREDIT_CARD("CREDIT_CARD", 2),
    DEBIT_CARD("DEBIT_CARD", 3);

    private String key;
    private Integer value;

    EnumPaymentType(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }
}
