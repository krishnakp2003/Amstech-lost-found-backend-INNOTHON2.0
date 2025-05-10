package com.lost.found.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lost.found.request.model.MissingPersonRequestModel;
import com.lost.found.request.model.UserRequestModel;
import com.lost.found.response.model.MissingPersonResponseModel;
import com.lost.found.response.model.UserResponseModel;
import com.lost.found.restresponse.RestResponse;
import com.lost.found.service.MissingPersonService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/missingPerson")
@Slf4j
public class MisssingPersonController {

	@Autowired
	private MissingPersonService missingPersonService;
	public MisssingPersonController() {
		System.out.println("MisssingPersonController:Object Created");
	}
	
	@Operation(summary = "You can use this method for user/student signup", description = "This is desc")
	@RequestMapping(method = RequestMethod.POST, value = "/missingPersonRegister", consumes = "application/json", produces = "application/json")
	public RestResponse missingPersonRegister(@RequestBody MissingPersonRequestModel requestModel) {

		
		try {
			MissingPersonResponseModel missingPersonRegister = missingPersonService.missingPersonRegister(requestModel);
			return RestResponse.build().withSuccess("User created successfully", missingPersonRegister);
		} catch (Exception e) {
			log.error("Failed to save user due to: {}", e.getMessage(), e);
			return RestResponse.build().withError(e.getMessage());

		}
	}

}
