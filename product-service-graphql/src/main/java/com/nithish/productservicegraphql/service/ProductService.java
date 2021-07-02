package com.nithish.productservicegraphql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.nithish.productservicegraphql.entity.Product;
import com.nithish.productservicegraphql.repository.ProductRepository;

@Service
public class ProductService implements GraphQLQueryResolver, GraphQLMutationResolver {
	
	@Autowired
	ProductRepository productRepository;

	public List<Product> getAllProducts() {

		return productRepository.findAll();
	}

	public List<Product> getProductByName(String productName) {

		return productRepository.findByProductName(productName);
	}

	public List<Product> getProductByCategory(String category) {

		return productRepository.findByCategory(category);
	}

	public List<Product> getProductByType(String productType) {

		return productRepository.findByProductType(productType);
	}

	/*
	 * public Product addProduct(Product product) {
	 * 
	 * return productRepository.save(product); }
	 */

	public Product updateProduct(String productId, int price, String description) {
		
		Product product= productRepository.getByProductId(productId);
		product.setPrice(price);
		product.setDescription(description);
		productRepository.save(product);

		return product;
	}

	public String deleteProductById(String productId) {

		productRepository.deleteById(productId);
		return "Product was succesfully deleted";
	}

	public Optional<Product> getProductById(String productId) {

		return productRepository.findById(productId);
	}

}
