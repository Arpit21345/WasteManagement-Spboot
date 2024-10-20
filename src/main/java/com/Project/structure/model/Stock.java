package com.Project.structure.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Stock {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID stockId;
    
    private String itemName;
    private Integer stockQuantity;
    private Integer reorderLevel;
    private Date lastRestocked;

    // Getters and Setters
    public UUID getStockId() {
        return stockId;
    }

    public void setStockId(UUID stockId) {
        this.stockId = stockId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Integer getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Integer reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public Date getLastRestocked() {
        return lastRestocked;
    }

    public void setLastRestocked(Date lastRestocked) {
        this.lastRestocked = lastRestocked;
    }
}
