package com.saucedemo.pages;

import com.saucedemo.data.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseComponent {
	
	@FindBy(xpath = "//input[@data-test='username']")
	public WebElement usernameInput;
	
	@FindBy(xpath = "//input[@data-test='password']")
	public WebElement passwordInput;
	
	@FindBy(xpath = "//input[@data-test='login-button']")
	public WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public InventoryPage login(Account account) {
		usernameInput.sendKeys(account.getLogin());
		passwordInput.sendKeys(account.getPassword());
		loginButton.click();
		return new InventoryPage(driver);
	}
	
}
