/**
 * 
 */
package org.test.xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * @author AB0055518
 *
 */
@XStreamAlias(value="car")
public class Car {
	private String wheelno;
	private String type;
	public Car(String wheelno, String type) {
		super();
		this.wheelno = wheelno;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Car [wheelno=" + wheelno + ", type=" + type + "]";
	}
	
}
