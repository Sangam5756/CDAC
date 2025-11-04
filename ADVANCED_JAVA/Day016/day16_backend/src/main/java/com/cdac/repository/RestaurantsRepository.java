package com.cdac.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cdac.entities.Restaurant;

@Repository // this annotation required to for the springboot to understand it as the repo
public interface RestaurantsRepository extends CrudRepository<Restaurant, Long> {

	List<Restaurant> findByStatus(Boolean status);

//	to add the object we need to store then direct object
	boolean existsByName(String restaurantName);

}
