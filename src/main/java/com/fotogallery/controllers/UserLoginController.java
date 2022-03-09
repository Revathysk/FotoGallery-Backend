package com.fotogallery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.CrossOrigin; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fotogallery.exceptions.ResourceNotFoundException;
import com.fotogallery.models.UserLogin;
import com.fotogallery.repositories.UserLoginRepository;
 
@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class UserLoginController {

	@Autowired
	private UserLoginRepository userloginRepo;
	@GetMapping("allusers")
	public List<UserLogin> getAllusers(){
		return userloginRepo.findAll();
	}
	
	//  Read/Find by user name	
	@GetMapping("user/{username}")
	public List<UserLogin> getUserByUserName(@PathVariable String username){
	List<UserLogin> finduser = userloginRepo.findByUsername(username);
	if(finduser.isEmpty()) {
		System.out.println(new ResourceNotFoundException("User" + username +" not found. Register as new user and save your favorites"));
	}
	 return userloginRepo.findByUsername(username);
	}

	// Add new user	
	@PostMapping("adduser")
	public UserLogin addnewUser(@RequestBody UserLogin newuser){
		return 	userloginRepo.save(newuser); 
	}	
	
	// Find by match for username and password combination
//	@GetMapping("finduser/{username}/{password}")
//	public List<UserLogin> getUserByUserName(@PathVariable String username, @PathVariable String password){
//	UserLogin finduser = userloginRepo.findByUsernamePassword(username, password);
//	if(finduser.getUsername() == username) {
//		System.out.println(new ResourceNotFoundException("User" + username +" not found. Register as new user and save your favorites"));
//	}
//	 return userloginRepo.findByUsername(username);
//	}

	
	
}

