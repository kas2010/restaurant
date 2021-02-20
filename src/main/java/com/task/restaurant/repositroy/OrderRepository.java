package com.task.restaurant.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.restaurant.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
