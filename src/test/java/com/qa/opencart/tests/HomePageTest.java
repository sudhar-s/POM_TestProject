package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;


public class HomePageTest extends BaseTest
{
	
	@Test(priority=1)
	public void titleTest()
	{	
		String title = homepage.getPageTitle();
		System.out.println("--< Page Title is : " + title);
		Assert.assertEquals(title,"Your Store");
	}
	
	@Test(priority=2)
	public void logoVisibleTest()
	{
		Assert.assertTrue(homepage.isLogoVisible());
	}
	
	@Test(priority=3)
	public void myAccountDropDownVisibleTest()
	{
		Assert.assertTrue(homepage.isMyAccountDropDownVisible());
	}
	
	@Test(priority=4)
	public void clickLoginLinkTest()
	{
		loginpage = homepage.doClickLoginLink();
	}
	
	
}
