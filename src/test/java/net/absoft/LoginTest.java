package net.absoft;

import net.absoft.data.Account;
import net.absoft.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

  @Test
  public void testSuccessfulLogin() {
    new LoginPage(driver)
        .login(Account.STANDARD_USER)
        .shouldSeePrimaryHeader();
  }
}
