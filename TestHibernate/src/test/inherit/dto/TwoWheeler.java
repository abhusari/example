package test.inherit.dto;
import javax.persistence.Entity;

@Entity
//Single table strategy
//@DiscriminatorValue("Bike") // Column value as bike for all entries for this class
public class TwoWheeler extends Vehicle {
	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}
	
}
