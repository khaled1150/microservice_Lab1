package org.example.lab2.controller;


import org.example.lab2.models.dtos.ProductDto;
import org.example.lab2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping
    public List<ProductDto>getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto>getProductById(@PathVariable Integer id){
        return ResponseEntity.ok(productService.getProductById(id));

    }
    @PostMapping
    public ResponseEntity<List<ProductDto>>getProdductsByIds(@RequestBody List<Integer> ids){
        return ResponseEntity.ok(productService.getProdductsByIds(ids));
    }
    @PostMapping("/save")
    public ResponseEntity<ProductDto>saveProduct(@RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.saveProduct(productDto));
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
    }

}
