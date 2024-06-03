package br.feira.domain.entities.enums;

public enum EnumStockMovement {

    INPUT("INPUT",0),
    OUTPUT("OUTPUT", 1);

    private String key;
    private Integer value;

    EnumStockMovement(String key, Integer value) {
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
