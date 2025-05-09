package com.lost.found.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the missing_person database table.
 * 
 */
@Entity
@Table(name="missing_person")
@NamedQuery(name="MissingPerson.findAll", query="SELECT m FROM MissingPerson m")
public class MissingPerson implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int age;

	private String description;

	private String email;

	private String gender;

	@Column(name="id_proof")
	private String idProof;

	@Column(name="mobile_number")
	private String mobileNumber;

	private String name;

	//bi-directional many-to-one association to FoundData
	@OneToMany(mappedBy="missingPerson")
	private List<FoundData> foundData;

	public MissingPerson() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
		foundData.setMissingPerson(this);

		return foundData;
	}

	public FoundData removeFoundData(FoundData foundData) {
		getFoundData().remove(foundData);
		foundData.setMissingPerson(null);

		return foundData;
	}

}