package test.inherit.dto;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
//Single table strategy
/*@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
		name="VEHICLE_TYPE",
		discriminatorType=DiscriminatorType.STRING
		)*/

//Table per class inheritance strategy.
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

//Joined inheritance strategy.
//select * from vehicle join fourwheeler ON fourwheeler.id = vehicle.id;
//@Inheritance(strategy=InheritanceType.JOINED)
public class Vehicle {
	@Id
	//In a Table-Per-Class Strategy you use one table per class and each one has an id. dont use @GeneratedValue auto in  TABLE_PER_CLASS
	//@GeneratedValue(strategy = GenerationType.TABLE)
	@GeneratedValue
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", name=" + name + ", licenseNumber="
				+  "]";
	}

}
