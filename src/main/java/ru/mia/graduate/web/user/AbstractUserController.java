package ru.mia.graduate.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.mia.graduate.model.User;
import ru.mia.graduate.service.UserService;


import java.util.List;



public abstract class AbstractUserController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService service;

    public List<User> getAll() {
        log.info("getAll");
        return service.getAllUsers();
    }

    public User get(int id) {
        log.info("get {}", id);
        return service.getUser(id);
    }

    public User create(User user) {
        log.info("create {}", user);

        return null;
    }

    public void delete(int id) {
        log.info("delete {}", id);
        service.deleteUser(id);
    }

    public void update(User user, int id) {
        log.info("update {} with id={}", user, id);
    }

    public User getByMail(String email) {
        log.info("getByEmail {}", email);
        return null;
    }
}
