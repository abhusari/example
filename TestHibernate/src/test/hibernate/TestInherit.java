package test.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.inherit.dto.FourWheeler;
import test.inherit.dto.TwoWheeler;
import test.inherit.dto.Vehicle;

public class TestInherit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setName("Passat");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setName("Vento");
		
		Vehicle vehicle3 = new Vehicle();
		vehicle3.setName("Betle");
		
		/*TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setName("Bike");
		twoWheeler.setSteeringHandle("Bike Steering Handle");
		
		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setName("Car");
		fourWheeler.setSteeringWheel("Car Steering Handle");*/
		//C - Create out of CRUD
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(vehicle1);
//		session.save(twoWheeler);
//		session.save(fourWheeler);
		session.save(vehicle2);
		session.save(vehicle3);
		session.getTransaction().commit();
		session.close();

		//R - Read out of CRUD
		session = factory.openSession();
		session.beginTransaction();
		Vehicle vehicle = (Vehicle) session.get(Vehicle.class, 3);
		System.out.println(vehicle.toString());
		session.getTransaction().commit();
		session.close();
		
		//Detached to persistant select first selectBeforeUpdate because of @org.hibernate.annotations.Entity(selectBeforeUpdate=true)
		/*vehicle.setName("Benz");
		session = factory.openSession();
		session.beginTransaction();
		session.update(vehicle);
		session.getTransaction().commit();
		session.close();*/
		
		
		/*//U - Update out of CRUD
		session = factory.openSession();
		session.beginTransaction();
		vehicle = (Vehicle) session.get(Vehicle.class, 3);
		vehicle.setName("Beetle");
		System.out.println(vehicle.toString());
		session.getTransaction().commit();
		session.close();
		
		//D - Delete out of CRUD
		session = factory.openSession();
		session.beginTransaction();
		vehicle = (Vehicle) session.get(Vehicle.class, 2);
		session.delete(vehicle);
		session.getTransaction().commit();
		session.close();*/
	}

}
