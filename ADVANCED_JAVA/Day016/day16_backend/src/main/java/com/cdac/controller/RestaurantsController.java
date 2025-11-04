package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entities.Restaurant;
import com.cdac.service.RestaurantService;

@RestController // addition of @Controller + @ResponseBody
@RequestMapping("/restaurants")

public class RestaurantsController {

	@Autowired
	RestaurantService restaurantService;

	@GetMapping
	public ResponseEntity<?> getAllRestaurents() {

		List<Restaurant> list = restaurantService.getAllRestaurents();
		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		return ResponseEntity.ok(list);
//		sc 200, body - list 
	}

//	adding new restaturent 
//	i/p  Json representation of restaurent
// URL -> http://localhost:8080/restaurants method=post
	@PostMapping
	public ResponseEntity<?> saveRestarant(@RequestBody Restaurant newRestauant) {

//		first check the object if its null or not
//		also check that any restaturent with same name already exists

		try {

			String msg = restaurantService.addRestaurent(newRestauant);
 
			return ResponseEntity.status(HttpStatus.CREATED).body(msg);

		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

}
