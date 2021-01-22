package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.ProductSearchPage;
import com.qa.opencart.pages.RegisterPage;

public class BaseTest
{
	DriverFactory df;
	public Properties prop;
	WebDriver driver;
	public HomePage homepage;
	public LoginPage loginpage;
	public AccountsPage accountspage;
	public RegisterPage registerpage;
	public ProductSearchPage productsearchpage;
	public ProductInfoPage productinfopage;
	
	@BeforeTest
	public void setUp()
	{
		df = new DriverFactory();
		prop = df.init_prop();
		String browserName = prop.getProperty("browser"); 
		driver = df.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		
		homepage = new HomePage(driver);
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	

}
