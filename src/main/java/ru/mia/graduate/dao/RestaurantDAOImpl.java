package ru.mia.graduate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
		System.out.println("save or update / theRestaurant="+theRestaurant);
		// save the customer ... finally LOL
		currentSession.saveOrUpdate(theRestaurant);
		System.out.println("saved");
	}

	@Override
	public void getMaxIdRestaurant() {

	}

	@Override
	public void deleteRestaurant(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery =
				currentSession.createQuery("delete from Restaurant where id=:reastarauntId");
		theQuery.setParameter("restarauntId", theId);

		theQuery.executeUpdate();
	}

	@Override
	public Restaurant getRestaurant(int theId) {
		return null;
	}
}

	






