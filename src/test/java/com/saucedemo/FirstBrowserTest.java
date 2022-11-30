package com.saucedemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FirstBrowserTest {
	
	private WebDriver driver;
	
	@BeforeSuite
	public void driverSetUp() {
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeClass
	public void setUp() {
		ChromeOptions options = new ChromeOptions().addArguments("--windows-size=1920,1080");
		driver = new ChromeDriver(options);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void firstBrowserTest() {
		driver.get("https://google.com");
		assertEquals(driver.getTitle(), "Google", "Title does not match \"Google\"");
	}
	
}
