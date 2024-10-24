package com.Project.WasteManagement.controller;

import com.Project.WasteManagement.model.WasteRecord; // Import the entity class
import com.Project.WasteManagement.repository.WasteRecordRepository; // Import the repository
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wasterecord") // Adjusted for better readability in URLs
public class WasteRecordController {

    private final Logger logger = LoggerFactory.getLogger(WasteRecordController.class);

    @Autowired
    private WasteRecordRepository wasteRecordRepository;

    // Get all waste records
    @GetMapping
    public ResponseEntity<List<WasteRecord>> getAllWasteRecords() {
        logger.info("Fetching all waste records");
        try {
            List<WasteRecord> wasteRecords = wasteRecordRepository.findAll();
            return new ResponseEntity<>(wasteRecords, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error fetching waste records", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get a specific waste record by ID
    @GetMapping("/{id}")
    public ResponseEntity<WasteRecord> getWasteRecordById(@PathVariable Long id) {
        logger.info("Fetching waste record with ID: " + id);
        try {
            return wasteRecordRepository.findById(id)
                    .map(wasteRecord -> ResponseEntity.ok().body(wasteRecord))
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            logger.error("Error fetching waste record", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Create a new waste record
    @PostMapping
    public ResponseEntity<WasteRecord> createWasteRecord(@RequestBody WasteRecord wasteRecord) {
        logger.info("Creating new waste record: " + wasteRecord.getWasteCategory());
        try {
            WasteRecord savedWasteRecord = wasteRecordRepository.save(wasteRecord);
            return new ResponseEntity<>(savedWasteRecord, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error creating waste record", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update an existing waste record
    @PutMapping("/{id}")
    public ResponseEntity<WasteRecord> updateWasteRecord(@PathVariable Long id, @RequestBody WasteRecord wasteRecordDetails) {
        logger.info("Updating waste record with ID: " + id);
        try {
            return wasteRecordRepository.findById(id).map(wasteRecord -> {
                wasteRecord.setFranchiseId(wasteRecordDetails.getFranchiseId());
                wasteRecord.setWasteCategory(wasteRecordDetails.getWasteCategory());
                wasteRecord.setQuantity(wasteRecordDetails.getQuantity());
                wasteRecord.setDisposalMethod(wasteRecordDetails.getDisposalMethod());
                wasteRecord.setDisposalDate(wasteRecordDetails.getDisposalDate());
                return ResponseEntity.ok(wasteRecordRepository.save(wasteRecord));
            }).orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            logger.error("Error updating waste record", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete a waste record
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWasteRecord(@PathVariable Long id) {
        logger.info("Deleting waste record with ID: " + id);
        try {
            if (wasteRecordRepository.existsById(id)) {
                wasteRecordRepository.deleteById(id);
                return ResponseEntity.noContent().build(); // No Content
            } else {
                return ResponseEntity.notFound().build(); // Not Found
            }
        } catch (Exception e) {
            logger.error("Error deleting waste record", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
