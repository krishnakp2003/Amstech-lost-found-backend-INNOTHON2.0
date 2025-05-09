package com.lost.found.convertor.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lost.found.entity.User;
import com.lost.found.entity.UserRole;
import com.lost.found.response.model.RoleResponseModel;
import com.lost.found.response.model.UserResponseModel;


@Component
public class UserEntityToModel {

	public UserResponseModel getfindbyId(User user) {
		UserResponseModel responseModel = new UserResponseModel();
		responseModel.setId(user.getId());
		responseModel.setName(user.getName());
		responseModel.setIdProof(user.getIdProof());
		responseModel.setEmail(user.getEmail());
		responseModel.setMobileNumber(user.getMobileNumber());
		responseModel.setAddress(user.getAddress());

		List<RoleResponseModel> roleResponseModels = new ArrayList();
		List<UserRole> userRoles = user.getUserRoles();
		for (UserRole userRole : userRoles) {
			RoleResponseModel roleResponseModel = new RoleResponseModel();
			roleResponseModel.setId(userRole.getRole().getId());
			roleResponseModel.setName(userRole.getRole().getName());
			roleResponseModels.add(roleResponseModel);

		}

		responseModel.setRoles(roleResponseModels);

		return responseModel;

	}

}
