package com.nithish.orderservicegraphql.entity;


public class Items {

	private Product product;
	private double subTotal;
	private int quantity;
	
	public Items(Product product, double subTotal, int quantity) {
		super();
		this.product = product;
		this.subTotal = subTotal;
		this.quantity = quantity;
	}
	public Items() {
		
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
		
	
	
	
}
