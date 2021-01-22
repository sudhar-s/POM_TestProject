package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class ProductSearchPageTest extends BaseTest
{
	@BeforeClass
	public void loginTest()
	{
		loginpage = homepage.doClickLoginLink();
		accountspage = loginpage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
		productsearchpage = accountspage.doSearch_iPhone();
	}
	
	@Test
	public void titleTest()
	{
		String title = productsearchpage.getPageTitle();
		System.out.println("--< Page Title is : " + title);
		Assert.assertEquals(title, ("Search - "+Constants.PRODUCT_IPHONE));
	}
	
	@Test
	public void headerSearchVisibleTest()
	{
		Assert.assertTrue(productsearchpage.isHeaderSearchVisible());
	}
	
	@Test
	public void headerSearchCriteriaVisibleTest()
	{
		Assert.assertTrue(productsearchpage.isHeaderSearchCriteriaVisible());
	}
	
	@Test
	public void productAvailableTest()
	{
		Assert.assertTrue(productsearchpage.isProductAvailable());
	}
	
	@Test
	public void clickProductTest()
	{
		productinfopage = productsearchpage.doClickProduct();
	}
	
	
}
