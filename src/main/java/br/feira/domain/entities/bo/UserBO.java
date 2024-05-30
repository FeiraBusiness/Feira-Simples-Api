package br.feira.domain.entities.bo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import br.feira.domain.entities.enums.EnumGender;

public class UserBO {

    private UUID id;
    private String name;
    private String email;
    private String cpfCnpj;
    private EnumGender gender;
    private String password;
    private String phoneNumber;
    private Boolean isActive;
    private List<AddressBO> address;
    private LocalDateTime dateOfBirth;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;

    public UserBO(String id, String name, String email, String cpfCnpj, EnumGender gender, String password,
            String phoneNumber, Boolean isActive, List<AddressBO> address, LocalDateTime dateOfBirth,
            LocalDateTime createAt,
            LocalDateTime updatedAt) {
        this.id = id != null ? UUID.fromString(id) : UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.cpfCnpj = cpfCnpj;
        this.gender = gender;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
    }

    public void update(String email) {

        if (email != null) {
            this.email = email;
        }

    }

    public void handleUpdatePassword(String newPassword) {
        this.password = newPassword;
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

    public List<AddressBO> getAddress() {
        return address;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDateTime getCreatedAt() {
        return createAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
