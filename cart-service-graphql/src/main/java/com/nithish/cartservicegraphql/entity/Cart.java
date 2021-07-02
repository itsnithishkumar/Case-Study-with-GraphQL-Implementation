package com.nithish.cartservicegraphql.entity;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="Cart")
public class Cart {
	
	@Id
	private String cartId;
	private double cartTotal;
	private List<Items> items= new ArrayList<>();;
	
	public Cart() {
		super();
	}
	public Cart(String cartId, List<Items> items) {
		super();
		this.cartId = cartId;
		this.items = items;
	}
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public double getCartTotal() {
		return cartTotal;
	}
	public void setCartTotal(double cartTotal) {
		this.cartTotal = cartTotal;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	public static double getSubTotalForItem(Product product, int quantity){
	       return (product.getPrice()*quantity);
	    }

}
