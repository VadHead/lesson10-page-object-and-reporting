package com.saucedemo.data;

public enum CheckoutInfo {
	STANDARD_USER_INFO("Luke", "Skywalker", "Tatooine-00FF00");
	
	private String firstName;
	private String lastName;
	private String postalCode;
	
	CheckoutInfo(String firstName, String lastName, String postalCode) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.postalCode = postalCode;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	@Override
	public String toString() {
		return "Checkout Info{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", postalCode='" + postalCode + '\'' +
				'}';
	}
}
