package com.task.restaurant.service;

import java.util.List;

import com.task.restaurant.model.Dish;

public interface MainService {
	List<Dish> getAll();
	Long addOrder(List<Long> ids);
}
