package ru.mia.graduate.dao;

import ru.mia.graduate.model.User;

import java.util.List;


public interface UserDAO {

	public List<User> getAllUsers();

	public void saveUser (User theUser);

    public void getMaxIdUser();

	void deleteUser(int theId);

	User getUser(int theId);

	
	
}
