package com.lost.found.convertor.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lost.found.entity.MissingPerson;
import com.lost.found.repo.MissingPersonRepo;
import com.lost.found.response.model.MissingPersonResponseModel;

@Component
public class MissingPersonEntityToModel {
	@Autowired 
	private MissingPersonRepo missingPersonRepo;
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
	
	public MissingPersonResponseModel getfindbyIdProof(String  idProof) throws Exception {
		MissingPerson missingPerson = missingPersonRepo.findByIdProof(idProof);
		if(missingPerson==null) {
			throw new Exception("Person not found this Identity");
		}
		
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
