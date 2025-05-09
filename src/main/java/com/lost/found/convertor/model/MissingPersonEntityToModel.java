package com.lost.found.convertor.model;

import org.springframework.stereotype.Component;

import com.lost.found.entity.MissingPerson;
import com.lost.found.response.model.MissingPersonResponseModel;

@Component
public class MissingPersonEntityToModel {
	public MissingPersonResponseModel getfindbyId(MissingPerson  missingPerson) {
		MissingPersonResponseModel responseModel = new MissingPersonResponseModel();
		responseModel.setId(missingPerson.getId());
		responseModel.setName(missingPerson.getName());
		responseModel.setAge(missingPerson.getAge());
		responseModel.setEmail(missingPerson.getEmail());
		responseModel.setGender(missingPerson.getGender());
		responseModel.setIdProof(missingPerson.getIdProof());
		responseModel.setMobileNumber(missingPerson.getMobileNumber());
		responseModel.setDescription(missingPerson.getDescription());
		return responseModel;

	}
}
