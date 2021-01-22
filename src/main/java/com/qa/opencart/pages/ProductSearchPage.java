package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class ProductSearchPage
{
	private WebDriver driver;
	private ElementUtil elementutil;
	
	/*********************************************************************************/
	
	//1. Object Repository --> By locators:
	
	By headerSearch = By.cssSelector("#content h1");
	By headerSearchCriteria = By.cssSelector("#content h2");
	By resultProduct = By.cssSelector(".product-layout");
	
	/*********************************************************************************/
	
	//2. Constructor:
	
	public ProductSearchPage(WebDriver driver)
	{
		this.driver = driver;
		elementutil = new ElementUtil(this.driver);
	}
	
	/*********************************************************************************/
	
	//3. Page Actions/Methods/Page libraries:
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isHeaderSearchVisible()
	{
		return elementutil.isDisplayed(headerSearch);
	}
	
	public boolean isHeaderSearchCriteriaVisible()
	{
		return elementutil.isDisplayed(headerSearchCriteria);
	}
	
	public boolean isProductAvailable()
	{
		return elementutil.isDisplayed(resultProduct);
	}
	
	public ProductInfoPage doClickProduct()
	{
		elementutil.doClick(resultProduct);
		return new ProductInfoPage(driver);
	}
	
	/*********************************************************************************/
	
}
