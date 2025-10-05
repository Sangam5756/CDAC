package com.collections.hashmap;

import java.util.HashMap;
import java.util.Optional;

class Product implements Comparable<Product> {
	int id;
	String name;
	int price;
	boolean isAvailable;

	Product(int id, String name, int price, boolean available) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.isAvailable = available;
	}

	Product(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", isAvailable=" + isAvailable + "]";
	}

	public int compareTo(Product other) {
		return Integer.compare(this.id, other.id);

	}

}

public class HashMapPract {

	public static void main(String args[]) {

		HashMap<Integer, Product> products = new HashMap<>();
		products.put(106, new Product(106, "zaptop", 100, false));
		products.put(201, new Product(201, "mouse", 100, true));
		products.put(72, new Product(72, "keyboard", 700, true));
		products.put(42, new Product(42, "charger", 120, true));
		products.put(245, new Product(245, "fan", 400, false));
		products.put(136, new Product(136, "monitor", 1500, true));
		products.put(723, new Product(723, "speaker", 300, true));
		products.put(204, new Product(204, "projector", 1200, false));
		products.put(81, new Product(81, "webcam", 250, false));
		products.put(96, new Product(96, "microphone", 200, true));
		products.put(10, new Product(10, "tablet", 600, true));
//		sort the product based on price

//		products.values().stream().sorted((o1,o2) -> Integer.compare(o2.getPrice(),o2.getPrice())).forEach(p -> System.out.println(p));;

//		products.values().stream().sorted((o1,o2) -> Integer.compare(o2.getPrice(),o2.getPrice())).forEach(p -> System.out.println(p));
//		will sort based on price and name
//		Comparator<Product> comparePriceAndName =  (o1,o2)->{
//			int priceCompare =Integer.compare(o1.getPrice(), o2.getPrice()); 
//					
//			if(priceCompare  != 0) return priceCompare;
//			return o1.getName().compareTo(o2.getName());
//		};
//		

//		products.values().stream().sorted(comparePriceAndName).forEach(p -> System.out.println(p));

//		products.forEach((k,v) -> System.out.println(k+" "+v));

//		want to remove the product by name so now i will need the equals method overiden
//		because when i check the p1.equals(p2) then it will caall the object class equals and that mehtod check refernce equalsi not content
//		so we have to override that method
//		get the key where the element is there
//		Product k =null;
//		remove by using the name

//		products.entrySet().removeIf( p -> p.getValue().getName().equals("mouse"));

//		remove by using the key.
//		products.remove(2);

//		remove by using price all elements

//		products.entrySet().removeIf(p -> p.getValue().getId())

//		products.entrySet().removeIf(p -> !p.getValue().isAvailable());

//		System.out.println("the after SORTING products");
//		
//		List<Product> list = new ArrayList<>(products.values());
//		Collections.sort(list);
//		list.forEach(p -> System.out.println(p));
//		
//		find the proiduct which has max price

//		Product m = null;
//		products.values().stream().max((o1,o2)-> Integer.compare(o1.getPrice(), o2.getPrice())).ifPresent(p -> System.out.println(p));
//		products.values().stream().min((o1,o2) ->  Integer.compare(o1.getPrice(), o2.getPrice()))
//		.ifPresent(p -> System.out.println(p));
//		;
//		

//		searching in hashmap by using any entitiy

		Optional<Product> result = products.values().stream().filter(p -> p.getName().equals("mouses")).findFirst();
		for(Product p : products.values()) {
			if(p.getName().equals("moduse")) {
				System.out.println(p);
				break;
			}
		}
//		result.ifPresent(p -> System.out.println(p));
//		with error handled
		result.ifPresentOrElse((p) -> System.out.println(p),()-> System.out.println("Error Product not found"));

	}

}
