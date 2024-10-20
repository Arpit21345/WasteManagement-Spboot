package com.Project.structure.repository;

import com.Project.structure.model.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, UUID> {
}
