package com.Project.WasteManagement.repository;

import com.Project.WasteManagement.model.WasteRecord; // Import your entity class
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteRecordRepository extends JpaRepository<WasteRecord, Long> {
    // You can define custom query methods here if needed
}
