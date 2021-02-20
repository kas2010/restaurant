package com.task.restaurant.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.restaurant.model.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long>{
	
}
