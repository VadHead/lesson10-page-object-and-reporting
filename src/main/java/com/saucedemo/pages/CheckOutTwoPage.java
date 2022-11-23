package com.saucedemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.*;

public class CheckOutTwoPage extends BaseStorePage {
	
	private final String itemXPath = "//div[@class='cart_item'][.//div[@class='inventory_item_name' and text()='%s']]";
	
	public CheckOutTwoPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Checking that current page is actual")
	public CheckOutTwoPage checkTitle() {
		assertEquals(driver.findElement(By.xpath("//span[@class='title']")).getText().toLowerCase(),
				"Checkout: Overview".toLowerCase());
		return this;
	}
	
	@Step("Check that item is present on the Checkout Overview Page")
	public CheckOutTwoPage checkItemPresence(String itemName) {
		String itemXPathFormatted = String.format(itemXPath, itemName);
		assertTrue(!driver.findElements(By.xpath(itemXPathFormatted)).isEmpty()
						&& driver.findElement(By.xpath(itemXPathFormatted))
						.isDisplayed(),
				"Item " + itemName + " not available on Checkout Overview page");
		return this;
	}
	
	@Step("Check that item is absent on the Checkout Overview Page")
	public CheckOutTwoPage checkItemAbsence(String itemName) {
		String itemXPathFormatted = String.format(itemXPath, itemName);
		assertFalse(!driver.findElements(By.xpath(itemXPathFormatted)).isEmpty()
						&& driver.findElement(By.xpath(itemXPathFormatted))
						.isDisplayed(),
				"Item " + itemName + " is present on Checkout Overview page");
		return this;
	}
	
	@Step("Check that order can be finished")
	public CheckoutCompletePage finish() {
		driver.findElement(By.xpath("//button[@data-test='finish']")).click();
		return new CheckoutCompletePage(driver);
	}
	
}
