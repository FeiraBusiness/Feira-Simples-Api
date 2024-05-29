package br.feira.domain.entities.enums;

public enum EnumStatusPayment {
    CANCEL("CANCEL", 0),
    PENDING("PENDING", 1),
    WAITING_FOR_APPROVAL("WAITING_FOR_APPROVAL", 2),
    APPROVED("APPROVED", 3),
    DISAPPROVED("DISAPPROVED", 4),
    ATTENDED("ATTENDED", 5);

    private String key;
    private Integer value;

    EnumStatusPayment(String key, Integer value) {
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
