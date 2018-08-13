package ru.mia.graduate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mia.graduate.MainController;
import ru.mia.graduate.model.User;

import java.util.List;


@Transactional
@Repository
public class UserDAOImpl implements UserDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private MainController controller;
	
	@Override
	public List<User> getUsers(int page) {
		return null;
	}

	@Override
	public void saveUser(User theUser) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("save or update / theUser="+theUser);
		// save the customer ... finally LOL
		currentSession.saveOrUpdate(theUser);
		System.out.println("saved");
	}

	@Override
	public void getMaxIdUser() {

	}

	@Override
	public void deleteUser(int theId) {
		
	}

	@Override
	public User getUser(int theId) {
		return null;
	}
}

	





