package br.feira.domain.entities.bo;

import java.time.LocalDateTime;
import java.util.UUID;

public class AddressBO {

    private UUID id;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public AddressBO(String id, String street, String number, String complement, String neighborhood, String city, String state, String country, String zipCode, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id != null ? UUID.fromString(id) : UUID.randomUUID();
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public LocalDateTime getcreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
