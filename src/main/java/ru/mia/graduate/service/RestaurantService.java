package ru.mia.graduate.service;

import ru.mia.graduate.model.Restaurant;

import java.util.List;





public interface RestaurantService {

	public List<Restaurant> getRestaurants(int page);

	public void saveRestaurant(Restaurant theRestaurant);

	public void deleteRestaurant(int theId);

	public Restaurant getRestaurant(int theId);

}
