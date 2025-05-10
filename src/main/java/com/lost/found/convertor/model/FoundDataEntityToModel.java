package com.lost.found.convertor.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lost.found.entity.FoundData;
import com.lost.found.repo.FoundDataRepo;
import com.lost.found.response.model.FoundDataResponseModel;

@Component
public class FoundDataEntityToModel {

	@Autowired
	private FoundDataRepo foundDataRepo;
	
		public List<FoundDataResponseModel> getfindbyIdProof(String  idProof) throws Exception  {
			List<FoundData> foundDatas = foundDataRepo.findByIdProof(idProof);
			if(foundDatas==null) {
				throw new Exception("Person not found this Identity");
			}
			List<FoundDataResponseModel> dataResponseModels=new ArrayList<>();
			for (FoundData foundData : foundDatas) {
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
			dataResponseModels.add(responseModel);
			}
			return dataResponseModels;
		}
	}

