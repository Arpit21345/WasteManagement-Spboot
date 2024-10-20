package com.Project.structure.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Inventory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID inventoryId;
    
    private String itemName;
    private Integer quantity;
    private String warehouseLocation;
    private Date lastUpdated;

    // Getters and Setters
    public UUID getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(UUID inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getWarehouseLocation() {
        return warehouseLocation;
    }

    public void setWarehouseLocation(String warehouseLocation) {
        this.warehouseLocation = warehouseLocation;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
