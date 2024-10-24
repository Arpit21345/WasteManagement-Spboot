package com.Project.WasteManagement.repository;

import com.Project.WasteManagement.model.RecyclingTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecyclingTransactionRepository extends JpaRepository<RecyclingTransaction, Long> {
}
