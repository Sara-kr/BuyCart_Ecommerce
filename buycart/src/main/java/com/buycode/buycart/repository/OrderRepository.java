package com.buycode.buycart.repository;

import com.buycode.buycart.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {
    Optional<Order> findByReferenceId(String referenceId);
}
