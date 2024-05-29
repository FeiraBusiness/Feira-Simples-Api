package br.feira.domain.entities.enums;

public enum EnumTypeMovimentation {
    PENDING("INPUT",0),
    PROCESSING("OUTPUT", 1);
    private String key;
    private Integer value;

    EnumTypeMovimentation(String key, Integer value) {
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
