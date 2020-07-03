package com.a4sys.courier.beans;

public class CustomerBasics {
	
	private String names;
	private String lastName;
	private String maternalLastName;
	private String phoneContact;

	public CustomerBasics() {
		super();
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMaternalLastName() {
		return maternalLastName;
	}
	public void setMaternalLastName(String maternalLastName) {
		this.maternalLastName = maternalLastName;
	}
	public String getPhoneContact() {
		return phoneContact;
	}
	public void setPhoneContact(String phoneContact) {
		this.phoneContact = phoneContact;
	}
}
