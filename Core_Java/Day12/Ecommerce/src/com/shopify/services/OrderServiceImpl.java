package com.shopify.services;

import java.util.List;

import com.shopify.core.Customer;
import com.shopify.core.Order;
import com.shopify.core.OrderItem;
import com.shopify.core.Product;
import com.shopify.exceptions.ECommerceException;
import com.shopify.exceptions.OutOfStockException;
import com.shopify.exceptions.ResourceNotFoundException;

public class OrderServiceImpl implements OrderService {

	private ProductService productService;
	private CustomerService customerService;

	public OrderServiceImpl(ProductService productService, CustomerService customerService) {
		this.productService = productService;
		this.customerService = customerService;
	}

	@Override
	public void placeOrder(Customer customer, int productId, int quantity) throws ECommerceException {
		/*
		 * first need to find the product to find the product search by product id
		 */

		Product prd = productService.findProductById(productId);

		/*
		 * then that product using will create the order create the object of items as
		 * it will encapsulate the product and quanatity check that stock is available
		 * or not
		 */
		int Stock = prd.getProductStock();
		if (Stock == 0) {
			throw new OutOfStockException("Currently out of Stock");

		} else {
			prd.setProductStock(Stock - quantity);
		}

		OrderItem item = new OrderItem(prd, quantity);

//		create the order of the item for customer 
		Order it = new Order(customer, item);

//  add the order in the CustomerList		
		customerService.AddCustomerOrder(customer, it);

	}

	@Override
	public void DisplayOrders(Customer customer) {
		customerService.DisplayAllOrdersOfCustomer(customer);
	}

	@Override
	public void cancelOrder(Customer customer, int orderId) throws ECommerceException {
		/*
		 * 1.check the order is in customers cart 2.then delete that order
		 */
//			1
		List<Order> orde = customerService.DisplayAllOrdersOfCustomer(customer);
		Order orderToDelete = null;
		for (Order ord : orde) {
			if (ord.getOrderId() == orderId) {
				orderToDelete = ord;
			}
			if (orderToDelete != null) {
				break;
			}

		}

		if (orderToDelete != null) {
//			first restord the stock then delte the product

			for (OrderItem items : orderToDelete.getOrderItems()) {
				int getStock = items.getProduct().getProductStock();
				items.getProduct().setProductStock(getStock + 1);

			}
//			then delete the order
			orde.remove(orderToDelete);

			System.out.println("Order is deleted" + orderId);
		} else {
			throw new ResourceNotFoundException("Order is not exists");
		}

	}

}
