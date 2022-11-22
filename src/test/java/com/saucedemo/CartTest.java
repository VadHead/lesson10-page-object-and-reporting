package com.saucedemo;

import com.saucedemo.data.Account;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
	
	private final String ITEM = "Sauce Labs Backpack";
	private InventoryPage inventoryPage;
	
	@BeforeMethod
	public void setUp() {
		new LoginPage(driver)
				.login(Account.STANDARD_USER)
				.shouldBePresentPrimaryHeader();
		inventoryPage = new InventoryPage(driver);
	}
	
	@Test(description = "Test adding the item to the cart")
	public void testAddingItemToCart() {
		inventoryPage
				.addItemToCart(ITEM)
				.openCart()
				.checkItemPresence(ITEM);
	}
	
}
