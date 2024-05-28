package br.feira.domain.entities.enums;

public interface IEnum {
    String getKey();

    boolean containsInEnum(String key);
}
