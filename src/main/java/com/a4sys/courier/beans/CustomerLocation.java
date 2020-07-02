package com.a4sys.courier.beans;

public class CustomerLocation {
	
	private String 	street;
	private Integer externalNumnber;
	private Integer	internalNumber;
	private String 	district;
	private String 	postalCode;
	private String 	city;
	private String 	state;
	
	public CustomerLocation() {
		super();
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Integer getExternalNumnber() {
		return externalNumnber;
	}
	public void setExternalNumnber(Integer externalNumnber) {
		this.externalNumnber = externalNumnber;
	}
	public Integer getInternalNumber() {
		return internalNumber;
	}
	public void setInternalNumber(Integer internalNumber) {
		this.internalNumber = internalNumber;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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
}
