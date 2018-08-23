package ru.mia.graduate.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mia.graduate.dao.RestaurantDAO;
import ru.mia.graduate.model.Restaurant;

import java.util.List;


@Service
public class RestaurantServiceImpl implements RestaurantService {


	@Autowired
	private RestaurantDAO restaurantDAO;


	@Override
	public List<Restaurant> getAllRestaurants() {
		return null;
	}

	@Override
	public void saveRestaurant(Restaurant theRestaurant) {

	}

	@Override
	public void deleteRestaurant(int theId) {

	}

	@Override
	public Restaurant getRestaurant(int theId) {
		return null;
	}

}





