package com.buycode.buycart.service;

import com.buycode.buycart.dto.CreateOrderRequest;
import com.buycode.buycart.dto.OrderCreated;
import com.buycode.buycart.dto.OrderItemDto;
import com.buycode.buycart.entity.Order;
import com.buycode.buycart.entity.OrderItem;
import com.buycode.buycart.entity.Product;
import com.buycode.buycart.repository.OrderRepository;
import com.buycode.buycart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private ProductRepository prodRepo;

    @Autowired
    private OrderRepository orderRepository;
    public OrderCreated createOrder(CreateOrderRequest orderRequest){
        Order order = new Order();
        order.setStatus("PENDING");
        double totalItemsAmount =0;

        for(OrderItemDto item : orderRequest.getOrderItems()){
            OrderItem orderItem = new OrderItem();
            orderItem.setName(item.getName());
            orderItem.setPrice(item.getPrice());
            orderItem.setImage(item.getImage());
            orderItem.setQuantity(item.getQuantity());

            Product product = prodRepo.findById(item.getProductId()).orElseThrow(() -> new RuntimeException("Product not Found"));
            orderItem.setProduct(product);
            totalItemsAmount += item.getPrice()*item.getQuantity();

            order.getOrderItems().add(orderItem);
        }
        order.setTotalItemsAmount(totalItemsAmount);
        double totalAmount =0;
        double taxAmount =10;
        totalAmount = totalItemsAmount + taxAmount;
        order.setTotalAmount(totalAmount);
        order.setTaxAmount(taxAmount);
        String refId = UUID.randomUUID().toString();
        order.setReferenceId(refId);

        orderRepository.save(order);
        return new OrderCreated(refId);
    }

    public Order getOrder(String referenceId) {
        return orderRepository.findByReferenceId(referenceId).orElseThrow(() -> new RuntimeException("No order found Ref id"));
    }
}
