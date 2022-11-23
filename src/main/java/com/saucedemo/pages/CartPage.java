package com.saucedemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class CartPage extends BaseStorePage {
	
	private final String itemXPath = "//div[@class='cart_item'][.//div[@class='inventory_item_name' and text()='%s']]";
	private final String checkoutXPath = "//button[@data-test='checkout']";
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Check that item: {itemName} is present on the Cart Page")
	public CartPage checkItemPresence(String itemName) {
		String itemXPathFormatted = String.format(itemXPath, itemName);
		assertTrue(!driver.findElements(By.xpath(itemXPathFormatted)).isEmpty()
						&& driver.findElement(By.xpath(itemXPathFormatted))
						.isDisplayed(),
				"Item " + itemName + " was not added to the cart");
		return this;
	}
	
	public CartPage removeItem(String itemName) {
		String itemXPathFormatted = String.format(itemXPath, itemName);
		driver.findElement(By.xpath(itemXPathFormatted + "//button[@class='btn btn_secondary btn_small cart_button']")).click();
		return this;
	}

	public CheckOutOnePage checkoutItem(){
		driver.findElement(By.xpath(checkoutXPath)).click();
		return new CheckOutOnePage(driver);
	}
}
