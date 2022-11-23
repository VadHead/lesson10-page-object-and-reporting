package com.saucedemo.pages;

import com.saucedemo.data.CheckoutInfo;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckOutOnePage extends BaseStorePage {
	
	@FindBy(xpath = "//input[@data-test='firstName']")
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@data-test='lastName']")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@data-test='postalCode']")
	private WebElement postalCode;
	
	public CheckOutOnePage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Checking that current page is actual")
	public CheckOutOnePage checkTitle() {
		assertEquals(driver.findElement(By.xpath("//span[@class='title']")).getText().toLowerCase(),
				"Checkout: Your Information".toLowerCase());
		return this;
	}
	
	@Step("Checking the info inputs available and are empty")
	public CheckOutOnePage checkInfoInputsEmpty() {
		List<WebElement> checkoutInfoInputs = new ArrayList<>();
		Collections.addAll(checkoutInfoInputs, firstName, lastName, postalCode);
		checkoutInfoInputs.forEach(el -> assertTrue(el.getAttribute("value").isEmpty(),
				"Input with @data-test=" + el.getAttribute("data-test") + " not empty"));
		return this;
		
	}
	
	@Step("Fill in the info inputs with {checkoutInfo} data")
	public CheckOutOnePage fillInInfo(CheckoutInfo checkoutInfo) {
		firstName.sendKeys(checkoutInfo.getFirstName());
		lastName.sendKeys(checkoutInfo.getLastName());
		postalCode.sendKeys(checkoutInfo.getPostalCode());
		return this;
	}
	
	public CheckOutTwoPage submit() {
		driver.findElement(By.xpath("//input[@data-test='continue']")).click();
		return new CheckOutTwoPage(driver);
	}
	
}
