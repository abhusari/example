/**
 * 
 */
package org.test.xstream;

import com.thoughtworks.xstream.XStream;

/**
 * @author AB0055518
 *
 */
public class TestXstream {
	public static void main(String[] args) {
		XStream xstream = new XStream();
		Person joe = new Person("Joe", "Walnes");
		joe.getCars().add(new Car("2", "Bike"));
		xstream.alias("person", Person.class);
		xstream.alias("car", Car.class);
		xstream.useAttributeFor(Car.class, "wheelno");
		xstream.useAttributeFor(Car.class, "type");
		String xml = xstream.toXML(joe);
		System.out.println(xml);
		xml = "<personResponse><firstname>Anupam</firstname><lastname>Bhusari</lastname><Cars><car wheelno=\"3\"><type>Jeep</type></car></Cars></personResponse>";
		XStream xstream1 = new XStream();
		xstream1.alias("personResponse", Person.class);
		xstream1.alias("car", Car.class);
		xstream1.useAttributeFor(Car.class, "wheelno");
		xstream1.useAttributeFor(Car.class, "type");
		joe = (Person) xstream1.fromXML(xml);
		System.out.println(joe);
	}

}
