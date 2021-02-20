package com.task.restaurant.model;

public enum OrderState {
	Awaiting(1L), Processing(2L), Canceled(3L), Completed(4L);

	private Long id;

	private OrderState(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

}
