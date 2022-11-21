package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;

public abstract class BaseComponent {
	
	protected WebDriver driver;
	
	public BaseComponent(WebDriver driver) {
		this.driver = driver;
	}
	
}
