package com.task.restaurant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "order_dish")
public class OrderDish {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private DishCategory category;
	private Double cost;
	private Long elapsedTime;
    
	@ManyToOne
    @JoinColumn(name = "order_id")
	@JsonBackReference
	private Order order;
	
	public OrderDish() {}
	
	public OrderDish(Dish dish) {
		super();
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderDish [id=" + id + ", name=" + name + ", category=" + category + ", cost=" + cost + ", elapsedTime="
				+ elapsedTime + "]";
	}
}
