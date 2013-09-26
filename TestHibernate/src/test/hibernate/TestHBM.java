/**
 * 
 */
package test.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.dto.Item;
import test.dto.Vehicle;
import test.dto.UserDetails;
import test.dto.Vehicle;

/**
 * @author AB0055518
 * 
 */
public class TestHBM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserDetails userDetails = new UserDetails();
		// userDetails.setUserId(1);
		userDetails.setUserName("Arjun");
		userDetails.setAddress("Achalpur");
		userDetails.setDescription("Farmer");
		userDetails.setJoinedDate(new Date());

		// Many to many
		/*
		 * UserDetails userDetails1 = new UserDetails(); //
		 * userDetails.setUserId(1); userDetails1.setUserName("Arjun");
		 * userDetails1.setAddress("Achalpur");
		 * userDetails1.setDescription("Farmer"); userDetails1.setJoinedDate(new
		 * Date());
		 */
		Item item = new Item();
		item.setCode("1");
		item.setName("x");
		userDetails.getItemsSet().add(item);
		// Many to many
		// userDetails1.getItemsSet().add(item);
		item = new Item();
		item.setCode("2");
		item.setName("y");
		userDetails.getItemsSet().add(item);
		// Many to many
		// userDetails1.getItemsSet().add(item);

		// UserDetails userDetails1 = new UserDetails();
		// // userDetails.setUserId(1);
		// userDetails1.setUserName("Anupam");
		// userDetails1.setAddress("Achalpur");
		// userDetails1.setDescription("Engineer");
		// userDetails1.setJoinedDate(new Date());

		Vehicle vehicle = new Vehicle();
		vehicle.setName("Beetle");
		// Many to one
		// vehicle.setUser(userDetails);
		// Many to many
		// vehicle.getUserList().add(userDetails);
		userDetails.getVehicleList().add(vehicle);
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setName("Passat");
		// Many to one
		// vehicle1.setUser(userDetails);
		// Many to many
		// vehicle1.getUserList().add(userDetails1);
		userDetails.getVehicleList().add(vehicle1);

		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		try {
			/*
			 * Configuration configuration = new Configuration();
			 * configuration.configure(); ServiceRegistry serviceRegistry = new
			 * ServiceRegistryBuilder
			 * ().applySettings(configuration.getProperties
			 * ()).buildServiceRegistry(); SessionFactory sessionFactory =
			 * configuration.buildSessionFactory(serviceRegistry);
			 */
			Session session = factory.openSession();
			session.beginTransaction();
			session.save(userDetails);
			// Many to many
			// session.save(userDetails1);
			session.save(vehicle);
			session.save(vehicle1);
			session.getTransaction().commit();
			session.close();

			/*
			 * userDetails = null; session = factory.openSession();
			 * session.beginTransaction(); userDetails = (UserDetails)
			 * session.get(UserDetails.class, 1);
			 * System.out.println(userDetails.toString()); session.close();
			 * System.out.println("Lazy  :-"+userDetails.getItemsSet());
			 */
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}

}
