package com.Project.structure.service;

import com.Project.structure.model.Stock;
import com.Project.structure.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Optional<Stock> getStockById(UUID stockId) {
        return stockRepository.findById(stockId);
    }

    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public Stock updateStock(UUID stockId, Stock stock) {
        stock.setStockId(stockId);
        return stockRepository.save(stock);
    }

    public void deleteStock(UUID stockId) {
        stockRepository.deleteById(stockId);
    }
}
