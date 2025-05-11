package com.lost.found.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lost.found.entity.FoundData;

public interface FoundDataRepo extends JpaRepository<FoundData, Integer>{
@Query("select fd from FoundData fd where fd.missingPerson.idProof=:idProof")
List<FoundData> findByIdProof(@Param("idProof") String idProof);
}
