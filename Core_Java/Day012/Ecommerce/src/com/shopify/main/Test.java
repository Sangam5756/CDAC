package com.shopify.main;

import java.util.Scanner;

import com.shopify.core.Customer;
import com.shopify.core.Order;
import com.shopify.services.CustomerService;
import com.shopify.services.CustomerServiceImpl;
import com.shopify.services.OrderService;
import com.shopify.services.OrderServiceImpl;
import com.shopify.services.ProductService;
import com.shopify.services.ProductServiceImpl;

public class Test {

	public static boolean isLoggedIn(Customer user) {
		if (user != null) {
			return true;
		}
		return false;
	}

	public static void main(String args[]) {

		try (Scanner sc = new Scanner(System.in)) {
			int ch;
			Customer loginUser = null;
//			here will create product service
			ProductService productService = new ProductServiceImpl();
			CustomerService customerService = new CustomerServiceImpl();
			OrderService orderService = new OrderServiceImpl(productService, customerService);

			do {

				System.out.println("1.Add Product" + "\n2.Display Products" + "\n3.Show All Products "
						+ "\n4.Register Customer" + "\n5.Display All Customer" + "\n6. Login Customer"
						+ "\n7.SeeLoggedinUser" + "\n8.Order Product");
				System.out.println("Enter the choice ");
				ch = sc.nextInt();

				try {
					switch (ch) {
					case 1: {
						System.out.println("\n-----------------ADD PRODUCTS-----------------\n");
						System.out.println(productService.addProduct("Mapple iPhone 15", "ELECTRONICS", 79999.99, 10));
						System.out.println(productService.addProduct("ZARA T-shirt", "CLOTHING", 5999.50, 25));
						System.out.println("\n-----------------_____________________-----------------\n");
						break;
					}
					case 2: {

						System.out.println("\n-----------------ALL PRODUCTS-----------------\n");
						productService.DisplayProduct();
						System.out.println("\n-----------------_____________________-----------------\n");
						break;
					}
					case 3: {
						System.out.println("\n-----------------PRODUCTS WITH STOCK STATUS-----------------\n");
						productService.DisplayProductWithStockStatus();
						System.out.println("\n-----------------_____________________-----------------\n");
						break;
					}
					case 4: {
						System.out.println("\n-----------------REGISTER CUSTOMER-----------------\n");

						System.out.println(customerService.registerCustomer("Sangam", "sangam@gmail.com", "123"));
						System.out.println("\n-----------------_____________________-----------------\n");
						break;
					}

					case 5: {
						System.out.println("\n-----------------DisplayAllCustomer-----------------\n");
						customerService.displayAllCustomer();
						System.out.println("\n-----------------_____________________-----------------\n");
						break;
					}
					case 6: {
						System.out.println("\n-----------------LoginCustomer-----------------\n");
						loginUser = customerService.loginCustomer("sangam@gmail.com", "123");
						if (loginUser != null) {
							System.out.println("User LoggedIn SuccessFully");
						}
						System.out.println("\n-----------------_____________________-----------------\n");
						break;
					}
					case 7: {
						System.out.println("\n-----------------CurrentLoggedin User-----------------\n");
						if (loginUser != null) {
							System.out.println(loginUser);
						} else {
							System.out.println("Please Login then Try again ");
						}
						System.out.println("\n-----------------_____________________-----------------\n");
						break;
					}
					case 8: {
						System.out.println("\n----------------- User-----------------\n");
						if (isLoggedIn(loginUser)) {

							orderService.placeOrder(loginUser, 1, 1);

						} else {
							System.out.println("Please login to place order");
						}
						System.out.println("\n-----------------_____________________-----------------\n");
						break;
					}
					case 9: {
						System.out.println("\n-----------------Loggedin User Orders-----------------\n");
						if (loginUser != null) {

							for (Order order : customerService.DisplayAllOrdersOfCustomer(loginUser)) {
								System.out.println(order);
							}
						} else {
							System.out.println("Please Login then Try again ");
						}
						System.out.println("\n-----------------_____________________-----------------\n");
						break;

					}
					case 10: {
						System.out.println("\n-----------------Cancel Order-----------------\n");
						if (loginUser != null) {
							orderService.cancelOrder(loginUser, 101);
						} else {
							System.out.println("Please Login then Try again ");
						}
						System.out.println("\n-----------------_____________________-----------------\n");
						break;

					}

					default:
						System.out.println("invalid choice");
						break;
					}
				} catch (Exception e) {
					System.out.println(e);
				}

			} while (ch != 0);

		}

	}

}
