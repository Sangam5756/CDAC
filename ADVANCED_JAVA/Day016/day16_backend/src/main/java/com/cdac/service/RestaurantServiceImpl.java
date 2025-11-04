package com.cdac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.custom_exception.ResourceAlreadyExists;
import com.cdac.custom_exception.ResourceNotFound;
import com.cdac.entities.Restaurant;
import com.cdac.repository.RestaurantsRepository;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantsRepository restaurant;

	@Override
	public List<Restaurant> getAllRestaurents(Boolean status) {

		return restaurant.findByStatus(status);
	}

	@Override
	public Restaurant addRestaurent(Restaurant newRestaturent) {

		if (restaurant.existsByName(newRestaturent.getName())) {
			throw new ResourceAlreadyExists("duplicate Restaturent Found");
		}
//		new restaturant then set status to true
		newRestaturent.setStatus(true);

		Restaurant savedRestaturant = restaurant.save(newRestaturent);
//		return "added new Restaturent with Id" + savedRestaturant.getId();
		return savedRestaturant;
	}

	@Override
	public String deleteById(Long restaurantId) {

//		check restaurant is valid
		Optional<Restaurant> isExistrestaurant = restaurant.findById(restaurantId);

		isExistrestaurant.orElseThrow(() -> new ResourceNotFound("Invalid restaurantId"));
		isExistrestaurant.ifPresent(p -> p.setStatus(false));

		return "Restaturant Deleted Successfully";
	}

}
