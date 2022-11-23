package com.saucedemo;

import com.saucedemo.data.Account;
import com.saucedemo.data.CheckoutInfo;
import com.saucedemo.data.Items;
import com.saucedemo.pages.CheckoutCompletePage;
import com.saucedemo.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutCompleteTest extends BaseTest {
	
	private CheckoutCompletePage checkoutCompletePage;
	private CheckoutInfo info = CheckoutInfo.STANDARD_USER_INFO;
	private final Items item = Items.ITEMS;
	
	
	@BeforeMethod
	public void setUp() {
		checkoutCompletePage = new LoginPage(driver)
				.login(Account.STANDARD_USER)
				.addItemToCart(item.getBlackpack())
				.openCart()
				.checkoutItem()
				.checkTitle()
				.checkInfoInputsEmpty()
				.fillInInfo(info)
				.submit()
				.checkTitle()
				.checkItemPresence(item.getBlackpack())
				.finish()
				.checkTitle();
	}
	
	@Test(description = "Checkout Complete")
	public void checkOrderCompleted() {
		checkoutCompletePage
				.checkOrderComplete();
	}
	
}
