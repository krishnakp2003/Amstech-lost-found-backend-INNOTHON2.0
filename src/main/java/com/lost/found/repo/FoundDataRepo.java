package com.lost.found.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lost.found.entity.FoundData;

public interface FoundDataRepo extends JpaRepository<FoundData, Integer>{

}
