package org.example.lab2.services;

import org.example.lab2.models.dtos.ProductDto;
import org.example.lab2.models.mappers.ProductMapper;
import org.example.lab2.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    ProductMapper productMapper;
    public List<ProductDto>getAllProducts(){
        return productMapper.toDtoList(productRepo.findAll());
    }
    public ProductDto getProductById(Integer id){
        return productMapper.toDto(productRepo.findById(id).orElse(null));
    }
    public ProductDto saveProduct(ProductDto productDto){
        return productMapper.toDto(productRepo.save(productMapper.toEntity(productDto)));
    }
    public void deleteProduct(Integer id){
        productRepo.deleteById(id);
    }
    public  List<ProductDto> getProdductsByIds(List<Integer> ids){
        return productMapper.toDtoList(productRepo.findAllById(ids));
    }
}
