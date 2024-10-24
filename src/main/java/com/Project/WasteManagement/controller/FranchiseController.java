package com.Project.WasteManagement.controller;

import com.Project.WasteManagement.model.Franchise;
import com.Project.WasteManagement.repository.FranchiseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/franchises")
public class FranchiseController {

    private final Logger logger = LoggerFactory.getLogger(FranchiseController.class);

    @Autowired
    private FranchiseRepository franchiseRepository;

    // Get all franchises
    @GetMapping
    public ResponseEntity<List<Franchise>> getAllFranchises() {
        logger.info("Fetching all franchises");
        try {
            List<Franchise> franchises = franchiseRepository.findAll();
            return ResponseEntity.ok(franchises);
        } catch (Exception e) {
            logger.error("Error fetching franchises", e);
            return ResponseEntity.status(500).build(); // Internal Server Error
        }
    }

    // Get a specific franchise by ID
    @GetMapping("/{id}")
    public ResponseEntity<Franchise> getFranchiseById(@PathVariable Long id) {
        logger.info("Fetching franchise with ID: " + id);
        try {
            return franchiseRepository.findById(id)
                    .map(franchise -> ResponseEntity.ok().body(franchise))
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            logger.error("Error fetching franchise with ID: " + id, e);
            return ResponseEntity.status(500).build(); // Internal Server Error
        }
    }

    // Create a new franchise
    @PostMapping
    public ResponseEntity<Franchise> createFranchise(@RequestBody Franchise franchise) {
        logger.info("Creating new franchise: " + franchise.getName());
        try {
            Franchise savedFranchise = franchiseRepository.save(franchise);
            return ResponseEntity.status(201).body(savedFranchise); // Created
        } catch (Exception e) {
            logger.error("Error creating franchise", e);
            return ResponseEntity.status(500).build(); // Internal Server Error
        }
    }

    // Update an existing franchise
    @PutMapping("/{id}")
    public ResponseEntity<Franchise> updateFranchise(@PathVariable Long id, @RequestBody Franchise franchiseDetails) {
        logger.info("Updating franchise with ID: " + id);
        try {
            return franchiseRepository.findById(id).map(franchise -> {
                franchise.setName(franchiseDetails.getName());
                franchise.setLocation(franchiseDetails.getLocation());
                franchise.setContactnumber(franchiseDetails.getContactnumber());
                franchise.setEmail(franchiseDetails.getEmail());
                return ResponseEntity.ok(franchiseRepository.save(franchise));
            }).orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            logger.error("Error updating franchise with ID: " + id, e);
            return ResponseEntity.status(500).build(); // Internal Server Error
        }
    }

    // Delete a franchise
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFranchise(@PathVariable Long id) {
        logger.info("Deleting franchise with ID: " + id);
        try {
            if (franchiseRepository.existsById(id)) {
                franchiseRepository.deleteById(id);
                return ResponseEntity.noContent().build(); // No Content
            } else {
                return ResponseEntity.notFound().build(); // Not Found
            }
        } catch (Exception e) {
            logger.error("Error deleting franchise with ID: " + id, e);
            return ResponseEntity.status(500).build(); // Internal Server Error
        }
    }
}
