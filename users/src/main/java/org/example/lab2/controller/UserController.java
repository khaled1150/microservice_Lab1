package org.example.lab2.controller;


import org.example.lab2.models.dtos.OrderDto;
import org.example.lab2.models.dtos.ProductDto;
import org.example.lab2.models.dtos.UserDto;
import org.example.lab2.models.entities.User;
import org.example.lab2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;
    @GetMapping("/{id}")
    public UserDto findById(@PathVariable("id") int id) {
        return userService.findUserById(id);
    }
    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll();

    }
    @PostMapping
    public UserDto save(@RequestBody User user) {
        userService.save(user);
        return userService.findUserById(user.getId());

    }
    @GetMapping("/{id}/orders")
    public List<OrderDto> findOrders(@PathVariable("id") int id) {
        String url = "http://localhost:8081/orders/user/" + id ;
        List<OrderDto> orders = restTemplate.getForObject(url, List.class);
        return orders;

    }
    @GetMapping("/{id}/orders/{order_id}")
    public List<ProductDto>getOrderProducts(@PathVariable("id") Integer id,@PathVariable("order_id") Integer orderId) {
        String url = "http://localhost:8081/orders/details/" + orderId ;
        List<ProductDto> products = restTemplate.getForObject(url, List.class);
        return products;
    }


}
