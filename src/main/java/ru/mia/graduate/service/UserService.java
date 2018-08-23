package ru.mia.graduate.service;

import ru.mia.graduate.model.User;

import java.util.List;





public interface UserService {

	public List<User> getAllUsers();

	public void saveUser(User theUser);

	public void deleteUser(int theId);

	public User getUser(int theId);

	
}
