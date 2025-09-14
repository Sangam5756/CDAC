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

public class Test2 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			ProductService productService = new ProductServiceImpl();
			CustomerService customerService = new CustomerServiceImpl();
			OrderService orderService = new OrderServiceImpl(productService, customerService);

			Customer loginUser = null; // currently logged-in user

			int choice;
			do {
				if (loginUser == null) {
					// Public menu
					System.out.println("\n========= MAIN MENU =========");
					System.out.println("1. Add Product");
					System.out.println("2. Display All Products");
					System.out.println("3. Display Products with Stock");
					System.out.println("4. Register Customer");
					System.out.println("5. Login Customer");
					System.out.println("0. Exit");
					System.out.println("=============================");
					System.out.print("Enter choice: ");
					choice = sc.nextInt();
					sc.nextLine(); // consume newline

					try {
						switch (choice) {
						case 1: {
							System.out.print("Enter Product Name: ");
							String name = sc.nextLine();
							System.out.print("Enter Category (ELECTRONICS, CLOTHING, GROCERY, BOOKS): ");
							String category = sc.nextLine().toUpperCase();
							System.out.print("Enter Price: ");
							double price = sc.nextDouble();
							System.out.print("Enter Stock: ");
							int stock = sc.nextInt();
							sc.nextLine();
							System.out.println(productService.addProduct(name, category, price, stock));
							break;
						}
						case 2:
							productService.DisplayProduct();
							break;
						case 3:
							productService.DisplayProductWithStockStatus();
							break;
						case 4: {
							System.out.print("Enter Name: ");
							String name = sc.nextLine();
							System.out.print("Enter Email: ");
							String email = sc.nextLine();
							System.out.print("Enter Password: ");
							String password = sc.nextLine();
							System.out.println(customerService.registerCustomer(name, email, password));
							break;
						}
						case 5: {
							System.out.print("Enter Email: ");
							String email = sc.nextLine();
							System.out.print("Enter Password: ");
							String password = sc.nextLine();
							loginUser = customerService.loginCustomer(email, password);
							if (loginUser != null) {
								System.out.println(" Login Successful! Welcome, " + loginUser.getName());
							} else {
								System.out.println("Invalid credentials.");
							}
							break;
						}
						case 0:
							System.out.println("Exiting... Goodbye!");
							break;
						default:
							System.out.println("Invalid choice.");
						}
					} catch (Exception e) {
						System.out.println("Error: " + e.getMessage());
					}

				} else {
					// Logged-in menu
					System.out.println("\n========= CUSTOMER MENU =========");
					System.out.println("1. View My Profile");
					System.out.println("2. View All Products");
					System.out.println("3. Place Order");
					System.out.println("4. View My Orders");
					System.out.println("5. Cancel Order");
					System.out.println("6. Logout");
					System.out.println("===============================");
					System.out.print("Enter choice: ");
					choice = sc.nextInt();
					sc.nextLine();

					try {
						switch (choice) {
						case 1:
							System.out.println("Profile: " + loginUser);
							break;
						case 2:
							productService.DisplayProductWithStockStatus();
							break;
						case 3: {
							System.out.print("Enter Product ID: ");
							int productId = sc.nextInt();
							System.out.print("Enter Quantity: ");
							int qty = sc.nextInt();
							sc.nextLine();
							orderService.placeOrder(loginUser, productId, qty);
							break;
						}
						case 4:
							for (Order order : customerService.DisplayAllOrdersOfCustomer(loginUser)) {
								System.out.println(order);
							}
							break;
						case 5: {
							System.out.print("Enter Order ID to cancel: ");
							int orderId = sc.nextInt();
							sc.nextLine();
							orderService.cancelOrder(loginUser, orderId);
							break;
						}
						case 6:
							System.out.println("Logged out successfully!");
							loginUser = null;
							break;
						default:
							System.out.println("Invalid choice.");
						}
					} catch (Exception e) {
						System.out.println("Error: " + e.getMessage());
					}
				}

			} while (choice != 0);
		} catch (Exception e) {
			System.out.println(e);
			
			
		}
	}
}
