package com.saucedemo;

import com.saucedemo.data.Account;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class ItemsSortingTest extends BaseTest {
	
	private InventoryPage inventoryPage;
	
	@BeforeMethod
	public void setUp() {
		new LoginPage(driver)
				.login(Account.STANDARD_USER)
				.shouldBePresentPrimaryHeader();
		inventoryPage = new InventoryPage(driver);
	}
	
	@Test(description = "Testing sorting of items Name: from A to Z")
	public void itemsSortingAToZ() {
		List<String> itemsNameList = inventoryPage.filterAtoZ().itemsNameCollect();
		assertTrue(inventoryPage.checkPriceAtoZ(itemsNameList), "Items not sorted properly");
	}
	
	@Test(description = "Testing sorting of items Name: from Z to A")
	public void itemsSortingZToA() {
		List<String> itemsNameList = inventoryPage.filterZtoA().itemsNameCollect();
		assertTrue(inventoryPage.checkPriceZtoA(itemsNameList), "Items not sorted properly");
	}
	
	@Test(description = "Testing sorting of items Price: Low to High")
	public void itemsSortingLowToHigh() {
		List<String> itemsPriceList = inventoryPage.filterLowToHigh().itemsPriceCollect();
		assertTrue(inventoryPage.checkPriceLowToHigh(itemsPriceList), "Items not sorted properly");
	}
	
	@Test(description = "Testing sorting of items Price: High to Low")
	public void itemsSortingHighToLow() {
		List<String> itemsPriceList = inventoryPage.filterHighToLow().itemsPriceCollect();
		assertTrue(inventoryPage.checkPriceHighToLow(itemsPriceList), "Items not sorted properly");
	}
	
}

