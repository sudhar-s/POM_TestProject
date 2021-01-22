package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest
{
	@BeforeClass
	public void clickLoginLinkTest()
	{
		loginpage = homepage.doClickLoginLink();	
	}
	
	@Test(priority=1)
	public void titleTest()
	{	
		String title = loginpage.getPageTitle();
		System.out.println("--< Page Title is : " + title);
		Assert.assertEquals(title,"Account Login");
	}
	
	@Test(priority=2)
	public void rightSideLinksTest()
	{
		List<String> rightSideLinks = loginpage.getRightSideLinks();
		System.out.println("--< Links at right side:");
		rightSideLinks.forEach(s -> System.out.println(s));
		System.out.println("--< >--");
	}
	
	@Test(priority=3)
	public void continueButtonExistTest()
	{
		Assert.assertTrue(loginpage.isContinueButtonExist());
	}
	
	@Test(priority=4)
	public void loginTest()
	{
		accountspage = loginpage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

}
