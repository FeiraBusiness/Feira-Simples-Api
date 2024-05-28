package br.feira.domain.entities.bo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import br.feira.domain.entities.enums.EnumGender;

public abstract class Person {
    private UUID id;
    private String name;
    private String email;
    private String cpfCnpj;
    private EnumGender gender;
    private String password;
    private String document;
    private String phoneNumber;
    private Boolean acceptTerms;
    private String secret;
    private Boolean isActive;
    private List<AddressBO> address;
    private LocalDateTime dateOfBirth;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
