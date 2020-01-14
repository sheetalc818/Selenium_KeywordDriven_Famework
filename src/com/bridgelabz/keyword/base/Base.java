package com.bridgelabz.keyword.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.bridgelabz.keyword.util.TestUtil;

public class Base 
{
	public WebDriver driver;
	public Properties properties;

	/**
	* @param browserName
	* @return driver
	*/
	public WebDriver initializeDriver(String browserName) 
	{
		if (browserName.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",
						"./driver/chromedriver");
			if (properties.getProperty("headless").equals("yes")) 
			{
				// headless mode:
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			} 
			else 
			{
					driver = new ChromeDriver();
			}
		} else if (browserName.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver",
						"./driver/geckodriver");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		return driver;
	}
	
	/**
	 * @purpose initialize properties file
	 * @return properties
	 */
	public Properties initializeProperties() 
	{
		properties = new Properties();
		try 
		{
			FileInputStream ip = new FileInputStream("/home/sheetal/eclipse-workspace/KeywordDrivenFramework/src/com/bridgelabz/keyword/config/config.propertise");
			properties.load(ip);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return properties;
	}
}
