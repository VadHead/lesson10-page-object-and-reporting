package com.saucedemo.pages;

import com.saucedemo.components.ProductSortContainer;
import org.openqa.selenium.WebDriver;

public class BaseInventoryPage extends BaseStorePage {
	
	private final ProductSortContainer productSortContainer = new ProductSortContainer(driver);
	
	public BaseInventoryPage(WebDriver driver) {
		super(driver);
	}
	
	public BaseInventoryPage shouldBePresentSortContainer() {
		productSortContainer.shouldBePresentSortContainer();
		return this;
	}
	
	public InventoryPage filterAtoZ() {
		return productSortContainer.filterAtoZ();
	}
	
	public InventoryPage filterZtoA() {
		return productSortContainer.filterZtoA();
	}
	
	public InventoryPage filterLowToHigh() {
		return productSortContainer.filterLowToHigh();
	}
	
	public InventoryPage filterHighToLow() {
		return productSortContainer.filterHighToLow();
	}
	
}
