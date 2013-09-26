/**
 * 
 */
package org.test.xstream;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/**
 * @author AB0055518
 *
 */
public class Person {
	 private String firstname;
	 private String lastname;
	 @XStreamAlias(value="CarsList")
	 private List<Car> Cars;
	public Person(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public List<Car> getCars() {
		if(Cars==null)
			Cars = new ArrayList<Car>();
		return Cars;
	}
	@Override
	public String toString() {
		return "Person [firstname=" + firstname + ", lastname=" + lastname
				+ ", Cars=" + Cars + "]";
	}
	public void setCars(List<Car> cars) {
		Cars = cars;
	}
	

}
