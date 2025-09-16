package com.hashset.core;

/*
 * 
2. Override the `hashCode()` method in the `Product` class consistent with the `equals()` 
method you wrote in 
Task 1. Verify the `HashSet` behavior by adding multiple products.**


# 3. **Modify the `equals()` method to include the `name` field as part of equality check, 
and override `hashCode()` accordingly. Add products with same `id`
 and `category` but different `name` and observe the effect on `HashSet`.**
*/


public class ProductPrac1 {
	private int id;
	private String name;
	private Category category;
	private int stock;
	private double price;

	public ProductPrac1(int id, String name, Category category, int stock, double price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.stock = stock;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", stock=" + stock + ", price="
				+ price + "]";
	}
//
////	same id same category
////	different name
//	@Override
//	public boolean equals(Object obj) {
//		if (obj instanceof ProductPrac1) {
//			ProductPrac1 pd = (ProductPrac1) obj;
//			return (id == pd.id) && (this.category.equals(pd.category)) && !(this.name.equals(pd.name));
//		}
//
//		return false;
//
//	}
	

	//4. **Intentionally break the `hashCode()` contract by returning a constant value in `hashCode()`. 
	//Add several products to a `HashSet` and observe what happens.**
	
	

	@Override
	public int hashCode() {
//		return (id * 29) + category.hashCode();
		return 100;
	}

}
