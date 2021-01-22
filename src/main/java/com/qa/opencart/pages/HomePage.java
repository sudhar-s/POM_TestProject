package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class HomePage
{
	private WebDriver driver;
	private ElementUtil elementUtil; 
	
	/*********************************************************************************/
	//1. Object Repository --> By locators:
	
	By logo = By.cssSelector("#logo h1 a");
	By myAccountDropDown = By.xpath("//span[text()='My Account']");
	//By myAccountDropDownItems = By.xpath("//li[@class='dropdown']/ul/li/a");
	By loginLink = By.xpath("//a[text()='Login']");
	By regiserLink = By.xpath("//a[text()='Register']");
	
	/*********************************************************************************/
	//2. Constructor:
	
	public HomePage(WebDriver driver)
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
	
	public boolean isMyAccountDropDownVisible()
	{
		return elementUtil.isDisplayed(myAccountDropDown);
	}
	
	/*public List<String> getMyAccountDropDownItems()
	{
		driver.findElement(myAccountDropDown).click();
		List<WebElement> myAccDropDownItems = driver.findElements(myAccountDropDownItems);
		List<String> myAccDropDownItemsList = new ArrayList<String>();
		for(WebElement e : myAccDropDownItems)
		{
			String text = e.getText();
			myAccDropDownItemsList.add(text);
		}
		return myAccDropDownItemsList;
	}*/
	
	public LoginPage doClickLoginLink()
	{
		elementUtil.doClick(myAccountDropDown);
		elementUtil.doClick(loginLink);
		return new LoginPage(driver);
	}
	
	public RegisterPage doClickRegisterLink()
	{
		elementUtil.doClick(myAccountDropDown);
		elementUtil.doClick(regiserLink);
		return new RegisterPage(driver);
	}
	
	
	
	/*********************************************************************************/

}
