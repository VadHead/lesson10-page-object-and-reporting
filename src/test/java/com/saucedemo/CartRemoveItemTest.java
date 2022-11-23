package com.saucedemo;

import com.saucedemo.data.Account;
import com.saucedemo.data.CheckoutInfo;
import com.saucedemo.data.Items;
import com.saucedemo.pages.CheckOutTwoPage;
import com.saucedemo.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartRemoveItemTest extends BaseTest {
	
	private final Items item = Items.ITEMS;
	private CheckOutTwoPage checkOutTwoPage;
	private CheckoutInfo info = CheckoutInfo.STANDARD_USER_INFO;
	
	@BeforeMethod
	public void setUp() {
		checkOutTwoPage = new LoginPage(driver)
				.login(Account.STANDARD_USER)
				.addItemToCart(item.getBikeLight())
				.addItemToCart(item.getBlackpack())
				.openCart()
				.checkItemPresence(item.getBikeLight())
				.checkItemPresence(item.getBlackpack())
				.removeItem(item.getBikeLight())
				.checkoutItem()
				.fillInInfo(info)
				.submit()
				.checkTitle();
	}
	
	@Test(description = "Test: Removed item does not appear at Checkout page")
	public void testRemovedItemOnCheckout() {
		checkOutTwoPage
				.checkItemAbsence(item.getBikeLight());
	}
	
}
