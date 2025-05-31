package org.example.lab2.controller;

import org.example.lab2.models.dtos.OrderDto;
import org.example.lab2.models.dtos.ProductDto;
import org.example.lab2.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDto> placeOrder(@RequestBody OrderDto orderDTO) {
        return ResponseEntity.ok(orderService.placeOrder(orderDTO));
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Integer id) {
        OrderDto order = orderService.getOrderById(id);
        return order != null ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<OrderDto>> getUserOrders(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.getOrdersByUserId(id));
    }
    @GetMapping("/details/{id}")
    public ResponseEntity<List<ProductDto>> getOrderDetails(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.getOrderDetails(id));
    }
}