package com.Project.structure.service;

import com.Project.structure.model.Franchise;
import com.Project.structure.repository.FranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FranchiseService {

    @Autowired
    private FranchiseRepository franchiseRepository;

    public List<Franchise> getAllFranchises() {
        return franchiseRepository.findAll();
    }

    public Optional<Franchise> getFranchiseById(UUID franchiseId) {
        return franchiseRepository.findById(franchiseId);
    }

    public Franchise createFranchise(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    public Franchise updateFranchise(UUID franchiseId, Franchise franchise) {
        franchise.setFranchiseId(franchiseId);
        return franchiseRepository.save(franchise);
    }

    public void deleteFranchise(UUID franchiseId) {
        franchiseRepository.deleteById(franchiseId);
    }
}
