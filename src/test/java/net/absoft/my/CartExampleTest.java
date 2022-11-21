package net.absoft.my;

import net.absoft.data.Account;
import net.absoft.myPages.CartPageMy;
import net.absoft.myPages.InventoryPageMy;
import net.absoft.myPages.LoginPageMy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CartExampleTest extends BaseExampleTest {
	
	private final String ITEM = "Sauce Labs Backpack";
	
	@BeforeMethod
	public void setUp() {
		new LoginPageMy(driver).login(Account.STANDARD_USER);
	}
	
	@Test
	public void testAddingItemToCart() {
		InventoryPageMy inventoryPageMy = new InventoryPageMy(driver);
		inventoryPageMy.addItemToCart(ITEM);
		inventoryPageMy.openCart();
		
		CartPageMy cartPageMy = new CartPageMy(driver);
		cartPageMy.checkItemPresence(ITEM);
	}
	
}
