package com.inventory.service;

import java.util.List;

import com.inventory.dto.ProductRequest;
import com.inventory.entities.Product;

public interface ProductService {

	List<Product> getAllProduct();

	Product addProduct(ProductRequest p);

	Boolean deleteProduct(Long id);

	Product updateProduct(Long id, ProductRequest p);

	Product getProduct(Long id);

}
