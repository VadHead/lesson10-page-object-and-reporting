package net.absoft.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class CartPageMy extends BasePageMy {
	
	private final String itemXPath = "//div[@class='cart_item'][.//div[@class='cart_item_name' and text()=' %s ']]";
	
	public CartPageMy(WebDriver driver) {
		super(driver);
	}
	
	public void checkItemPresence(String itemName) {
		String itemXPathFormatted = String.format(itemXPath, itemName);
		assertTrue(!driver.findElements(By.xpath(itemXPathFormatted)).isEmpty()
						&& driver.findElement(By.xpath(itemXPathFormatted))
						.isDisplayed(),
				"Item " + itemName + " was not added to the cart");
	}
	
}
