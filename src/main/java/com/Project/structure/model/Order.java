package com.Project.structure.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID orderId;
    
    private UUID franchiseId;
    private Date orderDate;
    private Integer totalItems;
    private String status; // e.g., Pending, Dispatched, Delivered

    // Getters and Setters
    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getFranchiseId() {
        return franchiseId;
    }

    public void setFranchiseId(UUID franchiseId) {
        this.franchiseId = franchiseId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
