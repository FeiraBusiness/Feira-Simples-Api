package br.feira.domain.entities.bo;

import java.time.LocalDateTime;
import java.util.List;

import br.feira.domain.entities.enums.EnumGender;
import br.feira.domain.entities.vo.UuidVO;

public abstract class Person {
    
    private UuidVO id;
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

    public Person(UuidVO id, String name, String email, String cpfCnpj, EnumGender gender, String password,
            String document, String phoneNumber, Boolean acceptTerms, String secret, Boolean isActive,
            List<AddressBO> address, LocalDateTime dateOfBirth, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpfCnpj = cpfCnpj;
        this.gender = gender;
        this.password = password;
        this.document = document;
        this.phoneNumber = phoneNumber;
        this.acceptTerms = acceptTerms;
        this.secret = secret;
        this.isActive = isActive;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public UuidVO getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public EnumGender getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    public String getDocument() {
        return document;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Boolean getAcceptTerms() {
        return acceptTerms;
    }

    public String getSecret() {
        return secret;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public List<AddressBO> getAddress() {
        return address;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

}
