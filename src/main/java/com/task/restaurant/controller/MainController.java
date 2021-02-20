package com.task.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.restaurant.service.MainService;
import com.task.restaurant.model.Dish;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/restaurant")
public class MainController {
	private static final Logger log = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private MainService service;
	
	@GetMapping
	public List<Dish> getAll() {
		log.info("Runnig getAll()...");
		return service.getAll();
	}
	
	@GetMapping("{ids}")
	public Long addOrder(@PathVariable List<Long> ids) {
		log.info("Running addOrder()...");
		return service.addOrder(ids);
	}
}
