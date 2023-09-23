package com.dgn.relationship.repository;

import com.dgn.relationship.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
