package com.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class WishList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int wishListId;
	@ManyToOne
	private User user;
	@ManyToOne
	private Footwear footwear;
	
	public WishList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WishList(int wishListId, User userId, Footwear footwearId) {
		super();
		this.wishListId = wishListId;
		this.user = userId;
		this.footwear = footwearId;
	}

	public int getWishListId() {
		return wishListId;
	}

	public void setWishListId(int wishListId) {
		this.wishListId = wishListId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User userId) {
		this.user = userId;
	}

	public Footwear getFootwear() {
		return footwear;
	}

	public void setFootwear(Footwear footwearId) {
		this.footwear = footwearId;
	}
	
	
	
}
