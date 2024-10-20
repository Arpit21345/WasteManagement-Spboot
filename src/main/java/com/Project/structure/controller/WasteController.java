package com.Project.structure.controller;

import com.Project.structure.model.Franchise;
import com.Project.structure.model.Inventory;
import com.Project.structure.model.Order;
import com.Project.structure.model.Stock;
import com.Project.structure.model.Expire;
import com.Project.structure.service.FranchiseService;
import com.Project.structure.service.InventoryService;
import com.Project.structure.service.OrderService;
import com.Project.structure.service.StockService;
import com.Project.structure.service.ExpireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/waste")
public class WasteController {

    @Autowired
    private FranchiseService franchiseService;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private StockService stockService;

    @Autowired
    private ExpireService expireService;

    // Franchise endpoints
    @GetMapping("/franchises")
    public ResponseEntity<?> getAllFranchises() {
        return ResponseEntity.ok(franchiseService.getAllFranchises());
    }

    @GetMapping("/franchises/{id}")
    public ResponseEntity<?> getFranchiseById(@PathVariable UUID id) {
        return ResponseEntity.of(franchiseService.getFranchiseById(id));
    }

    @PostMapping("/franchises")
    public ResponseEntity<?> createFranchise(@RequestBody Franchise franchise) {
        return ResponseEntity.ok(franchiseService.createFranchise(franchise));
    }

    @PutMapping("/franchises/{id}")
    public ResponseEntity<?> updateFranchise(@PathVariable UUID id, @RequestBody Franchise franchise) {
        return ResponseEntity.ok(franchiseService.updateFranchise(id, franchise));
    }

    @DeleteMapping("/franchises/{id}")
    public ResponseEntity<?> deleteFranchise(@PathVariable UUID id) {
        franchiseService.deleteFranchise(id);
        return ResponseEntity.noContent().build();
    }

    // Inventory endpoints
    @GetMapping("/inventories")
    public ResponseEntity<?> getAllInventories() {
        return ResponseEntity.ok(inventoryService.getAllInventories());
    }

    @GetMapping("/inventories/{id}")
    public ResponseEntity<?> getInventoryById(@PathVariable UUID id) {
        return ResponseEntity.of(inventoryService.getInventoryById(id));
    }

    @PostMapping("/inventories")
    public ResponseEntity<?> createInventory(@RequestBody Inventory inventory) {
        return ResponseEntity.ok(inventoryService.createInventory(inventory));
    }

    @PutMapping("/inventories/{id}")
    public ResponseEntity<?> updateInventory(@PathVariable UUID id, @RequestBody Inventory inventory) {
        return ResponseEntity.ok(inventoryService.updateInventory(id, inventory));
    }

    @DeleteMapping("/inventories/{id}")
    public ResponseEntity<?> deleteInventory(@PathVariable UUID id) {
        inventoryService.deleteInventory(id);
        return ResponseEntity.noContent().build();
    }

    // Order endpoints
    @GetMapping("/orders")
    public ResponseEntity<?> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable UUID id) {
        return ResponseEntity.of(orderService.getOrderById(id));
    }

    @PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable UUID id, @RequestBody Order order) {
        return ResponseEntity.ok(orderService.updateOrder(id, order));
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable UUID id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    // Stock endpoints
    @GetMapping("/stocks")
    public ResponseEntity<?> getAllStocks() {
        return ResponseEntity.ok(stockService.getAllStocks());
    }

    @GetMapping("/stocks/{id}")
    public ResponseEntity<?> getStockById(@PathVariable UUID id) {
        return ResponseEntity.of(stockService.getStockById(id));
    }

    @PostMapping("/stocks")
    public ResponseEntity<?> createStock(@RequestBody Stock stock) {
        return ResponseEntity.ok(stockService.createStock(stock));
    }

    @PutMapping("/stocks/{id}")
    public ResponseEntity<?> updateStock(@PathVariable UUID id, @RequestBody Stock stock) {
        return ResponseEntity.ok(stockService.updateStock(id, stock));
    }

    @DeleteMapping("/stocks/{id}")
    public ResponseEntity<?> deleteStock(@PathVariable UUID id) {
        stockService.deleteStock(id);
        return ResponseEntity.noContent().build();
    }

    // Expire endpoints
    @GetMapping("/expires")
    public ResponseEntity<?> getAllExpires() {
        return ResponseEntity.ok(expireService.getAllExpires());
    }

    @GetMapping("/expires/{id}")
    public ResponseEntity<?> getExpireById(@PathVariable UUID id) {
        return ResponseEntity.of(expireService.getExpireById(id));
    }

    @PostMapping("/expires")
    public ResponseEntity<?> createExpire(@RequestBody Expire expire) {
        return ResponseEntity.ok(expireService.createExpire(expire));
    }

    @PutMapping("/expires/{id}")
    public ResponseEntity<?> updateExpire(@PathVariable UUID id, @RequestBody Expire expire) {
        return ResponseEntity.ok(expireService.updateExpire(id, expire));
    }

    @DeleteMapping("/expires/{id}")
    public ResponseEntity<?> deleteExpire(@PathVariable UUID id) {
        expireService.deleteExpire(id);
        return ResponseEntity.noContent().build();
    }
}
