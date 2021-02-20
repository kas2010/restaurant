package com.task.restaurant.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<OrderDish> dishes = new ArrayList<>();

	private OrderState state;
	private LocalDate createDate;
	private LocalDate changeDate;
	private Double totalCost;
	private Long totalElapsedTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<OrderDish> getDishes() {
		return dishes;
	}

	public void setDishes(List<OrderDish> dishes) {
		this.dishes.clear();
		this.dishes.addAll(dishes);
		this.dishes.forEach(n -> n.setOrder(this));
	}

	public OrderState getState() {
		return state;
	}

	public void setState(OrderState state) {
		this.state = state;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(LocalDate changeDate) {
		this.changeDate = changeDate;
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
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", dishes=" + dishes + ", state=" + state + ", createDate=" + createDate
				+ ", changeDate=" + changeDate + ", totalCost=" + totalCost + ", totalElapsedTime=" + totalElapsedTime
				+ "]";
	}
}
