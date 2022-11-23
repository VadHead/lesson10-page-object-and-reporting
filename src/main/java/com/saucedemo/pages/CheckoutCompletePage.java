package com.saucedemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class CheckoutCompletePage extends BaseStorePage {
	
	public CheckoutCompletePage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Checking that current page is actual")
	public CheckoutCompletePage checkTitle() {
		assertEquals(driver.findElement(By.xpath("//span[@class='title']")).getText().toLowerCase(),
				"Checkout: Complete!".toLowerCase());
		return this;
	}
	
	@Step("Checking order is completed")
	public CheckoutCompletePage checkOrderComplete() {
		assertEquals(driver.findElement(By.xpath("//h2[@class='complete-header']")).getText().toLowerCase(),
				"THANK YOU FOR YOUR ORDER".toLowerCase());
		return this;
	}
	
}
