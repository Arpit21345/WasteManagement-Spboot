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

    @GetMapping
    public List<Franchise> getAllFranchises() {
        logger.info("Fetching all franchises");
        return franchiseRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Franchise> getFranchiseById(@PathVariable Long id) {
        logger.info("Fetching franchise with ID: " + id);
        return franchiseRepository.findById(id)
                .map(franchise -> ResponseEntity.ok().body(franchise))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Franchise createFranchise(@RequestBody Franchise franchise) {
        logger.info("Creating new franchise: " + franchise.getName());
        return franchiseRepository.save(franchise);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Franchise> updateFranchise(@PathVariable Long id, @RequestBody Franchise franchiseDetails) {
        logger.info("Updating franchise with ID: " + id);
        return franchiseRepository.findById(id).map(franchise -> {
            franchise.setName(franchiseDetails.getName());
            franchise.setLocation(franchiseDetails.getLocation());
            return ResponseEntity.ok(franchiseRepository.save(franchise));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFranchise(@PathVariable Long id) {
        logger.info("Deleting franchise with ID: " + id);
        if (franchiseRepository.existsById(id)) {
            franchiseRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
