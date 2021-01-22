package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class LoginPage
{
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	/*********************************************************************************/
	//1. Object Repository --> By locators:
	
	By logo = By.cssSelector("#logo h1 a");
	By emailAddress = By.cssSelector("#input-email");
	By password = By.cssSelector("#input-password");
	By forgotPasswordLink = By.cssSelector(".form-group a");
	By loginButton = By.xpath("//input[@type='submit']");
	By rightSideLinks = By.cssSelector("#column-right div a");
	By continueButton = By.xpath("//a[text()='Continue']");
	
	/*********************************************************************************/
	
	//2. Constructor:
	
	public LoginPage(WebDriver driver)
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
	
	public AccountsPage doLogin(String email, String paswrd)
	{
		elementUtil.doSendKeys(emailAddress, email);
		elementUtil.doSendKeys(password, paswrd);
		elementUtil.doClick(loginButton);
		return new AccountsPage(driver);
	}
	
	public boolean isContinueButtonExist()
	{
		return elementUtil.isDisplayed(continueButton);
	}
	
	
	/*********************************************************************************/
	
}
