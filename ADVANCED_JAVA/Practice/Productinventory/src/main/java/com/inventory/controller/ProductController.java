package com.inventory.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.Application;
import com.inventory.dto.ApiResponse;
import com.inventory.dto.ProductRequest;
import com.inventory.dto.ProductResponse;
import com.inventory.entities.Product;
import com.inventory.service.ProductService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController /* ~~(Could not parse as Java)~~> */ {

	private final Application application;

	private final ModelMapper mapper;
	private final ProductService productService;

	@GetMapping
	public ResponseEntity<?> getAllProducts() {
//		in the controller we just take the request from the user
//		and forward to the service layer
		System.out.println(productService.getAllProduct());
		return ResponseEntity.ok(productService.getAllProduct());
	}

	@PostMapping
	public ResponseEntity<?> addNewProduct(@RequestBody @Valid ProductRequest dto) {
//		here we got the dto so mapped that to entity and passed to service layer;
		Product product = productService.addProduct(dto);
//		here conversion entity to dto
		ProductResponse response = mapper.map(product, ProductResponse.class);
		ApiResponse apiResponse = new ApiResponse("Successfully Product Added", true);
		apiResponse.setData(response);
		return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);

	}

//	update the product;
	@PutMapping("/{productId}")
	public ResponseEntity<?> updateProduct(@PathVariable Long productId, @RequestBody @Valid ProductRequest dto) {
//		transfer the object to the service layer
		Product updateProduct = productService.updateProduct(productId, dto);

		ProductResponse response = mapper.map(updateProduct, ProductResponse.class);

		ApiResponse apiResponse = new ApiResponse("Product updated successfully", true);

		apiResponse.setData(response);

		return ResponseEntity.ok(apiResponse);
	}

	@GetMapping("/{productId}")
	public ResponseEntity<?> getProductById(@PathVariable Long productId) {

		Product product = productService.getProduct(productId);
		ApiResponse apiResponse = new ApiResponse("Product retrieved Successfully", true);
		apiResponse.setData(product);

		return ResponseEntity.ok(apiResponse);

	}

	@DeleteMapping("/{productId}")
	public ResponseEntity<?> deleteProductById(@PathVariable Long productId) {

		productService.deleteProduct(productId);
		return ResponseEntity.ok(new ApiResponse("product deletedSuccessFully", true));

	}

}
