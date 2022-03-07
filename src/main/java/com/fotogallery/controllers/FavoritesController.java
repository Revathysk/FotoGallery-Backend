package com.fotogallery.controllers;

//Framework Libs
import java.util.List;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Model, Repository and Exception

import com.fotogallery.exceptions.ResourceNotFoundException;
import com.fotogallery.models.Favorites;
import com.fotogallery.repositories.FavoritesRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class FavoritesController {

	@Autowired
	private FavoritesRepository favoritesRepo;
	@GetMapping("mostlikedfotos")
	public List<Favorites> getAllfavorites(){
		return favoritesRepo.findAll();
	}
	
	//  Find favorites by username	
	
	@GetMapping("user/favorites/{username}")
	public List <Favorites> getFavoritesByUserName(@PathVariable String username){
	List<Favorites> favlist = favoritesRepo.findByUsername(username);
	if(favlist.isEmpty()) {
		System.out.println(new ResourceNotFoundException("User" + username +" have not saved any fotos to favorites"));
	}
	 return favoritesRepo.findByUsername(username);
	}
	 
	// Adding favorites to user page
	 
	@PostMapping("user/favorites/add")
	public Favorites addnewfavorite (@RequestBody Favorites newfav){
		return 	favoritesRepo.save(newfav); 
	}	
	
	//Delete favorites for an user
	@DeleteMapping("user/favorites/delete/{id}")
	public ResponseEntity<String> deleteUserfavorite(@PathVariable int id ) {
		favoritesRepo.findById(id)
		.orElseThrow(()-> new ResourceNotFoundException("Foto not found."));
		favoritesRepo.deleteById(id);
		return new ResponseEntity<> ("Foto removed from your favorites list.",HttpStatus.OK);				
	}
	
	//update rating for a favorite foto of user
	@PutMapping("user/favorites/edit/{id}")
	public ResponseEntity<Favorites> updateStudent(@PathVariable int id, @RequestBody Favorites editfototag){
		Favorites foundFoto= favoritesRepo.findById(id)
			.orElseThrow(()-> new ResourceNotFoundException("Foto not found."));
		foundFoto.setFototag(editfototag.getFototag());		
		Favorites updatedFavorites = favoritesRepo.save(foundFoto);
		return ResponseEntity.ok(updatedFavorites);		
	}	
	
}

