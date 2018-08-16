package graduate.dao;

import graduate.ActiveDbProfileResolver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.mia.graduate.dao.RestaurantDAO;
import ru.mia.graduate.model.Dish;
import ru.mia.graduate.model.Restaurant;


@ContextConfiguration({
		"classpath:spring-servlet.xml"
})
//
@RunWith(SpringRunner.class)
//@Sql(config = @SqlConfig(encoding = "UTF-8"))
@ActiveProfiles(resolver = ActiveDbProfileResolver.class)
public class RestaurantDAOImplTest  {
	@Autowired
	private RestaurantDAO restaurantDAO;

	@Before
	public void setUp() throws Exception {
		//cacheManager.getCache("users").clear();
	}

	@Test
	public void saveRestaurant() throws Exception {
		Restaurant newRestaurant = new Restaurant("Rest1");
		Dish dish1= new Dish("Dish1",10);
		Dish dish2= new Dish("Dish2",20);
		newRestaurant.addDish(dish1);
		newRestaurant.addDish(dish2);
		restaurantDAO.saveRestaurant(newRestaurant);
	}

	@Test
	public void getAllRestaurants() throws Exception {
		restaurantDAO.getAllRestaurants();
	}
	@Test
	public void getRestaurant() throws Exception {
		System.out.println("getRestaurant1 - " + restaurantDAO.getRestaurant(1));
		System.out.println("getRestaurant2 - " + restaurantDAO.getRestaurant(3));
	}

	@Test
	public void deleteRestaurant() throws Exception {
		restaurantDAO.deleteRestaurant(1);
		restaurantDAO.deleteRestaurant(2);
	}


}


	






