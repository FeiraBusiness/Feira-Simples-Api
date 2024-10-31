package br.feira.domain.entities.enums;

public enum EnumGender {

    WOMAN("WOMAN"), MAN("MAN"), OTHER("OTHER") ;

    private String key;

    EnumGender(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
