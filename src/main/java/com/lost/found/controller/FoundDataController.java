package com.lost.found.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lost.found.response.model.FoundDataResponseModel;
import com.lost.found.restresponse.RestResponse;
import com.lost.found.service.FoundDataService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/foundData")
@Slf4j
public class FoundDataController {

	@Autowired
	private FoundDataService dataService;
	
	@Operation(summary = "You can use this method for  Find missing Person", description = "This is desc")
	@RequestMapping(method = RequestMethod.GET, value = "/findByIdProof", produces = "application/json")
	public RestResponse findByIdProof(@RequestParam("idProof") String idProof) {
		try {
			 FoundDataResponseModel foundDataResponseModel = dataService.findByIdProof(idProof);
			return RestResponse.build().withSuccess("Person Found successfully", foundDataResponseModel);
		} catch (Exception e) {
			log.error("Failed to Person Found due to: {}", e.getMessage(), e);
			return RestResponse.build().withError(e.getMessage());

		}
	}
}
