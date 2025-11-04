package com.cdac.service;

import java.util.List;

import com.cdac.entities.Restaurant;

public interface RestaurantService {

//	to get all restaurent
	public List<Restaurant> getAllRestaurents(Boolean status);

	public Restaurant addRestaurent(Restaurant newRestaturent);

//	delete the 
	public String deleteById(Long restaurantId);
}
