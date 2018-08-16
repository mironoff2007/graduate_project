package ru.mia.graduate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
	public List<User> getAllUsers() {
        Session currentSession = sessionFactory.openSession();
        currentSession.beginTransaction();
        Query theQuery =
                currentSession.createQuery("from User order by id");
        currentSession.getTransaction().commit();
        List<User> users = theQuery.list();
        currentSession.close();
        return  users;
	}

	@Override
	public void saveUser(User theUser) {
		Session currentSession = sessionFactory.openSession();
        currentSession.beginTransaction();
		currentSession.saveOrUpdate(theUser);
        currentSession.getTransaction().commit();
        currentSession.close();
	}

	@Override
	public void getMaxIdUser() {

	}

	@Override
	public void deleteUser(int theId) {
		Session currentSession = sessionFactory.openSession();
        try {
            currentSession.beginTransaction();
            Query theQuery =
                    currentSession.createQuery("delete from User where id=:userId1");
            theQuery.setParameter("userId1", theId);
            theQuery.executeUpdate();
            currentSession.getTransaction().commit();
        }
        finally {
            currentSession.close();
        }

    }

	@Override
	public User getUser(int theId) {
        User theUser;
        Session currentSession = sessionFactory.openSession();
        try {
            currentSession.beginTransaction();
            theUser =  currentSession.get(User.class, theId);
            currentSession.getTransaction().commit();
        }
        finally {
            currentSession.close();
        }
        return theUser;
	}
}

	






