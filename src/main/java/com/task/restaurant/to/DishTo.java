package com.task.restaurant.to;

import com.task.restaurant.model.Dish;
import com.task.restaurant.model.DishCategory;

/*
 *  Data Transport Object
 */
public class DishTo {
	private Long id;
	private String name;
	private DishCategory category;
	private Double cost;
	private Long elapsedTime;
	private Double totalCost;
	private Long totalElapsedTime;

	public DishTo(Dish dish) {
		this.id = dish.getId();
		this.name = dish.getName();
		this.category = dish.getCategory();
		this.cost = dish.getCost();
		this.elapsedTime = dish.getElapsedTime();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DishCategory getCategory() {
		return category;
	}

	public void setCategory(DishCategory category) {
		this.category = category;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Long getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(Long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Long getTotalElapsedTime() {
		return totalElapsedTime;
	}

	public void setTotalElapsedTime(Long totalElapsedTime) {
		this.totalElapsedTime = totalElapsedTime;
	}
}
