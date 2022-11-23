package com.saucedemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage extends BaseStorePage {
	
	private final String itemAddToCartXPath = "//div[@class='inventory_item'][.//div[@class='inventory_item_name' and text()='%s']]//button[contains(@data-test,'add-to-cart')]";
	private final Select sortContainer = new Select(
			driver.findElement(By.cssSelector("[data-test='product_sort_container']")));
	
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
	
	public boolean checkPriceLowToHigh(List<String> list) {
		List<Double> pricesList = list.stream().map(s -> Double.parseDouble(s.replace("$", "")))
				.collect(Collectors.toList());
		List<Double> sortedPricesList = new ArrayList<>(pricesList);
		Collections.sort(sortedPricesList);
		return sortedPricesList.equals(pricesList);
	}
	
	public boolean checkPriceHighToLow(List<String> list) {
		List<Double> pricesList = list.stream().map(s -> Double.parseDouble(s.replace("$", "")))
				.collect(Collectors.toList());
		List<Double> sortedPricesList = new ArrayList<>(pricesList);
		Collections.sort(sortedPricesList);
		Collections.reverse(sortedPricesList);
		return sortedPricesList.equals(pricesList);
	}
	
	public boolean checkPriceAtoZ(List<String> nameList) {
		List<String> sortedNamesList = new ArrayList<>(nameList);
		Collections.sort(sortedNamesList);
		return sortedNamesList.equals(nameList);
	}
	
	public boolean checkPriceZtoA(List<String> nameList) {
		List<String> sortedNamesList = new ArrayList<>(nameList);
		Collections.sort(sortedNamesList);
		Collections.reverse(sortedNamesList);
		return sortedNamesList.equals(nameList);
	}
	
	@Step("Sorting items A to Z")
	public InventoryPage filterAtoZ() {
		sortContainer.selectByValue("az");
		return this;
	}
	
	@Step("Sorting items Z to A")
	public InventoryPage filterZtoA() {
		sortContainer.selectByValue("za");
		return this;
	}
	
	@Step("Sorting items Low to High")
	public InventoryPage filterLowToHigh() {
		sortContainer.selectByValue("lohi");
		return this;
	}
	
	@Step("Sorting items High to Low")
	public InventoryPage filterHighToLow() {
		sortContainer.selectByValue("hilo");
		return this;
	}
	
}
