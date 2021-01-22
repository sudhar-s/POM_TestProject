package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage
{
	private WebDriver driver;
	private ElementUtil elementutil;
	
	/*********************************************************************************/
	
	//1. Object Repository --> By locators:
	
	By headerProductName = By.xpath("//h1[text()='iPhone']");
	By productImages = By.cssSelector(".thumbnails img");
	By productMetaData = By.cssSelector("#content .list-unstyled:nth-of-type(1) li");
	By productPrice = By.cssSelector("#content .list-unstyled:nth-of-type(2) li");
	By textBoxQuantity = By.cssSelector("#input-quantity");
	By buttonAddToCart = By.xpath("//button[@id='button-cart']");	
	
	/*********************************************************************************/
	
	//2. Constructor:
	
	public ProductInfoPage(WebDriver driver)
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
	
	public boolean isProductNameVisible()
	{
		return elementutil.isDisplayed(headerProductName);
	}
	
	public int getProductImages()
	{
		int imageCount = elementutil.getElements(productImages).size();
		System.out.println("--< Total number of images : " + imageCount);
		return imageCount;
	}
	
	public Map<String, String> getProductInformation()
	{
		Map<String, String> productInfoMap = new HashMap<String, String>(); 
		List<WebElement> productMetaData = elementutil.getElements(this.productMetaData);
		for(WebElement e: productMetaData)
		{
			String metaData[] = e.getText().split(":");
			String metaName   = metaData[0].trim();
			String metaValue  = metaData[1].trim();
			productInfoMap.put(metaName, metaValue);
		}
		
		List<WebElement> productPriceInfo = elementutil.getElements(productPrice);
		productInfoMap.put("price", productPriceInfo.get(0).getText().trim());
		productInfoMap.put("Ex Tax", productPriceInfo.get(1).getText().trim());
		return productInfoMap; 
	}

}
