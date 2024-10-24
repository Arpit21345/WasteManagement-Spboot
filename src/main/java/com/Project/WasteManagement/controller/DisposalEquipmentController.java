package com.Project.WasteManagement.controller;

import com.Project.WasteManagement.model.DisposalEquipment; // Import the entity class
import com.Project.WasteManagement.repository.DisposalEquipmentRepository; // Import the repository
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disposalequipment") // Adjusted for better readability in URLs
public class DisposalEquipmentController {

    private final Logger logger = LoggerFactory.getLogger(DisposalEquipmentController.class);

    @Autowired
    private DisposalEquipmentRepository disposalEquipmentRepository;

    // Get all disposal equipments
    @GetMapping
    public ResponseEntity<List<DisposalEquipment>> getAllDisposalEquipments() {
        logger.info("Fetching all disposal equipments");
        try {
            List<DisposalEquipment> equipments = disposalEquipmentRepository.findAll();
            return ResponseEntity.ok(equipments);
        } catch (Exception e) {
            logger.error("Error fetching disposal equipments", e);
            return ResponseEntity.status(500).build(); // Internal Server Error
        }
    }

    // Get a specific disposal equipment by ID
    @GetMapping("/{id}")
    public ResponseEntity<DisposalEquipment> getDisposalEquipmentById(@PathVariable Long id) {
        logger.info("Fetching disposal equipment with ID: " + id);
        try {
            return disposalEquipmentRepository.findById(id)
                    .map(equipment -> ResponseEntity.ok().body(equipment))
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            logger.error("Error fetching disposal equipment with ID: " + id, e);
            return ResponseEntity.status(500).build(); // Internal Server Error
        }
    }

    // Create a new disposal equipment
    @PostMapping
    public ResponseEntity<DisposalEquipment> createDisposalEquipment(@RequestBody DisposalEquipment disposalEquipment) {
        logger.info("Creating new disposal equipment: " + disposalEquipment.getItemName());
        try {
            DisposalEquipment savedEquipment = disposalEquipmentRepository.save(disposalEquipment);
            return ResponseEntity.status(201).body(savedEquipment); // Created
        } catch (Exception e) {
            logger.error("Error creating disposal equipment", e);
            return ResponseEntity.status(500).build(); // Internal Server Error
        }
    }

    // Update an existing disposal equipment
    @PutMapping("/{id}")
    public ResponseEntity<DisposalEquipment> updateDisposalEquipment(@PathVariable Long id, @RequestBody DisposalEquipment equipmentDetails) {
        logger.info("Updating disposal equipment with ID: " + id);
        try {
            return disposalEquipmentRepository.findById(id).map(equipment -> {
                equipment.setItemName(equipmentDetails.getItemName());
                equipment.setFranchiseId(equipmentDetails.getFranchiseId());
                equipment.setQuantityInStock(equipmentDetails.getQuantityInStock());
                equipment.setLastUpdated(equipmentDetails.getLastUpdated());
                return ResponseEntity.ok(disposalEquipmentRepository.save(equipment));
            }).orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            logger.error("Error updating disposal equipment with ID: " + id, e);
            return ResponseEntity.status(500).build(); // Internal Server Error
        }
    }

    // Delete a disposal equipment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalEquipment(@PathVariable Long id) {
        logger.info("Deleting disposal equipment with ID: " + id);
        try {
            if (disposalEquipmentRepository.existsById(id)) {
                disposalEquipmentRepository.deleteById(id);
                return ResponseEntity.noContent().build(); // No Content
            } else {
                return ResponseEntity.notFound().build(); // Not Found
            }
        } catch (Exception e) {
            logger.error("Error deleting disposal equipment with ID: " + id, e);
            return ResponseEntity.status(500).build(); // Internal Server Error
        }
    }
}
