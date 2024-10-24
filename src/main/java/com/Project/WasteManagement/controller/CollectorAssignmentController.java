package com.Project.WasteManagement.controller;

import com.Project.WasteManagement.model.CollectorAssignment;
import com.Project.WasteManagement.repository.CollectorAssignmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collector-assignments")
public class CollectorAssignmentController {

    private final Logger logger = LoggerFactory.getLogger(CollectorAssignmentController.class);

    @Autowired
    private CollectorAssignmentRepository collectorAssignmentRepository;

    @GetMapping
    public List<CollectorAssignment> getAllCollectorAssignments() {
        logger.info("Fetching all collector assignments");
        return collectorAssignmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CollectorAssignment> getCollectorAssignmentById(@PathVariable Long id) {
        logger.info("Fetching collector assignment with ID: " + id);
        return collectorAssignmentRepository.findById(id)
                .map(assignment -> ResponseEntity.ok().body(assignment))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CollectorAssignment createCollectorAssignment(@RequestBody CollectorAssignment collectorAssignment) {
        logger.info("Creating new collector assignment for franchise ID: " + collectorAssignment.getFranchiseId());
        return collectorAssignmentRepository.save(collectorAssignment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CollectorAssignment> updateCollectorAssignment(@PathVariable Long id, @RequestBody CollectorAssignment assignmentDetails) {
        logger.info("Updating collector assignment with ID: " + id);
        return collectorAssignmentRepository.findById(id).map(assignment -> {
            assignment.setFranchiseId(assignmentDetails.getFranchiseId());
            assignment.setCollectorName(assignmentDetails.getCollectorName());
            return ResponseEntity.ok(collectorAssignmentRepository.save(assignment));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollectorAssignment(@PathVariable Long id) {
        logger.info("Deleting collector assignment with ID: " + id);
        if (collectorAssignmentRepository.existsById(id)) {
            collectorAssignmentRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
