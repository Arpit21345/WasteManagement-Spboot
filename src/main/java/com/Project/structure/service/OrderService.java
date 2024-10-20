package com.Project.structure.service;

import com.Project.structure.model.Order;
import com.Project.structure.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(UUID orderId) {
        return orderRepository.findById(orderId);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(UUID orderId, Order order) {
        order.setOrderId(orderId);
        return orderRepository.save(order);
    }

    public void deleteOrder(UUID orderId) {
        orderRepository.deleteById(orderId);
    }
}
