package com.buycode.buycart.controller;

import com.buycode.buycart.entity.Product;
import com.buycode.buycart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Map<String,Object> getAllProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size){
        return productService.getAllProducts(page, size);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @GetMapping("/search")
    public List<Product> searchProduct(@RequestParam(required = false) String category, @RequestParam(required = false) Double minPrice,@RequestParam(required = false) Double maxPrice,@RequestParam(required = false) String keyword,@RequestParam(required = false) Double ratings){
        return productService.searchProducts(category,minPrice,maxPrice,keyword,ratings);
    }
}
