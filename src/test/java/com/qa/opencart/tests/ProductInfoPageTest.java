package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductInfoPageTest extends BaseTest
{
	@BeforeClass
	public void loginTest()
	{
		loginpage = homepage.doClickLoginLink();
		accountspage = loginpage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
		productsearchpage = accountspage.doSearch_iPhone();
		productinfopage = productsearchpage.doClickProduct();
	}
	
	@Test
	public void titleTest()
	{
		String title = productinfopage.getPageTitle();
		System.out.println("--< Page Title is : " + title);
		Assert.assertEquals(title, "iPhone");
	}
	
	@Test
	public void productImagesTest()
	{
		int NoOfImages = productinfopage.getProductImages();
		System.out.println("--< Total number of images for the product is : " +NoOfImages);
		Assert.assertEquals(NoOfImages, 6);
	}
	
	@Test
	public void productInformationTest()
	{
		Map<String, String> productInfo = productinfopage.getProductInformation();
		System.out.println("--< Product Information:");
		productInfo.forEach((key, value) -> System.out.println(key + "   :   " + value));
	}
	

}
