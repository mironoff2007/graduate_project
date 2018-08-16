package ru.mia.graduate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mia.graduate.MainController;
import ru.mia.graduate.model.Restaurant;


import java.util.List;


@Transactional
@Repository
public class RestaurantDAOImpl implements RestaurantDAO {


	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private MainController controller;

	@Autowired
    private BaseDAO baseDAO;

	@Override
	public void saveRestaurant(Restaurant theRestaurant) {
		/*
		Session currentSession = sessionFactory.openSession();
		currentSession.beginTransaction();
		currentSession.saveOrUpdate(theRestaurant);
		currentSession.getTransaction().commit();
		currentSession.close();
		*/
		baseDAO.saveObject(theRestaurant);

	}

	@Override
	public Restaurant getRestaurant(int theId) {
		Restaurant theRestaurant=(Restaurant)baseDAO.getObject(theId);
		/*
		Session currentSession = sessionFactory.openSession();
		try {
			currentSession.beginTransaction();
			theRestaurant =  currentSession.get(Restaurant.class, theId);
			currentSession.getTransaction().commit();
		}
		finally {
			currentSession.close();
		}
		*/

		return theRestaurant;
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		Session currentSession = sessionFactory.openSession();
		currentSession.beginTransaction();
		Query theQuery =
				currentSession.createQuery("from Restaurant order by id");
		currentSession.getTransaction().commit();
		List<Restaurant> restaurants = theQuery.list();
		currentSession.close();
		return  restaurants;
	}

	@Override
	public void getMaxIdRestaurant() {

	}

	@Override
	public void deleteRestaurant(int theId) {
		/*
		Session currentSession = sessionFactory.openSession();
		try {
			currentSession.beginTransaction();
		Query theQuery =
				currentSession.createQuery("delete from Restaurant where id=:reastarauntId");
		theQuery.setParameter("reastarauntId", theId);
		theQuery.executeUpdate();
			currentSession.getTransaction().commit();
		}
		finally {
			currentSession.close();
		}
		*/
		baseDAO.deleteObject(theId,"Restaurant");
	}


}

	






