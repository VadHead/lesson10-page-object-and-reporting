package net.absoft.myPages;

import net.absoft.data.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

public class InventoryPageMy extends BasePageMy {
	
	public static final By SHOPPING_CART_LINK = By.xpath("//a[@class='shopping_cart_link']");
	
	private final String itemXPath = "//div[@class='inventory_item'][.//div[@class='inventory_item_name' and text()=' %s ']]";
	
	public InventoryPageMy(WebDriver driver) {
		super(driver);
	}
	
	public void shouldBeOnPage() {
		assertTrue(driver.findElements(SHOPPING_CART_LINK).isEmpty()
						&& driver.findElement(SHOPPING_CART_LINK).isDisplayed(),
				"User " + Account.STANDARD_USER + " was not logged in");
		
	}
	
	public void addItemToCart(String itemName) {
		WebElement item = driver.findElement(By.xpath(String.format(itemXPath, itemName)));
		WebElement addToCartButton = item.findElement(By.xpath("//button[contains(@data-test,'add-to-cart')]"));
		addToCartButton.click();
	}
	
	public void openCart() {
		driver.findElement(SHOPPING_CART_LINK).click();
	}
	
}
