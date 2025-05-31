package org.example.lab2.models.mappers;

import org.example.lab2.models.dtos.OrderDto;
import org.example.lab2.models.dtos.OrderItemDto;
import org.example.lab2.models.entities.Order;
import org.example.lab2.models.entities.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto toOrderDto(Order order);
    Order toOrder(OrderDto orderDto);
    OrderItemDto toOrderItemDto(OrderItem orderItem);
    OrderItem toOrderItem(OrderItemDto orderItemDto);
    List<OrderItemDto> toOrderItemDtoList(List<OrderItem> orderItems);
    List<OrderDto> toOrderDtoList(List<Order> orders);
    List<Order> toOrderList(List<OrderDto> orderDtos);
    List<OrderItem> toOrderItemList(List<OrderItemDto> orderItemDtos);

    default List<Integer> toProductIds(List<OrderItemDto> orderItemDtos)
    {
        return orderItemDtos.stream().map(s->s.getProductId()).toList();
    }
}
