package com.Project.WasteManagement.controller;

import com.Project.WasteManagement.model.CollectorAssignment; // Ensure this points to the correct model
import com.Project.WasteManagement.repository.CollectorAssignmentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collectorassignments") // Updated to use hyphen as per REST conventions
public class CollectorAssignmentController {

    private final Logger logger = LoggerFactory.getLogger(CollectorAssignmentController.class);

    @Autowired
    private CollectorAssignmentRepository collectorAssignmentRepository;

    // Get all collector assignments
    @GetMapping
    public ResponseEntity<List<CollectorAssignment>> getAllCollectorAssignments() {
        logger.info("Fetching all collector assignments");
        try {
            List<CollectorAssignment> assignments = collectorAssignmentRepository.findAll();
            return ResponseEntity.ok(assignments);
        } catch (Exception e) {
            logger.error("Error fetching collector assignments", e);
            return ResponseEntity.status(500).build(); // Internal Server Error
        }
    }

    // Get a specific collector assignment by ID
    @GetMapping("/{id}")
    public ResponseEntity<CollectorAssignment> getCollectorAssignmentById(@PathVariable Long id) {
        logger.info("Fetching collector assignment with ID: " + id);
        try {
            return collectorAssignmentRepository.findById(id)
                    .map(assignment -> ResponseEntity.ok().body(assignment))
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            logger.error("Error fetching collector assignment with ID: " + id, e);
            return ResponseEntity.status(500).build(); // Internal Server Error
        }
    }

    // Create a new collector assignment
    @PostMapping
    public ResponseEntity<CollectorAssignment> createCollectorAssignment(@RequestBody CollectorAssignment collectorAssignment) {
        logger.info("Creating new collector assignment for collector name: " + collectorAssignment.getCollectorName());
        try {
            CollectorAssignment savedAssignment = collectorAssignmentRepository.save(collectorAssignment);
            return ResponseEntity.status(201).body(savedAssignment); // Created
        } catch (Exception e) {
            logger.error("Error creating collector assignment", e);
            return ResponseEntity.status(500).build(); // Internal Server Error
        }
    }

    // Update an existing collector assignment
    @PutMapping("/{id}")
    public ResponseEntity<CollectorAssignment> updateCollectorAssignment(@PathVariable Long id, @RequestBody CollectorAssignment assignmentDetails) {
        logger.info("Updating collector assignment with ID: " + id);
        try {
            return collectorAssignmentRepository.findById(id).map(assignment -> {
                assignment.setFranchiseId(assignmentDetails.getFranchiseId());
                assignment.setCollectorName(assignmentDetails.getCollectorName());
                assignment.setCollectionDate(assignmentDetails.getCollectionDate());
                assignment.setProcessingFacility(assignmentDetails.getProcessingFacility());
                return ResponseEntity.ok(collectorAssignmentRepository.save(assignment));
            }).orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            logger.error("Error updating collector assignment with ID: " + id, e);
            return ResponseEntity.status(500).build(); // Internal Server Error
        }
    }

    // Delete a collector assignment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollectorAssignment(@PathVariable Long id) {
        logger.info("Deleting collector assignment with ID: " + id);
        try {
            if (collectorAssignmentRepository.existsById(id)) {
                collectorAssignmentRepository.deleteById(id);
                return ResponseEntity.noContent().build(); // No Content
            } else {
                return ResponseEntity.notFound().build(); // Not Found
            }
        } catch (Exception e) {
            logger.error("Error deleting collector assignment with ID: " + id, e);
            return ResponseEntity.status(500).build(); // Internal Server Error
        }
    }
}
