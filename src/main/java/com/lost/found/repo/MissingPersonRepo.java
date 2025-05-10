package com.lost.found.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lost.found.entity.MissingPerson;

public interface MissingPersonRepo extends JpaRepository<MissingPerson, Integer> {
	@Query("select ms from MissingPerson ms where ms.idProof=:idProof")
	MissingPerson findByIdProof(@Param("idProof") String idProof);
}