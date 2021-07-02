package com.nithish.productservicegraphql.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nithish.productservicegraphql.entity.Product;


@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

	List<Product> findByProductName(String productName);

	List<Product> findByCategory(String category);

	List<Product> findByProductType(String productType);

	Product getByProductId(String productId);
	
	

}
