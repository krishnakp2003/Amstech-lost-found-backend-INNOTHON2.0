package com.lost.found.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lost.found.entity.MissingPerson;

public interface MissingPersonRepo extends JpaRepository<MissingPerson, Integer>{

}
