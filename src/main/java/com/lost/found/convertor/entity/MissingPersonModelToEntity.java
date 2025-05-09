package com.lost.found.convertor.entity;

import org.springframework.stereotype.Component;

import com.lost.found.entity.MissingPerson;
import com.lost.found.request.model.MissingPersonRequestModel;

@Component
public class MissingPersonModelToEntity {

	public MissingPerson missingPersonRegister(MissingPersonRequestModel missingPersonRequestModel) {
		MissingPerson missingPerson=new MissingPerson();
		missingPerson.setName(missingPersonRequestModel.getName());
		missingPerson.setGender(missingPersonRequestModel.getGender());
		missingPerson.setAge(missingPersonRequestModel.getAge());
		missingPerson.setIdProof(missingPersonRequestModel.getIdProof());
		missingPerson.setEmail(missingPersonRequestModel.getEmail());
		missingPerson.setMobileNumber(missingPersonRequestModel.getMobileNumber());
		missingPerson.setDescription(missingPersonRequestModel.getDescription());
		return missingPerson;
	}
}
