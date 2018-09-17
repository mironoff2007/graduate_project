package ru.mia.graduate.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mia.graduate.dao.UserDAO;
import ru.mia.graduate.model.User;
import ru.mia.graduate.util.DateTimeUtil;

import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {


	@Autowired
	private UserDAO userDAO;


	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Override
	public void saveUser(User theUser) {
		userDAO.saveUser(theUser);
	}

	@Override
	public void deleteUser(int theId) {
		userDAO.deleteUser(theId);
	}

	@Override
	public User getUser(int theId) {
		return userDAO.getUser(theId);
	}


	public void vote(User user,int restaurantId)
	{
		String userTime= user.getVote_time();
		if(DateTimeUtil.isBeforeToday(userTime)) {
			user.setVote_restaurant(restaurantId);
			saveUser(user);
		}
		else if(DateTimeUtil.isBeforeVoteTime(userTime)) {
			user.setVote_restaurant(restaurantId);
			saveUser(user);
		}
	}

}





