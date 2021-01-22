package com.qa.opencart.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.factory.DriverFactory;

public class ElementUtil
{
	private WebDriver driver;
	JavaScriptUtil jsUtil;
	
	public ElementUtil(WebDriver driver)
	{
		this.driver = driver;
		jsUtil = new JavaScriptUtil(this.driver);
	}
	
	public WebElement getElement(By locator)
	{
		WebElement element = driver.findElement(locator);
		if(DriverFactory.highlight.equals("true"))
		{
			jsUtil.flash(element);
		}
		return element;
	}
	
	public List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	
	public void doSendKeys(By locator, String value)
	{
		WebElement element = getElement(locator);
		element.clear();
		element.sendKeys(value);
	}
	
	public void doClick(By locator)
	{
		getElement(locator).click();
	}
	
	public boolean isDisplayed(By locator)
	{
		return getElement(locator).isDisplayed();
	}
	
	public String doGetText(By locator)
	{
		return getElement(locator).getText();
	}
	
	
	
}
