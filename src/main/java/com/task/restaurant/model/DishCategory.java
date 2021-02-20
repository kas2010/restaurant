package com.task.restaurant.model;

/*
 *  Directory Dish
 */
public enum DishCategory {
	Appetizers(1L),
	Starters(2L),
	Soups(3L),
	Salads(4L),
	MainDishes(5L),
	Meat(6L),
	Steak(7L),
	Poultry(8L),
	Fish(9L),
	Sides(10L),
	Sauces(11L),
    Desserts(12L),
	Beverages(13L);
	
	private Long id;
	
	private DishCategory(Long id) {
		this.id = id;
	}
	
	public Long getId() { return this.id; }
}
