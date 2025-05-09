package com.lost.found.response.model;

import java.util.List;

import lombok.Data;

@Data
public class UserResponseModel {
	private int id;
	private String address;
	private String email;
	private String idProof;
	private String mobileNumber;
	private String name;
	List<RoleResponseModel> roles;
}
