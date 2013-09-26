package test.pring.anupam.dao.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class DaoImpl {
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public int getCircleCount(){
		Session session  = getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "select count(*) from Circle";
		Query query = session.createQuery(hql);
		return ((Long) query.uniqueResult()).intValue();
	}

}
