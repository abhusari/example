package test.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.dto.User;

public class TestCache {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		//User user= (User) session.get(User.class, 1);
		Query query = session.createQuery("from User where userId = 1"); //"from User where userId<5"
		query.setCacheable(true);
		List<User> users = query.list();
		session.getTransaction().commit();
		session.close();
		
		
		Session session2 = factory.openSession();
		session2.beginTransaction();
		//User user1= (User) session2.get(User.class, 1);
		// Caching queries.
		Query query1 = session2.createQuery("from User where userId = 1"); //"from User where userId<5"
		query1.setCacheable(true); // Not only cache result but checks in second level cache
		List<User> users1 = query1.list();
		session2.getTransaction().commit();
		session2.close();
	}
}
