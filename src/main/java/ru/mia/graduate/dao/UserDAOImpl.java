package ru.mia.graduate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mia.graduate.model.User;

import java.util.List;


@Transactional
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private BaseDAO baseDAO;


    @Override
    public void saveUser(User theUser) {
        baseDAO.saveObject(theUser);
    }

    @Override
    public User getUser(int theId) {
        return (User)baseDAO.getObject(theId,User.class);
    }

    @Override
    public List<User> getAllUsers() {
        return  baseDAO.getAllObjects("User");
    }

    @Override
    public void getMaxIdUser() {

    }

    @Override
    public void deleteUser(int theId) {
        baseDAO.deleteObject(theId,"User");
    }
}

	






