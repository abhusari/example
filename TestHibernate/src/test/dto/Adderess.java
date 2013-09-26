/**
 * 
 */
package test.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author AB0055518
 *
 */
@Embeddable // used to embed the object
public class Adderess {
	@Column(name="CITY_NAME")
	private String city;
	@Column(name="STATE_NAME")
	private String state;
	@Column(name="PIN_CODE")
	private String zip;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "Adderess [city=" + city + ", state=" + state + ", zip=" + zip
				+ "]";
	}
	
	

}
