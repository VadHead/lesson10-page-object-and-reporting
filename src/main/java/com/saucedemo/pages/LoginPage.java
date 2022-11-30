package com.saucedemo.pages;

import com.saucedemo.data.Account;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

public class LoginPage extends BaseComponent {
	
	@FindBy(xpath = "//input[@data-test='username']")
	public WebElement usernameInput;
	
	@FindBy(xpath = "//input[@data-test='password']")
	public WebElement passwordInput;
	
	@FindBy(xpath = "//input[@data-test='login-button']")
	public WebElement loginButton;
	
	@FindBy(xpath = "//h3[@data-test='error']")
	public WebElement errorContainer;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Perform login as user:{account.login} with password:{account.password}")
	public InventoryPage login(Account account) {
		this.enterCredentials(account);
		loginButton.click();
		return new InventoryPage(driver);
	}
	
	@Step("Enter user credentials:{account.login} with password:{account.password}")
	public LoginPage enterCredentials(Account account) {
		usernameInput.sendKeys(account.getLogin());
		passwordInput.sendKeys(account.getPassword());
		return this;
	}
	
	@Step("Check Error Container presence")
	public LoginPage shouldBePresentErrorContainer() {
		assertTrue(errorContainer.isDisplayed(),
				"Error is not displayed");
		return this;
	}
	
	@Step("Get Error message")
	public String getErrorMessage() {
		return errorContainer.getText();
	}
	
}
