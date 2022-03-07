package com.fotogallery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fotogallery.models.UserLogin;

@Repository
public interface UserLoginRepository extends JpaRepository <UserLogin, Integer>{
	
	List<UserLogin> findByUsername(String username);
	
//	@Query ("FROM userlogin WHERE username=?1 AND password=?2")
//	UserLogin findByUsernamePassword(String firstname,String lastname);

}
