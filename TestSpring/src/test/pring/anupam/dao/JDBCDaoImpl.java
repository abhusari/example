package test.pring.anupam.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.pring.anupam.Circle;
import test.pring.anupam.dao.hibernate.DaoImpl;


public class JDBCDaoImpl {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		TestDao testDao = (TestDao) context.getBean("testDao");
	/*	Circle circle = testDao.getSpringCircle(2);
		System.out.println(circle.toString());
		System.out.println(testDao.getCircleCount());*/
		
//		// Rowmapper
//		circle = testDao.getcircle(1);
//		System.out.println(circle.toString());
		
		DaoSupport dao = (DaoSupport) context.getBean("daoSupport");
		System.out.println("DaoSupport "+dao.getCircleCount());
		
	/*	
		//Hibernate
		
		DaoImpl hibernateDao = (DaoImpl) context.getBean("daoImpl");
		System.out.println("hibernateDao " +hibernateDao.getCircleCount());*/

	}
	
	
}
