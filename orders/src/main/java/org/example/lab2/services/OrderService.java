package org.example.lab2.services;


import org.example.lab2.models.dtos.OrderDto;
import org.example.lab2.models.dtos.OrderItemDto;
import org.example.lab2.models.dtos.ProductDto;
import org.example.lab2.models.entities.Order;
import org.example.lab2.models.entities.OrderItem;
import org.example.lab2.models.mappers.OrderMapper;
import org.example.lab2.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepo orderRepository;

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    RestTemplate restTemplate;

    public OrderService(OrderRepo orderRepository) {
        this.orderRepository = orderRepository;
    }


    public OrderDto placeOrder(OrderDto orderDTO) {
        Order order = orderMapper.toOrder(orderDTO);
        Order savedOrder = orderRepository.save(order);

        orderDTO.setId(savedOrder.getId());
        orderDTO.setOrderDate(savedOrder.getOrderDate());
        return orderDTO;
    }


    public List<OrderDto> getAllOrders() {
        return orderMapper.toOrderDtoList(orderRepository.findAll());
    }

    public OrderDto getOrderById(Integer id) {
        return orderMapper.toOrderDto(orderRepository.findById(id).orElse(null));
    }
    public List<OrderDto> getOrdersByUserId(Integer userId) {
        return orderMapper.toOrderDtoList(orderRepository.findByUserId(userId));
    }
    public List<ProductDto>getOrderDetails(Integer id)
    {
       List<Integer>productIds= orderMapper.toProductIds(orderMapper.toOrderItemDtoList(orderRepository.findById(id).orElse(null).getItems()));
       List<ProductDto>products=restTemplate.postForObject("http://localhost:8082/products",productIds,List.class);
       return products;
    }
}
