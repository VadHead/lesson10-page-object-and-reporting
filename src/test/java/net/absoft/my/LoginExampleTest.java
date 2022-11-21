package net.absoft.my;

import net.absoft.data.Account;
import net.absoft.myPages.InventoryPageMy;
import net.absoft.myPages.LoginPageMy;
import org.testng.annotations.Test;

public class LoginExampleTest extends BaseExampleTest {
	
	@Test
	public void testSuccessfulLogIn() {
		new LoginPageMy(driver).login(Account.STANDARD_USER);
		new InventoryPageMy(driver).shouldBeOnPage();
	}
	
}

