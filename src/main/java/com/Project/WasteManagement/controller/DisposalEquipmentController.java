package com.Project.WasteManagement.controller;

import com.Project.WasteManagement.model.DisposalEquipment;
import com.Project.WasteManagement.repository.DisposalEquipmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disposal-equipments")
public class DisposalEquipmentController {

    private final Logger logger = LoggerFactory.getLogger(DisposalEquipmentController.class);

    @Autowired
    private DisposalEquipmentRepository disposalEquipmentRepository;

    @GetMapping
    public List<DisposalEquipment> getAllDisposalEquipments() {
        logger.info("Fetching all disposal equipments");
        return disposalEquipmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalEquipment> getDisposalEquipmentById(@PathVariable Long id) {
        logger.info("Fetching disposal equipment with ID: " + id);
        return disposalEquipmentRepository.findById(id)
                .map(equipment -> ResponseEntity.ok().body(equipment))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DisposalEquipment createDisposalEquipment(@RequestBody DisposalEquipment disposalEquipment) {
        logger.info("Creating new disposal equipment: " + disposalEquipment.getEquipmentType());
        return disposalEquipmentRepository.save(disposalEquipment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalEquipment> updateDisposalEquipment(@PathVariable Long id, @RequestBody DisposalEquipment equipmentDetails) {
        logger.info("Updating disposal equipment with ID: " + id);
        return disposalEquipmentRepository.findById(id).map(equipment -> {
            equipment.setEquipmentType(equipmentDetails.getEquipmentType());
            return ResponseEntity.ok(disposalEquipmentRepository.save(equipment));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalEquipment(@PathVariable Long id) {
        logger.info("Deleting disposal equipment with ID: " + id);
        if (disposalEquipmentRepository.existsById(id)) {
            disposalEquipmentRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
