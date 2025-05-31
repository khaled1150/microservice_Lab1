package org.example.lab2.models.dtos;

import lombok.*;

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
