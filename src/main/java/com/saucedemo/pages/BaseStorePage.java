package com.saucedemo.pages;

import com.saucedemo.components.PrimaryHeader;
import org.openqa.selenium.WebDriver;

public abstract class BaseStorePage extends BaseComponent {
	
	private final PrimaryHeader header = new PrimaryHeader(driver);
	
	public BaseStorePage(WebDriver driver) {
		super(driver);
	}
	
	public BaseStorePage shouldBePresentPrimaryHeader() {
		header.shouldBePresentPrimaryHeader();
		return this;
	}
	
	public CartPage openCart() {
		return header.openCart();
	}
	
}
