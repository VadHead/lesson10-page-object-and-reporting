package com.saucedemo;

import com.saucedemo.data.Account;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class LoginTest extends BaseTest {
	
	Account account = Account.STANDARD_USER;
	
	@Test (description = "Test successful login")
	public void testSuccessfulLogIn() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.usernameInput.sendKeys(account.getLogin());
		loginPage.passwordInput.sendKeys(account.getPassword());
		loginPage.loginButton.click();
		
		new InventoryPage(driver).shouldBePresentPrimaryHeader();
		fail("Failing");
	}
	
}

