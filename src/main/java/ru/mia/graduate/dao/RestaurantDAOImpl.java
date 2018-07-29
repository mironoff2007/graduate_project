package ru.mia.graduate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mia.graduate.MainController;
import ru.mia.graduate.model.Restaurant;

import java.util.List;



@Repository
public class RestaurantDAOImpl implements RestaurantDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private MainController controller;
	
	@Override
	public List<Restaurant> getRestaurants(int page) {
		return null;
	}

	@Override
	public void saveRestaurant(Restaurant theRestaurant) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("save or update / theBook="+theRestaurant);
		// save the customer ... finally LOL
		currentSession.saveOrUpdate(theRestaurant);
		System.out.println("saved");
	}

	@Override
	public void getMaxIdRestaurant() {

	}

	@Override
	public void deleteRestaurant(int theId) {

	}

	@Override
	public Restaurant getRestaurant(int theId) {
		return null;
	}
}

	






