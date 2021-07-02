package com.nithish.orderservicegraphql.entity;

public class Address {

	private String fullName;
	private Long mobileNo;
	private String houseNo;
	private String streetName;
	private String city;
	private String state;
	private int pincode;
	
	public Address() {
		super();
	}
	public Address(String fullName, Long mobileNo, String houseNo, String streetName, String city, String state,
			int pincode) {
		super();
		this.fullName = fullName;
		this.mobileNo = mobileNo;
		this.houseNo = houseNo;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [fullName=" + fullName + ", mobileNo=" + mobileNo + ", houseNo=" + houseNo + ", streetName="
				+ streetName + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}
	
	
	

}
