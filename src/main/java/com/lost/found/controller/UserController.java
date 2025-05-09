package com.lost.found.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lost.found.request.model.UserLoginRequestModel;
import com.lost.found.request.model.UserRequestModel;
import com.lost.found.response.model.UserResponseModel;
import com.lost.found.restresponse.RestResponse;
import com.lost.found.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;
	public UserController() {
		System.out.println("UserController:Object Created");
	}
	
	@Operation(summary = "You can use this method for user register", description = "This is desc")
	@RequestMapping(method = RequestMethod.POST, value = "/userRegister", consumes = "application/json", produces = "application/json")
	public RestResponse signup(@RequestBody UserRequestModel requestModel) {

		
		try {
			UserResponseModel responseModel = userService.userRegister(requestModel);
			return RestResponse.build().withSuccess("User created successfully", responseModel);
		} catch (Exception e) {
			log.error("Failed to save user due to: {}", e.getMessage(), e);
			return RestResponse.build().withError(e.getMessage());

		}
	}
	@Operation(summary = "You can use this method for user Login", description = "This is desc")
	@RequestMapping(method = RequestMethod.POST, value = "/userLogin", consumes = "application/json", produces = "application/json")
	public RestResponse signup(@RequestBody UserLoginRequestModel loginRequestModel) {

		try {
			UserResponseModel responseModel = userService.userLogin(loginRequestModel);
			return RestResponse.build().withSuccess("User login successfully", responseModel);
		} catch (Exception e) {
			log.error("Failed to login user due to: {}", e.getMessage(), e);
			return RestResponse.build().withError(e.getMessage());

		}
	}

}
