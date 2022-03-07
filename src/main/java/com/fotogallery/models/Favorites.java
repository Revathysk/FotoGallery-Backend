package com.fotogallery.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//If you see @Bean instead of @Entity

@Entity
@Table(name="favorites")
public class Favorites {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String username;
	@Column
	private String fotourl;
	@Column
	private String fototag;
	@Column
	private String sharedby;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFotourl() {
		return fotourl;
	}
	public void setFotourl(String fotourl) {
		this.fotourl = fotourl;
	}
	public String getFototag() {
		return fototag;
	}
	public void setFototag(String fototag) {
		this.fototag = fototag;
	}
	public String getSharedby() {
		return sharedby;
	}
	public void setSharedby(String sharedby) {
		this.sharedby = sharedby;
	}
	
	 
	 	
}	
