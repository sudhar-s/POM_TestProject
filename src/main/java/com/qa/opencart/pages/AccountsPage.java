package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage
{
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	/*********************************************************************************/
	
	//1. Object Repository --> By locators:
	
	By logo = By.cssSelector("#logo h1 a");
	By headers = By.cssSelector("#content h2");
	By searchTextBox = By.cssSelector(".form-control");
	By rightSideLinks = By.cssSelector("#column-right div a");
	By searchButton = By.cssSelector(".input-group-btn button");
	
	/*********************************************************************************/
	
	//2. Constructor:
	
	public AccountsPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	/*********************************************************************************/
	
	//3. Page Actions/Methods/Page libraries:
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isLogoVisible()
	{
		return elementUtil.isDisplayed(logo);
	}
	
	public boolean isSearchTextBoxVisible()
	{
		return elementUtil.isDisplayed(searchTextBox);
	}
	
	public List<String> getRightSideLinks()
	{
		List<WebElement> links = elementUtil.getElements(rightSideLinks);
		List<String> linkText = new ArrayList<String>();
		for(WebElement e : links)
		{
			String text = e.getText();
			linkText.add(text);
		}
		return linkText;
	}
	
	public ProductSearchPage doSearch_iPhone()
	{
		elementUtil.doSendKeys(searchTextBox, Constants.PRODUCT_IPHONE);
		elementUtil.doClick(searchButton);
		return new ProductSearchPage(driver);
	}
	
	
	/*********************************************************************************/
	
}
