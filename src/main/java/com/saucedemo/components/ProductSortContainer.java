package com.saucedemo.components;

import com.saucedemo.pages.BaseComponent;
import com.saucedemo.pages.InventoryPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertTrue;

public class ProductSortContainer extends BaseComponent {
	
	private final By SORT_CONTAINER = By.cssSelector("[data-test='product_sort_container']");
	private final Select sortContainerSelect = new Select(
			driver.findElement(SORT_CONTAINER));
	
	public ProductSortContainer(WebDriver driver) {
		super(driver);
	}
	
	public ProductSortContainer shouldBePresentSortContainer() {
		assertTrue(!driver.findElements(SORT_CONTAINER).isEmpty()
						&& driver.findElement(SORT_CONTAINER).isDisplayed(),
				"Header is not displayed");
		return this;
	}
	
	@Step("Sorting items by name: A to Z")
	public InventoryPage filterAtoZ() {
		sortContainerSelect.selectByValue("az");
		return new InventoryPage(driver);
	}
	
	@Step("Sorting items by name: Z to A")
	public InventoryPage filterZtoA() {
		sortContainerSelect.selectByValue("za");
		return new InventoryPage(driver);
	}
	
	@Step("Sorting items by price: Low to High")
	public InventoryPage filterLowToHigh() {
		sortContainerSelect.selectByValue("lohi");
		return new InventoryPage(driver);
	}
	
	@Step("Sorting items by price: High to Low")
	public InventoryPage filterHighToLow() {
		sortContainerSelect.selectByValue("hilo");
		return new InventoryPage(driver);
	}
	
}
