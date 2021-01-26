package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.GeneralUtil;
import com.qa.opencart.utils.JavaScriptUtil;

public class RegisterPage 
{
	private WebDriver driver;
	private ElementUtil elementutil;
	private JavaScriptUtil javascriptutil;
	
	
	/*********************************************************************************/
	
	//1. Object Repository --> By locators:
	
	By headerPage = By.cssSelector("#content h1");
	By rightSideLinks = By.cssSelector("#column-right div a");
	
	By headerPersonalDetails = By.cssSelector("#account legend");
	By labelFirstName = By.xpath("//label[@for='input-firstname']");
	By labelLastName = By.xpath("//label[@for='input-lastname']");
	By labelEmail = By.xpath("//label[@for='input-email']");
	By labelTelephone = By.xpath("//label[@for='input-telephone']");
	By textBoxFirstName = By.cssSelector("#input-firstname");
	By textBoxLastName = By.cssSelector("#input-lastname");	
	By textBoxEmail = By.cssSelector("#input-email");	
	By textBoxTelephone = By.cssSelector("#input-telephone");
	
	By headerYourPassword = By.xpath("//div[@id='content']/form/fieldset/legend[text()='Your Password']");
	By labelPassword = By.xpath("//label[@for='input-password']");
	By labelConfirmPassword = By.xpath("//label[@for='input-confirm']");
	By textBoxPassword = By.cssSelector("#input-password");
	By textBoxConfirmPassword = By.cssSelector("#input-confirm");
	
	By headerNewsLetter = By.xpath("//div[@id='content']/form/fieldset/legend[text()='Newsletter']");
	By labelRadioButtons = By.xpath("//label[@class='radio-inline']");
	By radioButtonYes = By.cssSelector(".radio-inline input[value='1']");
	By radioButtonNo = By.cssSelector(".radio-inline input[value='0']");
	
	By labelPrivacyPolicy = By.xpath("//div[@class='pull-right']");
	By checkBoxPrivacyPolicy = By.xpath("//input[@type='checkbox']");
	By buttonContinue = By.xpath("//input[@type='submit']");
	
	By headerSuccessMsg = By.cssSelector("#content h1");
	By linkLogout = By.linkText("Logout");
	By linkRegister = By.linkText("Register");
	
	/*********************************************************************************/
	
