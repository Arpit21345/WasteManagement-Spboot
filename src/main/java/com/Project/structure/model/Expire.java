package com.Project.structure.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Expire {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID expireId;
    
    private String itemName;
    private Date expiryDate;
    private Integer quantityExpired;
    private String handledBy; // Name of the person who handled the expired stock

    // Getters and Setters
    public UUID getExpireId() {
        return expireId;
    }

    public void setExpireId(UUID expireId) {
        this.expireId = expireId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getQuantityExpired() {
        return quantityExpired;
    }

    public void setQuantityExpired(Integer quantityExpired) {
        this.quantityExpired = quantityExpired;
    }

    public String getHandledBy() {
        return handledBy;
    }

    public void setHandledBy(String handledBy) {
        this.handledBy = handledBy;
    }
}
