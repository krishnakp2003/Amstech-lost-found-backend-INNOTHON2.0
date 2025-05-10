package com.lost.found.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lost.found.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u LEFT JOIN FETCH u.userRoles ur LEFT JOIN FETCH ur.role WHERE u.email = :email")
	 User findByEmail(@Param("email") String email);
	
	 @Query("select e from User e where e.mobileNumber=:mobileNumber")
	  User findByPhoneNumber(@Param("mobileNumber") String mobileNumber);
	 
	 @Query("select e from User e where (e.email = :username or e.mobileNumber = :username) AND e.password = :password ")
     User findByUsername(@Param("username") String username, @Param("password") String password);

}
