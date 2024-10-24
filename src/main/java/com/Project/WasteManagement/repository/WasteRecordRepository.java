package com.Project.WasteManagement.repository;

import com.Project.WasteManagement.model.WasteRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WasteRecordRepository extends JpaRepository<WasteRecord, Long> {
}
