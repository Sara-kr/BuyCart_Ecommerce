package com.buycode.buycart.controller;

import com.buycode.buycart.dto.CreateOrderRequest;
import com.buycode.buycart.dto.OrderCreated;
import com.buycode.buycart.entity.Order;
import com.buycode.buycart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest orderRequest){
        OrderCreated orderCreated = orderService.createOrder(orderRequest);
        return ResponseEntity.ok().body(orderCreated);
    }

    @GetMapping("/{referenceId}")
    public ResponseEntity<?> getOrder(@PathVariable String referenceId){
        Order order = orderService.getOrder(referenceId);
        return ResponseEntity.ok().body(order);
    }
}
