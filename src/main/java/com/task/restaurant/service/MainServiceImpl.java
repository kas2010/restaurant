package com.task.restaurant.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.restaurant.exception.NotFoundException;
import com.task.restaurant.model.Dish;
import com.task.restaurant.model.Order;
import com.task.restaurant.model.OrderDish;
import com.task.restaurant.model.OrderState;
import com.task.restaurant.repositroy.DishRepository;
import com.task.restaurant.repositroy.OrderRepository;

@Service
public class MainServiceImpl implements MainService {
	private static final Logger log = LoggerFactory.getLogger(MainService.class);
	
	@Autowired
	private DishRepository dishRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Dish> getAll() {
		return dishRepository.findAll();
	}

	@Override
	public Long addOrder(List<Long> ids) {
		List<Dish> dishes = dishRepository.findAllById(ids);
		
		if (dishes.isEmpty()) {
			throw new NotFoundException("Not found dishes by ids:" + ids);
		}
		
		Long totalElapsedTime = dishes
				.stream()
				.mapToLong(n -> n.getElapsedTime())
				.sum();
		
		Double totalCost = dishes
				.stream()
				.mapToDouble(n -> n.getCost())
				.sum();
		
		List<OrderDish> orderDishes = dishes
				.stream()
				.map(OrderDish::new)
				.collect(Collectors.toList());
		
		Order order = new Order();
		order.setState(OrderState.Awaiting);
		order.setCreateDate(LocalDate.now());
		order.setDishes(orderDishes);
		order.setTotalCost(totalCost);
		order.setTotalElapsedTime(totalElapsedTime);
		
		log.info("Saving order: " + order.toString());
		
		orderRepository.save(order);
		
		log.info("Saved");
		
		return totalElapsedTime;
	}
}
