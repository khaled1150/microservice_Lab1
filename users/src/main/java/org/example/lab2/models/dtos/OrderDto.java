package org.example.lab2.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Integer id;
    private Long userId;
    private LocalDateTime orderDate;
    private List<OrderItemDto> items;
}
