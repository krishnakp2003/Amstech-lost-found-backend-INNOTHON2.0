package com.lost.found.request.model;

import lombok.Data;

@Data
public class MissingPersonRequestModel {
	private String name;
	private int age;
	private String email;
	private String gender;
	private String idProof;
	private String mobileNumber;
	private String description;

}
