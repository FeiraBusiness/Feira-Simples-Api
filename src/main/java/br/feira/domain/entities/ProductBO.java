package br.feira.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class ProductBO {

    private UUID id;
    private String code;
    private String name;
    private String description;
    private BigDecimal value;
    private String category;
    private int stockBalance;
    private String imageUrl;
    private double weight;
    private BigDecimal discount;
    private double rating;
    private boolean isActive;
    private LocalDateTime expirationDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductBO(String id, String code, String name, String description, BigDecimal value, String category, int stockBalance, String imageUrl, double weight, BigDecimal discount, double rating, boolean isActive, LocalDateTime expirationDate, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id != null ? UUID.fromString(id) : UUID.randomUUID();
        this.code = code;
        this.name = name;
        this.description = description;
        this.value = value;
        this.category = category;
        this.stockBalance = stockBalance;
        this.imageUrl = imageUrl;
        this.weight = weight;
        this.discount = discount;
        this.rating = rating;
        this.isActive = isActive;
        this.expirationDate = expirationDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getCategory() {
        return category;
    }

    public int getStockBalance() {
        return stockBalance;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public double getWeight() {
        return weight;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public double getRating() {
        return rating;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
