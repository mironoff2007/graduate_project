package ru.mia.graduate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mia.graduate.model.Restaurant;

import java.util.List;


@Transactional
@Repository
public class RestaurantDAOImpl implements RestaurantDAO {


	@Autowired
    private BaseDAO baseDAO;

	@Override
	public void saveRestaurant(Restaurant theRestaurant) {
		baseDAO.saveObject(theRestaurant);
	}

	@Override
	public Restaurant getRestaurant(int theId) {
		return (Restaurant)baseDAO.getObject(theId,Restaurant.class);
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		return  baseDAO.getAllObjects("Restaurant");
	}

	@Override
	public void getMaxIdRestaurant() {

	}

	@Override
	public void deleteRestaurant(int theId) {
		baseDAO.deleteObject(theId,"Restaurant");
	}


}

	






