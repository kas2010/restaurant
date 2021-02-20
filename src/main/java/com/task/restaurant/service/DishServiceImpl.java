package com.task.restaurant.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.restaurant.model.Dish;
import com.task.restaurant.repositroy.DishRepository;
import com.task.restaurant.to.DishTo;

@Service
public class DishServiceImpl implements DishService{
	@Autowired
	private DishRepository repository;

	@Override
	public List<DishTo> getAll() {
		return repository
				.findAll()
				.stream()
				.map(DishTo::new)
				.collect(Collectors.toList());
	}

	@Override
	public List<DishTo> getListWithTimeAndCost(List<Long> ids) {
		List<Dish> dishes = repository.findAllById(ids);
		Long totalElapsedTime = dishes
				.stream()
				.mapToLong(n -> n.getElapsedTime())
				.sum();
		Double totalCost = dishes
				.stream()
				.mapToDouble(n -> n.getCost())
				.sum();
		return dishes
				.stream()
				.map(n -> {
					DishTo dishTo = new DishTo(n);
					dishTo.setTotalCost(totalCost);
					dishTo.setTotalElapsedTime(totalElapsedTime);
					return dishTo;
				})
				.collect(Collectors.toList());
	}
	

}
