package com.saucedemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage extends BaseInventoryPage {
	
	private final String itemAddToCartXPath = "//div[@class='inventory_item']"
			+ "[.//div[@class='inventory_item_name' and text()='%s']]"
			+ "//button[contains(@data-test,'add-to-cart')]";
	
	public InventoryPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Adding item {itemName} to the cart")
	public InventoryPage addItemToCart(String itemName) {
		WebElement itemAddToCartButton = driver.findElement(By.xpath(String.format(itemAddToCartXPath, itemName)));
		itemAddToCartButton.click();
		return this;
	}
	
	public List<String> itemsNameCollect() {
		List<String> itemsNameList = new ArrayList<>();
		driver.findElements(By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_name']"))
				.forEach(el -> itemsNameList.add(el.getText()));
		return itemsNameList;
	}
	
	public List<String> itemsPriceCollect() {
		List<String> itemsPriceList = new ArrayList<>();
		driver.findElements(By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_price']"))
				.forEach(el -> itemsPriceList.add(el.getText()));
		return itemsPriceList;
	}
	
	@Step("Check items sorting by price: Low to High")
	public boolean checkPriceLowToHigh(List<String> list) {
		List<Double> pricesList = list.stream().map(s -> Double.parseDouble(s.replace("$", "")))
				.collect(Collectors.toList());
		List<Double> sortedPricesList = new ArrayList<>(pricesList);
		Collections.sort(sortedPricesList);
		return sortedPricesList.equals(pricesList);
	}
	
	@Step("Check items sorting by price: High to Low")
	public boolean checkPriceHighToLow(List<String> list) {
		List<Double> pricesList = list.stream().map(s -> Double.parseDouble(s.replace("$", "")))
				.collect(Collectors.toList());
		List<Double> sortedPricesList = new ArrayList<>(pricesList);
		Collections.sort(sortedPricesList);
		Collections.reverse(sortedPricesList);
		return sortedPricesList.equals(pricesList);
	}
	
	@Step("Check items sorting by name: Z to A")
	public boolean checkNameAtoZ(List<String> nameList) {
		List<String> sortedNamesList = new ArrayList<>(nameList);
		Collections.sort(sortedNamesList);
		return sortedNamesList.equals(nameList);
	}
	
	@Step("Check items sorting by name: Z to A")
	public boolean checkNameZtoA(List<String> nameList) {
		List<String> sortedNamesList = new ArrayList<>(nameList);
		Collections.sort(sortedNamesList);
		Collections.reverse(sortedNamesList);
		return sortedNamesList.equals(nameList);
	}
	
}
