package com.Project.WasteManagement.controller;

import com.Project.WasteManagement.model.RecyclingTransaction;
import com.Project.WasteManagement.repository.RecyclingTransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recycling")
public class RecyclingTransactionController {

    private static final Logger logger = LoggerFactory.getLogger(RecyclingTransactionController.class);

    @Autowired
    private RecyclingTransactionRepository recyclingTransactionRepository;

    // Create a new recycling transaction
    @PostMapping
    public ResponseEntity<RecyclingTransaction> createRecyclingTransaction(@RequestBody RecyclingTransaction transaction) {
        try {
            RecyclingTransaction savedTransaction = recyclingTransactionRepository.save(transaction);
            return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error creating recycling transaction", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all recycling transactions
    @GetMapping
    public ResponseEntity<List<RecyclingTransaction>> getAllRecyclingTransactions() {
        try {
            List<RecyclingTransaction> transactions = recyclingTransactionRepository.findAll();
            return new ResponseEntity<>(transactions, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error fetching recycling transactions", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get a recycling transaction by ID
    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTransaction> getRecyclingTransactionById(@PathVariable Long id) {
        try {
            RecyclingTransaction transaction = recyclingTransactionRepository.findById(id)
                    .orElse(null);
            if (transaction != null) {
                return new ResponseEntity<>(transaction, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error fetching recycling transaction", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update a recycling transaction
    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTransaction> updateRecyclingTransaction(
            @PathVariable Long id, @RequestBody RecyclingTransaction transaction) {
        try {
            if (!recyclingTransactionRepository.existsById(id)) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            transaction.setId(id);
            RecyclingTransaction updatedTransaction = recyclingTransactionRepository.save(transaction);
            return new ResponseEntity<>(updatedTransaction, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error updating recycling transaction", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete a recycling transaction
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRecyclingTransaction(@PathVariable Long id) {
        try {
            recyclingTransactionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            logger.error("Error deleting recycling transaction", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
