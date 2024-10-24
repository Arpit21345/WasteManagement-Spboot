package com.Project.WasteManagement.repository;

import com.Project.WasteManagement.model.DisposalEquipment; // Import the entity class
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisposalEquipmentRepository extends JpaRepository<DisposalEquipment, Long> {
    // You can add custom query methods here if needed in the future
}
