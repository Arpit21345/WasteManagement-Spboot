package com.Project.structure.service;

import com.Project.structure.model.Inventory;
import com.Project.structure.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    public Optional<Inventory> getInventoryById(UUID inventoryId) {
        return inventoryRepository.findById(inventoryId);
    }

    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public Inventory updateInventory(UUID inventoryId, Inventory inventory) {
        inventory.setInventoryId(inventoryId);
        return inventoryRepository.save(inventory);
    }

    public void deleteInventory(UUID inventoryId) {
        inventoryRepository.deleteById(inventoryId);
    }
}
