package com.Project.WasteManagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "collectorassignment") // Make sure this matches your DB table name
public class CollectorAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long collectorId;

    private Long franchiseId; // Foreign key to Franchise
    private String collectorName;
    private String collectionDate; // Use appropriate date type
    private String processingFacility;

    // Getters and Setters

    public Long getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(Long collectorId) {
        this.collectorId = collectorId;
    }

    public Long getFranchiseId() {
        return franchiseId;
    }

    public void setFranchiseId(Long franchiseId) {
        this.franchiseId = franchiseId;
    }

    public String getCollectorName() {
        return collectorName;
    }

    public void setCollectorName(String collectorName) {
        this.collectorName = collectorName;
    }

    public String getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(String collectionDate) {
        this.collectionDate = collectionDate;
    }

    public String getProcessingFacility() {
        return processingFacility;
    }

    public void setProcessingFacility(String processingFacility) {
        this.processingFacility = processingFacility;
    }
}
