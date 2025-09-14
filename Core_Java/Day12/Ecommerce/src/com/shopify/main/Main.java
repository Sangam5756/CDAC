
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

public class Main {

	public static boolean isLoggedIn(Customer user) {
		return user != null;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int ch;
			Customer loginUser = null;

			ProductService productService = new ProductServiceImpl();
			CustomerService customerService = new CustomerServiceImpl();
			OrderService orderService = new OrderServiceImpl(productService, customerService);

			do {
				System.out.println("\n========= MENU =========");
				System.out.println("1. Add Product");
				System.out.println("2. Display Products");
				System.out.println("3. Display Products With Stock");
				System.out.println("4. Register Customer");
				System.out.println("5. Display All Customers");
				System.out.println("6. Login Customer");
				System.out.println("7. Show Current Logged-in User");
				System.out.println("8. Place Order");
				System.out.println("9. View My Orders");
				System.out.println("10. Cancel Order");
				System.out.println("0. Exit");
				System.out.println("========================");
				System.out.print("Enter choice: ");
				ch = sc.nextInt();
				sc.nextLine();

				try {
					switch (ch) {
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
					case 2: {
						productService.DisplayProduct();
						break;
					}
					case 3: {
						productService.DisplayProductWithStockStatus();
						break;
					}
					case 4: {
						System.out.print("Enter Customer Name: ");
						String name = sc.nextLine();
						System.out.print("Enter Email: ");
						String email = sc.nextLine();
						System.out.print("Enter Password: ");
						String password = sc.nextLine();

						System.out.println(customerService.registerCustomer(name, email, password));
						break;
					}
					case 5: {
						customerService.displayAllCustomer();
						break;
					}
					case 6: {
						System.out.print("Enter Email: ");
						String email = sc.nextLine();
						System.out.print("Enter Password: ");
						String password = sc.nextLine();

						loginUser = customerService.loginCustomer(email, password);
						if (loginUser != null) {
							System.out.println("User Logged In Successfully!");
						} else {
							System.out.println("Invalid Credentials!");
						}
						break;
					}
					case 7: {
						if (loginUser != null) {
							System.out.println("Current User: " + loginUser);
						} else {
							System.out.println("No user logged in.");
						}
						break;
					}
					case 8: {
						if (isLoggedIn(loginUser)) {
							System.out.print("Enter Product ID: ");
							int productId = sc.nextInt();
							System.out.print("Enter Quantity: ");
							int qty = sc.nextInt();
							sc.nextLine();

							orderService.placeOrder(loginUser, productId, qty);
						} else {
							System.out.println("Please login to place an order.");
						}
						break;
					}
					case 9: {
						if (loginUser != null) {
							for (Order order : customerService.DisplayAllOrdersOfCustomer(loginUser)) {
								System.out.println(order);
							}
						} else {
							System.out.println("Please login first.");
						}
						break;
					}
					case 10: {
						if (loginUser != null) {
							System.out.print("Enter Order ID to cancel: ");
							int orderId = sc.nextInt();
							sc.nextLine();

							orderService.cancelOrder(loginUser, orderId);
						} else {
							System.out.println("Please login first.");
						}
						break;
					}
					case 0:
						System.out.println("Exiting... Goodbye!");
						break;
					default:
						System.out.println("Invalid choice. Try again.");
					}
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
				}

			} while (ch != 0);
		}
	}
}


