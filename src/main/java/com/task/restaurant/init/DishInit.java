package com.task.restaurant.init;

/*
 * Test Data
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.task.restaurant.model.Dish;
import com.task.restaurant.model.DishCategory;
import com.task.restaurant.repositroy.DishRepository;

@Component
public class DishInit implements ApplicationRunner {
	@Autowired
	private DishRepository repository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		long count = repository.count();
		
		if (count == 0) {
			repository.save(new Dish("Onion soup", DishCategory.Soups, 5.20, 15L));
			repository.save(new Dish("Tomato soup", DishCategory.Soups, 6.00, 15L));
			repository.save(new Dish("Mushroom cream soup", DishCategory.Soups, 7.35, 15L));
			repository.save(new Dish("Chicken broth", DishCategory.Soups, 8.05, 20L));
			repository.save(new Dish("Fish soup", DishCategory.Soups, 8.10, 20L));
			repository.save(new Dish("Miso soup", DishCategory.Soups, 7.00, 15L));
			repository.save(new Dish("Vegetable soup", DishCategory.Soups, 7.15, 15L));
			repository.save(new Dish("Goulash soup", DishCategory.Soups,8.15, 20L));
			repository.save(new Dish("Caesar salad", DishCategory.Salads, 4.25, 10L));
			repository.save(new Dish("Greek salad", DishCategory.Salads, 4.35, 10L));
			repository.save(new Dish("Roast chicken and potatoes", DishCategory.MainDishes, 9.15, 25L));
			repository.save(new Dish("Spaghetti Bolognese", DishCategory.MainDishes, 9.25, 25L));
			repository.save(new Dish("Lasagna", DishCategory.MainDishes, 9.00, 20L));
			repository.save(new Dish("Pasta Carbonara", DishCategory.MainDishes, 9.15, 25L));
			repository.save(new Dish("Roast ", DishCategory.MainDishes, 8.45, 25L));
			repository.save(new Dish("Grilled vegetables", DishCategory.Appetizers, 7.05, 15L));
			repository.save(new Dish("French fries", DishCategory.Appetizers, 6.50, 10L));
			repository.save(new Dish("Tea", DishCategory.Beverages,1.00, 5L));
			repository.save(new Dish("Coffee", DishCategory.Beverages,1.00, 5L));
			repository.save(new Dish("Juice", DishCategory.Beverages,1.15, 0L));
			repository.save(new Dish("Wine", DishCategory.Beverages,5.00, 0L));
		}
	}
	
	
}
