package com.task.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.restaurant.service.DishService;
import com.task.restaurant.to.DishTo;

@RestController
@RequestMapping("/restaurant")
public class MainController {
	@Autowired
	private DishService service;
	
	@GetMapping
	public List<DishTo> getAll() {
		return service.getAll();
	}
	
	@GetMapping("{ids}")
	public List<DishTo> getListWithTimeAndCost(@PathVariable List<Long> ids) {
		return service.getListWithTimeAndCost(ids);
	}
}
