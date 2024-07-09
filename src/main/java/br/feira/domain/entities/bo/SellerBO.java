package br.feira.domain.entities.bo;

import br.feira.domain.entities.enums.EnumErrorCode;
import br.feira.domain.entities.enums.EnumGender;
import br.feira.domain.utils.StringUtil;
import br.feira.domain.utils.exceptions.FeiraException;

import java.time.LocalDateTime;
import java.util.UUID;

public class SellerBO {

    private UUID id;
    private String name;
    private String email;
    private String cpfCnpj;
    private EnumGender gender;
    private String password;
    private String phoneNumber;
    private Boolean isActive;
    private LocalDateTime dateOfBirth;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public SellerBO(String id, String name, String email, String cpfCnpj, EnumGender gender, String password,
                    String phoneNumber, Boolean isActive, LocalDateTime dateOfBirth, LocalDateTime createdAt,
                    LocalDateTime updatedAt) {
        this.id = id != null ? UUID.fromString(id) : UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.cpfCnpj = cpfCnpj;
        this.gender = gender;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
        this.dateOfBirth = dateOfBirth;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;

        validate();
    }

    public UUID getId() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDateTime getcreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    private void validate() {
        if (StringUtil.isNullOrEmpty(name)) {
            throw new FeiraException(EnumErrorCode.CAMPO_OBRIGATORIO, "name");
        }

        if (StringUtil.isNullOrEmpty(email)) {
            throw new FeiraException(EnumErrorCode.CAMPO_OBRIGATORIO, "email");
        }

        if (StringUtil.isNullOrEmpty(cpfCnpj)) {
            throw new FeiraException(EnumErrorCode.CAMPO_OBRIGATORIO, "cpfCnpj");
        }

        if (StringUtil.isNullOrEmpty(password)) {
            throw new FeiraException(EnumErrorCode.CAMPO_OBRIGATORIO, "cpfCnpj");
        }

        if (StringUtil.isNullOrEmpty(phoneNumber)) {
            throw new FeiraException(EnumErrorCode.CAMPO_OBRIGATORIO, "cpfCnpj");
        }

        if (StringUtil.isNullOrEmpty(dateOfBirth.toString())) {
            throw new FeiraException(EnumErrorCode.CAMPO_OBRIGATORIO, "dateOfBirth");
        }

    }
}
