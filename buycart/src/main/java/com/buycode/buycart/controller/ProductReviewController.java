package com.buycode.buycart.controller;

import com.buycode.buycart.dto.ProductReviewDto;
import com.buycode.buycart.entity.ProductReview;
import com.buycode.buycart.service.ProductService;
import jakarta.persistence.Access;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/products/reviews")
public class ProductReviewController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<?> addReview(@RequestBody @Valid ProductReviewDto reviewDto){
        productService.addReview(reviewDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Review Added");
    }
}
