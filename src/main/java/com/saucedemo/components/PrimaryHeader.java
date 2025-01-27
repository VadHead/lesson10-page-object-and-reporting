package com.saucedemo.components;

import com.saucedemo.pages.BaseComponent;
import com.saucedemo.pages.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class PrimaryHeader extends BaseComponent {
	
	public final By SHOPPING_CART_LINK = By.className("shopping_cart_link");
	
	public PrimaryHeader(WebDriver driver) {
		super(driver);
	}
	
	public PrimaryHeader shouldBePresentPrimaryHeader() {
		assertTrue(!driver.findElements(SHOPPING_CART_LINK).isEmpty()
						&& driver.findElement(SHOPPING_CART_LINK).isDisplayed(),
				"Header is not displayed");
		return this;
	}
	
	public CartPage openCart() {
		driver.findElement(SHOPPING_CART_LINK).click();
		return new CartPage(driver);
	}
	
}
