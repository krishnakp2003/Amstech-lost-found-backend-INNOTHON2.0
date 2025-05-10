package com.lost.found.convertor.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lost.found.entity.FoundData;
import com.lost.found.repo.FoundDataRepo;
import com.lost.found.response.model.FoundDataResponseModel;

@Component
public class FoundDataEntityToModel {

	@Autowired
	private FoundDataRepo foundDataRepo;
	
		public FoundDataResponseModel getfindbyIdProof(String  idProof) throws Exception  {
			FoundData foundData = foundDataRepo.findByIdProof(idProof);
			if(foundData==null) {
				throw new Exception("Person not found this Identity");
			}
			
			FoundDataResponseModel responseModel = new FoundDataResponseModel();
			responseModel.setId(foundData.getId());
			responseModel.setMissingPersonId(foundData.getMissingPerson().getId());
			responseModel.setName(foundData.getMissingPerson().getName());
			responseModel.setAge(foundData.getMissingPerson().getAge());
			responseModel.setEmail(foundData.getMissingPerson().getEmail());
			responseModel.setGender(foundData.getMissingPerson().getGender());
			responseModel.setIdProof(foundData.getMissingPerson().getIdProof());
			responseModel.setMobileNumber(foundData.getMissingPerson().getMobileNumber());
			responseModel.setDescription(foundData.getMissingPerson().getDescription());
			responseModel.setLocation(foundData.getLocation());
			responseModel.setTime(foundData.getTime());
			return responseModel;

		}
	}

