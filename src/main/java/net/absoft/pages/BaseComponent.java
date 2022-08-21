package net.absoft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public abstract class BaseComponent {
  protected WebDriver driver;

  public BaseComponent(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
  }
}
