package com.lost.found.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lost.found.entity.UserRole;

public interface UserRoleRepo extends JpaRepository<UserRole, Integer> {

}
