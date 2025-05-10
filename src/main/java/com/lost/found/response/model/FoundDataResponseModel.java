package com.lost.found.response.model;

import java.sql.Timestamp;
import lombok.Data;

@Data
public class FoundDataResponseModel {

	private int id;
	private int missingPersonId;
	private int age;
	private String description;
	private String email;
	private String gender;	
	private String idProof;
	private String mobileNumber;
	private String name;
	private Timestamp createdAt;
	private String location;
	private Timestamp time;
}
