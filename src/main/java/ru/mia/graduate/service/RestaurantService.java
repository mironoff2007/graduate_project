package ru.mia.graduate.service;

import ru.mia.graduate.model.Restaurant;

import java.util.List;





public interface RestaurantService {

	public List<Restaurant> getAllRestaurants();

	public void saveRestaurant(Restaurant theRestaurant);

	public void deleteRestaurant(int theId);

	public Restaurant getRestaurant(int theId);

}
