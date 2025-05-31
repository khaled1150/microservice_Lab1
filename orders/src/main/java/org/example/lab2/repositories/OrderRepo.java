package org.example.lab2.repositories;

import org.example.lab2.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Integer> {
    List<Order> findByUserId(Integer userId);
}