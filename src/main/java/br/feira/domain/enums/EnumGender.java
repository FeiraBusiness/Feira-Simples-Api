package br.feira.domain.enums;

public enum EnumGender {

    WOMAN("WOMAN"), MAN("MAN");

    private String key;

    EnumGender(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
