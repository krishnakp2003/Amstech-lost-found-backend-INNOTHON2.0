package com.lost.found.convertor.entity;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lost.found.entity.Role;
import com.lost.found.entity.User;
import com.lost.found.entity.UserRole;
import com.lost.found.repo.RoleRepo;
import com.lost.found.request.model.UserRequestModel;

@Component

public class UserModelToEntity {

	@Autowired
	private RoleRepo roleRepo;
	private int roleId=2;
	public User userRegister(UserRequestModel requestModel) throws Exception {
		Optional<Role> roleOptional = roleRepo.findById(roleId);
		if(!roleOptional.isPresent()) {
			throw new Exception("role is not present");
		}
		
		User user= new User();
		user.setName(requestModel.getName());
		user.setAddress(requestModel.getAddress());
		user.setEmail(requestModel.getEmail());
		user.setPassword(requestModel.getPassword());
		user.setIdProof(requestModel.getIdProof());
		user.setMobileNumber(requestModel.getMobileNumber());
		
		UserRole userRole= new UserRole();

		userRole.setRole(roleOptional.get());
		userRole.setUser(user);
		user.setUserRoles(List.of(userRole));
		return user;
		
	}
}
