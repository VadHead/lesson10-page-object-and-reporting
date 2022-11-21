package net.absoft.myPages;

import net.absoft.data.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageMy extends BasePageMy{
	
	public LoginPageMy(WebDriver driver) {
		super(driver);
	}
	
	public void login(Account account) {
		driver.findElement(By.xpath("//input[@data-test='username']")).sendKeys(account.getLogin());
		driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys(account.getPassword());
		driver.findElement(By.xpath("//input[@data-test='login-button']")).click();
	}
	
}
