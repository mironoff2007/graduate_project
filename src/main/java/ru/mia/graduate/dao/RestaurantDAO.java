package ru.mia.graduate.dao;

import ru.mia.graduate.model.Restaurant;

import java.util.List;


public interface RestaurantDAO {

	public List<Restaurant> getAllRestaurants();

	public void saveRestaurant (Restaurant theRestaurant);

    public void getMaxIdRestaurant();

	void deleteRestaurant(int theId);

	Restaurant getRestaurant(int theId);

	
	
}
