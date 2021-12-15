package com.sunhub.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.sunhub.qa.util.TestUtil;

public class BaseClass 
{
	public static WebDriver driver;
	public static Properties prop;

	//Constructor to Base Class
	public BaseClass() throws Throwable
	{
		try
		{
			String source = "E:\\Personal\\Selenium\\Eclipse_Work_Space_1\\POM_Maven\\src\\main\\java\\com\\sunhub\\qa\\config\\config.properties";
			
			prop = new Properties();
			FileInputStream fip = new FileInputStream(prop.getProperty("user.dir", source));
			prop.load(fip);			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException io) 
		{
			io.printStackTrace();
		}
	}
	
	
	public static void Initialization() throws InterruptedException, MalformedURLException 
	{
						
		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\Chrome Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", ".\\Drivers\\GECKO Driver\\geckodriver.exe"); 
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("BaseURL1"));
		
		/*
		 * Thread.sleep(4000); try { WebElement el = driver.findElement(By.xpath(
		 * "//*[@id=\"demandhub-web-chat-root\"]/div/div[4]/img[2]")); el.click();
		 * Thread.sleep(2000); el.click(); } catch(Exception e) {
		 * 
		 * }
		 */
	}
}
