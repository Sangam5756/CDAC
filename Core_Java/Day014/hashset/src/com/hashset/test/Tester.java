package com.hashset.test;

import java.util.HashSet;

import com.hashset.core.Category;
import com.hashset.core.Product;

public class Tester {

	public static void main(String[] args) {
		Product product1 = new Product(101, "Bread", Category.FOOD, 100, 50);
		Product product2 = new Product(10, "Biscuits", Category.FOOD, 100, 50);
		Product product3 = new Product(101, "Bread", Category.FOOD, 100, 50);
		Product product4 = new Product(10, "Sunflower Oil", Category.OIL, 100, 50);
		Product product5 = new Product(101, "Rice", Category.GRAINS, 100, 50);
		
		// add these products to the HashSet .
		// Expected o/p - products - 1,2,4,5 should get added & 3rd product should not
		// get
		// added.
		HashSet<Product> products=new HashSet<>();
		System.out.println(products.add(product1));
		System.out.println(products.add(product2));
		System.out.println(products.add(product3));
		System.out.println(products.add(product4));
		System.out.println(products.add(product5));
		System.out.println(products.size());

		/*
		Buckets Array (size = 16)
+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+
|  0 |  1 |  2 |  3 | .. | 5  | .. | 9  | .. | .. | .. | .. | .. | .. | .. | .. |
+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+

Let's say:

- product1 hashes to bucket 1
- product2 hashes to bucket 5
- product4 hashes to bucket 9
- product5 hashes to bucket 1 (same as product1, but different by equals)

Then:

Bucket 1:
+-------------------------+
| Node A                  |
| hash: h(product1)       |
| element: product1       |
| next: Node B            | ---> Node B
+-------------------------+     +-------------------------+
                                | hash: h(product5)       |
                                | element: product5       |
                                | next: null              |
                                +-------------------------+

Bucket 5:
+-------------------------+
| Node C                  |
| hash: h(product2)       |
| element: product2       |
| next: null              |
+-------------------------+

Bucket 9:
+-------------------------+
| Node D                  |
| hash: h(product4)       |
| element: product4       |
| next: null              |
+-------------------------+

		 */

	}

}
