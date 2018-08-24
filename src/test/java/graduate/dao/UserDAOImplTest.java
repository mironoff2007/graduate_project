package graduate.dao;

import graduate.ActiveDbProfileResolver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.mia.graduate.dao.UserDAO;
import ru.mia.graduate.model.Role;
import ru.mia.graduate.model.User;
import ru.mia.graduate.util.DateTimeUtil;

import java.util.HashSet;
import java.util.Set;


@ContextConfiguration({
        "classpath:spring/spring-servlet.xml"
})
//
@RunWith(SpringRunner.class)
//@Sql(config = @SqlConfig(encoding = "UTF-8"))
@ActiveProfiles(resolver = ActiveDbProfileResolver.class)
public class UserDAOImplTest {
	@Autowired
	private UserDAO userDAO;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void saveUser() throws Exception {
		Set<Role> roles = new HashSet<Role>();
		roles.add(Role.ROLE_USER);
		//
		User newUser = new User("User1");
		newUser.setVote_restaurant(1);
		newUser.setVote_time(DateTimeUtil.nowFormatted());
		newUser.setRoles(roles);
		userDAO.saveUser(newUser);
		//
		roles.add(Role.ROLE_ADMIN);
		User newUser2 = new User("User2");
		newUser2.setVote_restaurant(1);
		newUser2.setRoles(roles);
		newUser2.setVote_time(DateTimeUtil.nowFormatted());
		userDAO.saveUser(newUser2);
	}

	@Test
	public void getUser() throws Exception {
            System.out.println("getUser1 - " + userDAO.getUser(1));
            System.out.println("getUser2 - " + userDAO.getUser(3));
	}

	@Test
	public void getAllUsers() throws Exception {
		userDAO.getAllUsers();
	}

	@Test
	public void deleteUser() throws Exception {
	    userDAO.deleteUser(1);
        userDAO.deleteUser(2);
        userDAO.deleteUser(3);
	}

}


	






