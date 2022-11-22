package com.saucedemo.reporting;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AttachmentUtils {
	
	@Attachment(value = "Page screenshot", type = "img/png")
	public byte[] takeScreenshot(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Attachment(value = "Page source", type = "text/html")
	public String takePageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
}
