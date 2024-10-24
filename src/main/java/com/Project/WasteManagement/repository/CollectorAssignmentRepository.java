package com.Project.WasteManagement.repository;

import com.Project.WasteManagement.model.CollectorAssignment; // Import your entity class
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectorAssignmentRepository extends JpaRepository<CollectorAssignment, Long> {
    // You can define custom query methods here if needed
}
