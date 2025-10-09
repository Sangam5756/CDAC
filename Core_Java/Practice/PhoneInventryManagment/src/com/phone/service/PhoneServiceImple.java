package com.phone.service;

import static com.phone.core.Validation.ValidatePhoneData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.phone.core.Phone;
import com.phone.exception.PhoneException;

public class PhoneServiceImple implements PhoneService {

	HashMap<Integer, Phone> phones = new HashMap<>();

	@Override
	public void addMobile(String modelName, String brand, int rating, boolean inStock,
			String phoneType, double price) throws Exception, PhoneException {

		Phone newPhone = ValidatePhoneData(modelName, brand, rating, inStock, phoneType, price);

		phones.put(newPhone.getPhone_id(), newPhone);

	}


	@Override
	public void displayAllMobile() throws Exception, PhoneException {
		phones.forEach((k, v) -> System.out.println(k + "  " + v));

	}

	@Override
	public void displayAllMobileSortedById() throws Exception, PhoneException {

//		using natural ordering
		List<Phone> phoneList = new ArrayList<>(phones.values());
		Collections.sort(phoneList);
		System.out.println("Sorted DATA BY Phone ID");
		phoneList.forEach(phone -> System.out.println(phone));

	}

	@Override
	public void searchLeastExpensive() throws PhoneException, Exception {
		
			phones.values().stream().min((o1,o2) -> Double.compare(o1.getPrice(), o2.getPrice())).ifPresent(p -> System.out.println(p));
			
		
		
	}

	@Override
	public void removeAllOutofStockPhone() throws Exception, PhoneException {
		
		phones.entrySet().removeIf((p) -> !p.getValue().isInStock());

	}

	@Override
	public void updateMobilePriceByModelName(String modelName, Double price) throws Exception, PhoneException {
		
//		phones.entrySet()
//		.stream()
//		.filter( p -> p.getValue().getModelName().equals(modelName))
//		.forEach(p-> p.getValue().setPrice(price));

			Optional<Phone> phone = phones.values().stream()
					.filter(p -> p.getModelName().equals(modelName))
					.findFirst();
			phone.ifPresentOrElse((p) -> System.out.println(p),()-> System.out.println("No Phone Found With that Model"));
	}

	@Override
	public void displayAllMobileSortByPriceAscending() throws Exception, PhoneException {
		
		phones.values()
		.stream()
		.sorted((o1,o2)-> Double.compare(o1.getPrice(), o2.getPrice()));

	}

}
