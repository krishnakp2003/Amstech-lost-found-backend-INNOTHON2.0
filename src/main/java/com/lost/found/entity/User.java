package com.lost.found.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String address;

	private String email;

	@Column(name="id_proof")
	private String idProof;

	@Column(name="mobile_number")
	private String mobileNumber;

	private String name;

	//bi-directional many-to-one association to FoundData
	@OneToMany(mappedBy="user")
	private List<FoundData> foundData;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="user")
	private List<UserRole> userRoles;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdProof() {
		return this.idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FoundData> getFoundData() {
		return this.foundData;
	}

	public void setFoundData(List<FoundData> foundData) {
		this.foundData = foundData;
	}

	public FoundData addFoundData(FoundData foundData) {
		getFoundData().add(foundData);
		foundData.setUser(this);

		return foundData;
	}

	public FoundData removeFoundData(FoundData foundData) {
		getFoundData().remove(foundData);
		foundData.setUser(null);

		return foundData;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setUser(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setUser(null);

		return userRole;
	}

}