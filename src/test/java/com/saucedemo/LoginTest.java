package com.saucedemo;

import com.saucedemo.data.Account;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	
	@Test
	public void testSuccessfulLogIn() {
		new com.saucedemo.pages.LoginPage(driver)
				.login(Account.STANDARD_USER)
				.shouldBePresentPrimaryHeader();
	}
	
}

