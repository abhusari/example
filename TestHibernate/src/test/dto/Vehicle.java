package test.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE_DETAILS")
public class Vehicle {
	@Id
	@GeneratedValue
	@Column(name = "VEHICLE_ID")
	private int id;
	@Column(name = "VEHICLE_NAME")
	private String name;
	// This is for ManyToOne
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="USER_ID") private UserDetails user;
	 */
	@ManyToMany(mappedBy = "vehicleList")
	private Collection<UserDetails> userList = new ArrayList<UserDetails>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// This is for ManyToOne
	/*
	 * public UserDetails getUser() { return user; }
	 * 
	 * public void setUser(UserDetails user) { this.user = user; }
	 */

	public Collection<UserDetails> getUserList() {
		return userList;
	}

	public void setUserList(Collection<UserDetails> userList) {
		this.userList = userList;
	}

}
