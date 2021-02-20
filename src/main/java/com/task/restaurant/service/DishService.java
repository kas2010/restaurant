package com.task.restaurant.service;

import java.util.List;

import com.task.restaurant.to.DishTo;

public interface DishService {
	List<DishTo> getAll();
	List<DishTo> getListWithTimeAndCost(List<Long> ids);
}