	//2. Constructor:
	
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
		elementutil = new ElementUtil(this.driver);
		javascriptutil = new JavaScriptUtil(this.driver);
	}
	
	/*********************************************************************************/
	
	//3. Page Actions/Methods/Page libraries:
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isHeaderPageHeaderVisible()
	{
		return elementutil.isDisplayed(headerPage);
	}
	public boolean isHeaderPersonalDetailsHeaderVisible()
	{
		return elementutil.isDisplayed(headerPersonalDetails);
	}
	public boolean isHeaderYourPasswordHeaderVisible()
	{
		return elementutil.isDisplayed(headerYourPassword);
	}
	public boolean isHeaderNewsLetterHeaderVisible()
	{
		return elementutil.isDisplayed(headerNewsLetter);
	}
	public boolean isLabelFirstNameLabelVisible()
	{
		return elementutil.isDisplayed(labelFirstName);
	}
	public boolean isLabelLastNameLabelVisible()
	{
		return elementutil.isDisplayed(labelLastName);
	}
	public boolean isLabelEmailLabelVisible()
	{
		return elementutil.isDisplayed(labelEmail);
	}
	public boolean isLabelTelephoneLabelVisible()
	{
		javascriptutil.scrollIntoView(elementutil.getElement(labelTelephone));
		return elementutil.isDisplayed(labelTelephone);
	}
	public boolean isLabelPasswordLabelVisible()
	{
		return elementutil.isDisplayed(labelPassword);
	}
	public boolean isLabelConfirmPasswordLabelVisible()
	{
		return elementutil.isDisplayed(labelConfirmPassword);
	}
	public List<String> isLabelRadioButtonsLabelVisible()
	{
		List<WebElement> labels = elementutil.getElements(labelRadioButtons);
		List<String> labelText = new ArrayList<String>();
		for(WebElement e : labels)
		{
			String text = e.getText();
			labelText.add(text);
		}
		return labelText;
	}
	public boolean isTextBoxFirstNameTextBoxVisible()
	{
		javascriptutil.scrollIntoView(elementutil.getElement(textBoxFirstName));
		return elementutil.isDisplayed(textBoxFirstName);
	}
	public boolean isTextBoxLastNameTextBoxVisible()
	{
		return elementutil.isDisplayed(textBoxLastName);
	}
	public boolean isTextBoxEmailTextBoxVisible()
	{
		return elementutil.isDisplayed(textBoxEmail);
	}
	public boolean isTextBoxTelephoneTextBoxVisible()
	{
		return elementutil.isDisplayed(textBoxTelephone);
	}
	public boolean isTextBoxPasswordTextBoxVisible()
	{
		return elementutil.isDisplayed(textBoxPassword);
	}
	public boolean isTextBoxConfirmPasswordTextBoxVisible()
	{
		return elementutil.isDisplayed(textBoxConfirmPassword);
	}
	public boolean isRadioButtonYesRadioButtonVisible()
	{
		return elementutil.isDisplayed(radioButtonYes);
	}
	public boolean isRadioButtonNoRadioButtonVisible()
	{
		return elementutil.isDisplayed(radioButtonNo);
	}
	public boolean isLabelPrivacyPolicyDisplayed() {
		return elementutil.isDisplayed(labelPrivacyPolicy);
	}
	public boolean isCheckBoxPrivacyPolicyCheckBoxVisible()
	{
		return elementutil.isDisplayed(checkBoxPrivacyPolicy);
	}
	public boolean isButtonContinueButtonDisplayed()
	{
		return elementutil.isDisplayed(buttonContinue);
	}
	
	public List<String> getRightSideLinks()
	{
		List<WebElement> links = elementutil.getElements(rightSideLinks);
		List<String> linkText = new ArrayList<String>();
		for(WebElement e : links)
		{
			String text = e.getText();
			linkText.add(text);
		}
		return linkText;
	}
	
	public boolean accountRegistration(String fn, String ln, String subscribe)
	{
		int random_number_email = GeneralUtil.getRandomNumber_Email();
		String email = Constants.EMAIL_ID_BEGINS + random_number_email + Constants.EMAIL_ID_ENDS;
		String phone =  String.valueOf(GeneralUtil.getRandomNumber_Phone());
		String pwd = Constants.EMAIL_ID_BEGINS + "@" + random_number_email;		
		
		elementutil.doSendKeys(textBoxFirstName, fn);
		elementutil.doSendKeys(textBoxLastName, ln);
		elementutil.doSendKeys(textBoxEmail, email);
		System.out.println("--< Email Address is :" + email);
		javascriptutil.scrollIntoView(elementutil.getElement(textBoxTelephone));
		elementutil.doSendKeys(textBoxTelephone, phone);
		System.out.println("--< Telephone is :" + phone);
		elementutil.doSendKeys(textBoxPassword, pwd);
		System.out.println("--< Password is :" + pwd);
		elementutil.doSendKeys(textBoxConfirmPassword, pwd);
		
		if(subscribe.equals("yes"))
			elementutil.doClick(radioButtonYes);
		else
			elementutil.doClick(radioButtonNo);
		
		elementutil.doClick(checkBoxPrivacyPolicy);
		elementutil.doClick(buttonContinue);
		
		String msg = elementutil.doGetText(headerSuccessMsg);
		if(msg.equals(Constants.ACCOUNT_SUCCESS_MESSAGE))
		{
			javascriptutil.scrollIntoView(elementutil.getElement(linkLogout));
			elementutil.doClick(linkLogout);
			elementutil.doClick(linkRegister);
			return true;
		}
		return false;
	}
	
	
		
	
	
}
