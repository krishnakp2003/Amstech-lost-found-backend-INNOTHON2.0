package com.lost.found.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the found_data database table.
 * 
 */
@Entity
@Table(name="found_data")
@NamedQuery(name="FoundData.findAll", query="SELECT f FROM FoundData f")
public class FoundData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="created_at")
	private Timestamp createdAt;

	private String location;

	private Timestamp time;

	//bi-directional many-to-one association to MissingPerson
	@ManyToOne
	@JoinColumn(name="missing_person_id")
	private MissingPerson missingPerson;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public FoundData() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public MissingPerson getMissingPerson() {
		return this.missingPerson;
	}

	public void setMissingPerson(MissingPerson missingPerson) {
		this.missingPerson = missingPerson;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}