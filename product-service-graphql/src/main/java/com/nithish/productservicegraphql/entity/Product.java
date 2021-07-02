package com.nithish.productservicegraphql.entity;

import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection="Product")
public class Product {
	
	@Id
	private String productId;
	private String productType;
	private String productName;
	private String category;
	private int price;
	private String description;
	private int rating;
	private Map<String,String> specification;
	
	public Product() {
		
	}
	
	

	public Product(String productId, String productType, String productName, String category, int price,
			String description, int rating, Map<String, String> specification) {
		super();
		this.productId = productId;
		this.productType = productType;
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.description = description;
		this.rating = rating;
		this.specification = specification;
	}



	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Map<String, String> getSpecification() {
		return specification;
	}

	public void setSpecification(Map<String, String> specification) {
		this.specification = specification;
	}



	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productType=" + productType + ", productName=" + productName
				+ ", category=" + category + ", price=" + price + ", description=" + description + ", rating=" + rating
				+ ", specification=" + specification + "]";
	}

	
	
	

}
