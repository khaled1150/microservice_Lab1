package org.example.lab2.models.mappers;


import org.example.lab2.models.dtos.ProductDto;
import org.example.lab2.models.entities.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product product);
    Product toEntity(ProductDto productDto);
    List<ProductDto> toDtoList(List<Product> products);

}
