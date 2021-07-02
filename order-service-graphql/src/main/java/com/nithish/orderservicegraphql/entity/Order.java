package com.nithish.orderservicegraphql.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Order")
public class Order {
	
	@Id
	private String orderId;
	private String orderDate;
	private double TotalPrice;
	private String orderStatus="Order Placed";
	private Address address;
	private List<Items> items;
	
	public Order() {
		super();
	}

	public Order(String orderId, String orderDate, double totalPrice, String orderStatus, Address address, List<Items> items) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		TotalPrice = totalPrice;
		this.orderStatus = orderStatus;
		this.address = address;
		this.items = items;
	}


	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		TotalPrice = totalPrice;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", TotalPrice=" + TotalPrice
				+ ", orderStatus=" + orderStatus + ",  address=" + address + ", items=" + items + "]";
	}

}
