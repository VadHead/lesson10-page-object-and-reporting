package com.saucedemo.data;

public enum Items {
	ITEMS("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)");
	
	private String blackpack;
	private String bikeLight;
	private String boltTShirt;
	private String fleeceJacket;
	private String onesie;
	private String shirtRed;
	
	Items(String s, String s1, String s2, String s3, String s4, String s5) {
		this.blackpack = s;
		this.bikeLight = s1;
		this.boltTShirt = s2;
		this.fleeceJacket = s3;
		this.onesie = s4;
		this.shirtRed = s5;
	}
	
	public String getBlackpack() {
		return blackpack;
	}
	
	public String getBikeLight() {
		return bikeLight;
	}
	
	public String getBoltTShirt() {
		return boltTShirt;
	}
	
	public String getFleeceJacket() {
		return fleeceJacket;
	}
	
	public String getOnesie() {
		return onesie;
	}
	
	public String getShirtRed() {
		return shirtRed;
	}
}
