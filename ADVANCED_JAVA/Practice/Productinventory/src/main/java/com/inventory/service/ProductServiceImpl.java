package com.inventory.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.inventory.custom_exception.ResourceNotFoundException;
import com.inventory.dto.ProductRequest;
import com.inventory.entities.Category;
import com.inventory.entities.Product;
import com.inventory.repository.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

//	here we will need the product repo dependency

	private final ProductRepository productRepository;
	private final ModelMapper mapper;

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product addProduct(ProductRequest p) {
//		we got the product from the frontend ok
//		converted the dto to entity mapping
		Product product = mapper.map(p, Product.class);

		Product save = productRepository.save(product);
		return save;
	}

	@Override
	public Product updateProduct(Long id, ProductRequest dto) {
		Product existing = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + id));
//		validate the category

		existing.setName(dto.getName());
		existing.setDescription(dto.getDescription());
		existing.setPrice(dto.getPrice());
		existing.setStockQuantity(dto.getStockQuantity());
		existing.setCategory(dto.getCategory());

		return productRepository.save(existing);

	}

	@Override
	public Boolean deleteProduct(Long p) {
//		check if product exist
		if (!productRepository.existsById(p)) {
			throw new ResourceNotFoundException("product with id " + p + " not found");
		}

		productRepository.deleteById(p);
		return true;
	}

	@Override
	public Product getProduct(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
	}

}
