package com.Project.WasteManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "wasterecord") // Specify your table name
public class WasteRecord {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY or another strategy as needed
    private Long wasteId; // Changed to wasteId

    private Long franchiseId; // Reference to Franchise ID
    private String wasteCategory; // E.g., Edible, Not Edible, etc.
    private Integer quantity; // Quantity in kilograms
    private String disposalMethod; // E.g., Compost, Recycle, etc.
    private String disposalDate; // Disposal date

    // Getters and setters
    public Long getWasteId() {
        return wasteId;
    }

    public void setWasteId(Long wasteId) {
        this.wasteId = wasteId;
    }

    public Long getFranchiseId() {
        return franchiseId;
    }

    public void setFranchiseId(Long franchiseId) {
        this.franchiseId = franchiseId;
    }

    public String getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(String wasteCategory) {
        this.wasteCategory = wasteCategory;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDisposalMethod() {
        return disposalMethod;
    }

    public void setDisposalMethod(String disposalMethod) {
        this.disposalMethod = disposalMethod;
    }

    public String getDisposalDate() {
        return disposalDate;
    }

    public void setDisposalDate(String disposalDate) {
        this.disposalDate = disposalDate;
    }
}
