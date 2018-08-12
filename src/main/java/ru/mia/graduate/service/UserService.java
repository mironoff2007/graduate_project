package ru.mia.graduate.service;

import ru.mia.graduate.model.User;

import java.util.List;





public interface UserService {

	public List<User> getUsers(int page);

	public void saveUser(User theUser);

	public void deleteUser(int theId);

	public User getUser(int theId);

	public void readUser(int theId);
	
}
