package com.cdac.service;

import java.util.List;

import com.cdac.entities.Restaurant;

public interface RestaurantService {

//	to get all restaurent
	public List<Restaurant> getAllRestaurents();

	public String addRestaurent(Restaurant newRestaturent);
//	delete the 
}
