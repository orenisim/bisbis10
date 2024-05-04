package com.att.tdp.bisbis10.repository;

import com.att.tdp.bisbis10.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository<OrderItem, Long> {
}
