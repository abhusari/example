/**
 * 
 */
package test.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * @author AB0055518
 * 
 */
@Entity
// (name="USER_DETAILS") this will give name for whole entity using @Tabel will
// gave name to table only
@Table(name = "USER_DETAILS")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// Will automatically generate the surroget key.
	@Column(name = "USER_ID")
	// Change column name
	private int userId;
	private String userName;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "city", column = @Column(name = "HOME_CITY")),
		@AttributeOverride(name = "state", column = @Column(name = "HOME_STATE")),
		@AttributeOverride(name = "zip", column = @Column(name = "HOME_PIN_CODE")) })
	private Adderess homeAddress;

	@Embedded
	// // used to embed the object
	@AttributeOverrides({
		@AttributeOverride(name = "city", column = @Column(name = "OFFICE_CITY")),
		@AttributeOverride(name = "state", column = @Column(name = "OFFICE_STATE")),
		@AttributeOverride(name = "zip", column = @Column(name = "OFFICE_PIN_CODE")) })
	// Override embedded object
	private Adderess officeAddress;

	@Transient
	// Hibernate will skip this column from inserting in DB . Alternate way
	// Define it static or @ransient
	private String address;
	@Lob
	private String description;
	@Temporal(TemporalType.DATE)
	// Without @Temporal it will store with timestamp also
	private Date joinedDate;

	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_ITEM", joinColumns = @JoinColumn(name = "USER_ID"))
	// private Set<Item> itemsSet = new HashSet<Item>();
	// @GenericGenerator(name="hilo.gen",strategy="hilo") // For auto generating
	// Embedded objects key
	// @CollectionId (columns={@Column(name="ITEM_ID")},generator="hilo.gen",
	// type=@Type(type="long"))
	private Collection<Item> itemsSet = new ArrayList<Item>();

	// @OneToOne
	/*
	 * @JoinColumn(name="VEHICLE_ID") // optional for onetoMany private Vehicle
	 * vehicle;
	 */
	// This will create new table for on2tomany
	/*
	 * @OneToMany
	 * 
	 * @JoinTable(joinColumns=@JoinColumn(name="USER_ID"),
	 * inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"),name="USER_VEHICLE" )
	 */

	/*
	 * @OneToMany(mappedBy="user")// this will not create new table
	 */
	@ManyToMany
	private Collection<Vehicle> vehicleList = new ArrayList<Vehicle>();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public Adderess getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Adderess homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Adderess getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Adderess officeAddress) {
		this.officeAddress = officeAddress;
	}

	/*
	 * public Set<Item> getItemsSet() { return itemsSet; }
	 * 
	 * public void setItemsSet(Set<Item> itemsSet) { this.itemsSet = itemsSet; }
	 */

	public Collection<Item> getItemsSet() {
		return itemsSet;
	}

	public void setItemsSet(Collection<Item> itemsSet) {
		this.itemsSet = itemsSet;
	}

	/*
	 * public Vehicle getVehicle() { return vehicle; }
	 * 
	 * public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
	 */

	public Collection<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(Collection<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName
				+ ", address=" + address + ", description=" + description
				+ ", joinedDate=" + joinedDate + "]";
	}

}
