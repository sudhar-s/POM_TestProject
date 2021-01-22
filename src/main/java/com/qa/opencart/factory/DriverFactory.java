package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author sudhar
 *
 */

public class DriverFactory
{
	Properties prop;
	WebDriver driver;
	public static String highlight;
		
	/**
	 * This method is used to initialize the properties from config file
	 * @return Returns object of Properties class to load the config file and read the properties(values of key&pair)
	 */
	public Properties init_prop()
	{
		prop = new Properties();
		
		try
		{
			FileInputStream fis = new FileInputStream("E://Sel//eclipse2//eclipse//POM_Practice//src//test//resources//config//config.properties");
			prop.load(fis);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return prop;
	}
	
	
	/**
	 * This method is used to initialize the webdriver based on the given browser name
	 * @param browserName
	 * @return Returns the driver
	 */
	public WebDriver init_driver(String browserName)
	{
		System.out.println("Browser is : " + browserName);
		highlight = prop.getProperty("highlight"); 
		
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Please enter a valid Browser!!");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;
		
	}

}
