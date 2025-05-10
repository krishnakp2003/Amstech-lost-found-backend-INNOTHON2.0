
package com.lost.found.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.lost.found.convertor.entity.UserModelToEntity;
import com.lost.found.convertor.model.UserEntityToModel;
import com.lost.found.entity.User;
import com.lost.found.repo.UserRepo;
import com.lost.found.request.model.UserLoginRequestModel;
import com.lost.found.request.model.UserRequestModel;
import com.lost.found.response.model.UserResponseModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserModelToEntity userModelToEntity;
	@Autowired
	private UserEntityToModel  userEntityToModel;
	
	public UserResponseModel userRegister(UserRequestModel userRequestModel) throws Exception {
		log.debug("fecting user by eamil ");
		User byEmail = userRepo.findByEmail(userRequestModel.getEmail());
		if (byEmail != null) {
			throw new Exception("An account with this email already exists. Please use another email.");
		}
		log.debug("fetching user by PhoneNumber");
		User byPhoneNumber = userRepo.findByPhoneNumber(userRequestModel.getMobileNumber());
		if (byPhoneNumber != null) {
			throw new Exception("An account with this Phonenumber already exists. Please use another Phonenumber.");
		}
		User saveConverter = userModelToEntity.userRegister(userRequestModel);
		User user = userRepo.save(saveConverter);
		return userEntityToModel.getfindbyId(user);

	}
	public UserResponseModel userLogin(UserLoginRequestModel loginRequestModel) throws Exception {
		log.debug("fetching user by username");
		User byUsername = userRepo.findByUsername(loginRequestModel.getUserName(),
				loginRequestModel.getPassword());

		if (byUsername == null) {
			throw new Exception(" Invalid credentials. Please check your username and password and try again"
					+ loginRequestModel.getUserName());
		}
		
		return userEntityToModel.getfindbyId(byUsername);

	}
}
