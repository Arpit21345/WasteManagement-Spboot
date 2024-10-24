package com.Project.WasteManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "waste_records") // Specify your table name if needed
public class WasteRecord {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY or another strategy as needed
    private Long id;

    // Other attributes
    private String description; // Example attribute
    private String category; // Example attribute

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Additional methods if necessary
}
