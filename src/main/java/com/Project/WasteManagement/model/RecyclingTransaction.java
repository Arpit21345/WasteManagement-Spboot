package com.Project.WasteManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "recyclingtransaction") // Ensure this matches your database table name
public class RecyclingTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY or another strategy as needed
    private Long transactionId; // Primary Key

    private Long franchiseId; // Foreign Key reference to Franchise ID
    private String transactionDate; // Date of the transaction
    private String wasteCategory; // Category of waste (e.g., Edible, Non-Edible, Expired)
    private int quantityProcessed; // Quantity of waste processed
    private String facility; // Name of the recycling facility
    private String status; // Status of the transaction (e.g., Pending, Completed)

    // Getters and setters
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getFranchiseId() {
        return franchiseId;
    }

    public void setFranchiseId(Long franchiseId) {
        this.franchiseId = franchiseId;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(String wasteCategory) {
        this.wasteCategory = wasteCategory;
    }

    public int getQuantityProcessed() {
        return quantityProcessed;
    }

    public void setQuantityProcessed(int quantityProcessed) {
        this.quantityProcessed = quantityProcessed;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Additional methods if necessary
}
