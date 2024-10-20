package com.Project.structure.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Franchise {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID franchiseId;
    
    private String name;
    private String location;
    private String contactNumber;
    private String email;

    // Getters and Setters
    public UUID getFranchiseId() {
        return franchiseId;
    }

    public void setFranchiseId(UUID franchiseId) {
        this.franchiseId = franchiseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
