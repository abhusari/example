package test.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import test.dto.User;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		// Saving user objects
		/*for(int i=0;i<10;i++){
			User user = new User();
			user.setUserName("user "+(i+1));
			session.save(user);
		}*/
		String minUser = "5";
		Query query = session.createQuery("from User where userId >? and userId < :maxUser"); //"from User where userId<5"
		query.setInteger(0, Integer.parseInt(minUser));// ?
		query.setInteger("maxUser", 8);// By string
		/*	query.setFirstResult(5); // start result after 5 records
		query.setMaxResults(2); // max result
		 */		
		List<User> users = query.list();
		for(User user:users){
			System.out.println(user.getUserName());
		}
		System.out.println("User count :: "+users.size());

		//Namesd query
		System.out.println("Named query:---");
		query =  session.getNamedQuery("User.byId");
		query.setInteger(0, Integer.parseInt(minUser));
		users = query.list();
		for(User user:users){
			System.out.println(user.getUserName());
		}
		System.out.println("User count :: "+users.size());

		//Namesd Native query
		System.out.println("Named native query:---");
		query =  session.getNamedQuery("User.byName");
		query.setString(0, "user 3");
		users = query.list();
		for(User user:users){
			System.out.println(user.getUserName());
		}
		System.out.println("User count :: "+users.size());


		//Criterian API query
		System.out.println("Named native query:---");
		Criteria criteria =  session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", "user 9"));//.addOrder(Order.desc("userId"));
				// .setProjection(Projections.count("userName"));
		
		List<User> usersByCrteria = (List<User> ) criteria.list();
		for(User user:usersByCrteria){
			System.out.println(user.getUserName());
		}
		System.out.println("User count :: "+usersByCrteria.size());
		
		//Criterian API query
				System.out.println("Criteria using example query:---");
				User userDetail = new User();
				userDetail.setUserName("user 1%");
				Example example = Example.create(userDetail).enableLike();
				criteria =  session.createCriteria(User.class);
							criteria.add(example);
				
				usersByCrteria = (List<User> ) criteria.list();
				for(User user:usersByCrteria){
					System.out.println(user.getUserName());
				}
				System.out.println("User count :: "+usersByCrteria.size());


		session.getTransaction().commit();
		session.close();


		/*session = factory.openSession();
		session.beginTransaction();
		query = session.createQuery("select userName from User"); //"from new map(userId, userName) User"
		List<String> userNames = query.list();
		session.getTransaction().commit();
		session.close();
		for(String user:userNames){
			System.out.println(user);
		}*/

	}

}
