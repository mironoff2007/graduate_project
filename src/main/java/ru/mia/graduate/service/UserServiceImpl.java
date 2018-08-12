package ru.mia.graduate.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mia.graduate.dao.UserDAO;
import ru.mia.graduate.model.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {


	@Autowired
	private UserDAO userDAO;


	@Override
	public List<User> getUsers(int page) {
		return null;
	}

	@Override
	public void saveUser(User theUser) {

	}

	@Override
	public void deleteUser(int theId) {

	}

	@Override
	public User getUser(int theId) {
		return null;
	}

	@Override
	public void readUser(int theId) {

	}
}





