package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class AccountsPageTest extends BaseTest
{
	
	@BeforeClass
	public void loginTest()
	{
		loginpage = homepage.doClickLoginLink();
		accountspage = loginpage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void titleTest()
	{	
		String title = accountspage.getPageTitle();
		System.out.println("--< Page Title is : " + title);
		Assert.assertEquals(title,"My Account");
	}
	
	@Test(priority=2)
	public void logoVisibleTest()
	{
		Assert.assertTrue(accountspage.isLogoVisible());
	}
	
	@Test(priority=3)
	public void searchTextBoxVisibleTest()
	{
		Assert.assertTrue(accountspage.isSearchTextBoxVisible());
	}
	
	@Test(priority=4)
	public void rightSideLinksTest()
	{
		List<String> rightSidelinks = accountspage.getRightSideLinks();
		System.out.println("--< Links at right side:");
		rightSidelinks.forEach(s -> System.out.println(s));
		System.out.println("--< >--");
	}
	
	public void iPhone_SearchTest()
	{
		productsearchpage = accountspage.doSearch_iPhone();
	}

}
