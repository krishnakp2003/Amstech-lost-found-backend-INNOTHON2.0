package com.lost.found.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lost.found.convertor.entity.MissingPersonModelToEntity;
import com.lost.found.convertor.model.MissingPersonEntityToModel;
import com.lost.found.entity.MissingPerson;
import com.lost.found.repo.MissingPersonRepo;
import com.lost.found.request.model.MissingPersonRequestModel;
import com.lost.found.response.model.MissingPersonResponseModel;

@Service
public class MissingPersonService {

	@Autowired
	private MissingPersonRepo missingPersonRepo;
	@Autowired
	private MissingPersonModelToEntity missingPersonModelToEntity;
	@Autowired
	private MissingPersonEntityToModel missingPersonEntityToModel;
	
	
	public MissingPersonResponseModel missingPersonRegister(MissingPersonRequestModel missingPersonRequestModel) {
		MissingPerson missingPersonRegister = missingPersonModelToEntity.missingPersonRegister(missingPersonRequestModel);
		MissingPerson save = missingPersonRepo.save(missingPersonRegister);
		return missingPersonEntityToModel.getfindbyId(save);

	}
	
	public MissingPersonResponseModel findByIdProof(String idProof) throws Exception {
		return missingPersonEntityToModel.getfindbyIdProof(idProof);
		
	}
	public MissingPersonResponseModel findById(Integer id ) throws Exception {
	Optional<MissingPerson> optional = missingPersonRepo.findById(id);
	if(!optional.isPresent()) {
		throw new Exception("Missing person not found");		
	}
	
		return missingPersonEntityToModel.getfindbyId(optional.get());
		
	}
}
