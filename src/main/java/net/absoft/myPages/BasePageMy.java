package net.absoft.myPages;

import org.openqa.selenium.WebDriver;

public abstract class BasePageMy {
	protected WebDriver driver;
	
	public BasePageMy(WebDriver driver) {
		this.driver = driver;
	}
	
	// abstract public void shouldBeOnPage();
	
}
