package com.baseclass.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass 
{
	public static WebDriver driver;
	public static Properties prop;

	public BaseClass()
	{
		String source = "./src/main/java/com/Config/pages/Config.Properties";
		try 
		{
			prop = new Properties();
			FileInputStream file = new FileInputStream(prop.getProperty("user.dir", source));
			prop.load(file);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch(IOException io) 
		{
			io.printStackTrace();
		}
	}


	public static void Initialization()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/Chrome Driver/chromedriver1.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("baseurl"));
	}
}
