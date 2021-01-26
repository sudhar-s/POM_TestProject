package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.ProductSearchPage;
import com.qa.opencart.pages.RegisterPage;

public class BaseTest
{
	public DriverFactory df;
	public Properties prop;
	public WebDriver driver;
	public HomePage homepage;
	public LoginPage loginpage;
	public AccountsPage accountspage;
	public RegisterPage registerpage;
	public ProductSearchPage productsearchpage;
	public ProductInfoPage productinfopage;
	
	@BeforeClass
	public void setUp()
	{
		df = new DriverFactory();
		prop = df.init_prop();
		String browserName = prop.getProperty("browser"); 
		driver = df.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		
		homepage = new HomePage(driver);
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	

}
