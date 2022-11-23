package com.saucedemo;

import com.saucedemo.data.Account;
import com.saucedemo.data.CheckoutInfo;
import com.saucedemo.pages.CheckOutTwoPage;
import com.saucedemo.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTwoTest extends BaseTest {
	
	private CheckOutTwoPage checkOutTwoPage;
	private CheckoutInfo info = CheckoutInfo.STANDARD_USER_INFO;
	
	@BeforeMethod
	public void setUp() {
		checkOutTwoPage = new LoginPage(driver)
				.login(Account.STANDARD_USER)
				.shouldBePresentPrimaryHeader()
				.openCart()
				.checkoutItem()
				.checkTitle()
				.checkInfoInputsEmpty()
				.fillInInfo(info)
				.submit()
				.checkTitle();
	}
	
	@Test(description = "Checkout Step Two page order finishing test")
	public void finishOrder() {
		checkOutTwoPage.finish();
	}
	
}
