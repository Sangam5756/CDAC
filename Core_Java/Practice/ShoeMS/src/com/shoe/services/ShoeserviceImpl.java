package com.shoe.services;

import static com.shoe.validation.shoevalidation.ValidateshoeType;
import static com.shoe.validation.shoevalidation.validateName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.shoe.core.Shoe;
import com.shoe.core.ShoeType;
import com.shoe.exception.ShoeException;

public class ShoeserviceImpl implements ShoeService {

//	hashmap to store the details 
	HashMap<Integer, Shoe> shoes;

	public ShoeserviceImpl(int capacity) {
		this.shoes = new HashMap<>(capacity); // as i want the shoe to be as per capacity so larger data no need to
		shoes.put(201, new Shoe(201, 4, "Trailblazer", "North Peak", 110.50, true, ShoeType.CASUAL));
		shoes.put(207, new Shoe(207, 5, "Trailblazer", "North Peak", 200, true, ShoeType.SPORTS));
		shoes.put(200, new Shoe(205, 5, "Trailblazer", "North Peak", 30000, true, ShoeType.SPORTS));
		shoes.put(100, new Shoe(205, 5, "Trailblazer", "North Peak", 5300, false, ShoeType.SPORTS));
	}

	@Override
	public void addShoes(int shoeId, int ratings, String name, String brand, double price, boolean available,
			ShoeType shoetype) throws ShoeException {
//		first check the name is valid
		validateName(name);
//		check that the type is valid
		ValidateshoeType(brand);

//		then add the shoe in to the map as constant time performance

//  so here key will keep the shoeId as its unique
//		put will put there but if somethings there so it will replace also need that its duplicate shoe or not will do that later

		shoes.put(shoeId, new Shoe(shoeId, ratings, name, brand, price, available, shoetype));

	}  
	

	@Override
	public void displayAllShoes() {
//		in order to display all the shoes we need that for Each loop
		shoes.forEach((k, v) -> System.out.println(k + " " + v));
	}

	@Override
	public void displayAllShoeSortByid() {
		
//			convert map to list
		List<Shoe> list = new ArrayList<>(shoes.values());
//		call collections sort function, implements comparable and override the comparator as per our requirement
		Collections.sort(list);
		list.forEach((shoe) -> System.out.println(shoe));
	}

	@Override
	public void searchShoeById(int id) throws ShoeException {

//		searching in hashmap is constant time as it
//		provide the get api
		Shoe shoe = shoes.get(id);
		if (shoe == null)
			throw new ShoeException("Shoe  Not found");
		System.out.println(shoe);
	}

	@Override
	public void removeNotAvailableShoe() throws ShoeException {
//		search for which are status is available status false
//		
//		shoes.forEach((k,v)->{
//			if(!v.isAvailable()) {
////				it will throw concurrent Modification error
//				shoes.remove(k);
//			}
//		});		
//		we have removeif
		shoes.entrySet().removeIf(entry -> !entry.getValue().isAvailable());

	}

	@Override
	public void updateShoePrice(int id, double price) throws ShoeException {

		Shoe s = shoes.get(id);
		if (s == null) {
			throw new ShoeException("product not found");

		}
		System.out.println(s);

	}

	@Override
	public void sortShoeDescByPrice() {

		List<Shoe> s = shoes.values().stream().sorted((o1, o2) -> ((Double) o2.getPrice()).compareTo(o1.getPrice()))
				.collect(Collectors.toList());

		s.forEach((t) -> System.out.println(t));
	}

}
