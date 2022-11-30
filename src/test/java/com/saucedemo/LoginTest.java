package com.saucedemo;

import com.saucedemo.data.Account;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
	
	private final Account standardUser = Account.STANDARD_USER;
	private final Account userWithWrongPassword = Account.STANDARD_USER_WRONG_PASSWORD;
	private final Account lockedOutUser = Account.LOCKED_OUT_USER;
	private LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() {
		loginPage = new LoginPage(driver);
	}
	
	@Test(description = "Test successful login")
	public void testSuccessfulLogIn() {
		loginPage.enterCredentials(standardUser)
				.loginButton.click();
		loginPage.loginButton.click();
		
		new InventoryPage(driver).shouldBePresentPrimaryHeader();
	}
	
	@Test(description = "Test user login with wrong password")
	public void testWrongPasswordLogIn() {
		loginPage.enterCredentials(userWithWrongPassword)
				.loginButton.click();
		loginPage.shouldBePresentErrorContainer();
		assertEquals(loginPage.getErrorMessage(),
				"Epic sadface: Username and password do not match any user in this service",
				"Error message not equal to expected");
	}
	
	@Test(description = "Test locked user login")
	public void testLockedUserLogIn() {
		loginPage.enterCredentials(lockedOutUser)
				.loginButton.click();
		loginPage.shouldBePresentErrorContainer();
		assertEquals(loginPage.getErrorMessage(),
				"Epic sadface: Sorry, this user has been locked out.",
				"Error message not equal to expected");
	}
	
}

