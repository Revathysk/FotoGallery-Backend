package com.fotogallery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.fotogallery.models.Favorites;

@Repository
public interface FavoritesRepository extends JpaRepository <Favorites, Integer>{
	
	List<Favorites> findByUsername(String username);
}
