package com.saucedemo;

import com.saucedemo.data.Account;
import com.saucedemo.data.CheckoutInfo;
import com.saucedemo.pages.CheckOutOnePage;
import com.saucedemo.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutOneTest extends BaseTest {
	
	private CheckOutOnePage checkOutOnePage;
	private CheckoutInfo info = CheckoutInfo.STANDARD_USER_INFO;
	
	@BeforeMethod
	public void setUp() {
		checkOutOnePage = new LoginPage(driver)
				.login(Account.STANDARD_USER)
				.shouldBePresentPrimaryHeader()
				.openCart()
				.checkoutItem()
				.checkTitle();
	}
	
	@Test(description = "Checkout Step One page information submitting test")
	public void buyItem() {
		checkOutOnePage
				.checkInfoInputsEmpty()
				.fillInInfo(info)
				.submit();
	}
	
}
