package com.sunhub.qa.testdata;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sunhub.Login.pages.BusinessSellerLoginPage;
import com.sunhub.Login.pages.BuyerLoginPage;
import com.sunhub.Login.pages.IndividualSellerLoginPage;
import com.sunhub.Login.pages.ServiceProSellerLoginPage;
import com.sunhub.qa.base.BaseClass;

public class TestData extends BaseClass
{
	
	public TestData() throws Throwable
	{
		super();
	}
	
/*
	@BeforeMethod
	public void SetUp() throws Throwable 
	{
		Initialization();  		
	} */
	
	
	public static String[] ExemptedStateList = {
			                                    "Arizona", "Colorado", "Connecticut", "Florida", "Iowa", "Maryland", 
			                                    "Massachusetts", "Washington", "Wisconsin",
			                                    "Minnesota", "New Jersey", "New Mexico", "New York", 
			                                    "Ohio", "Rhode Island", "Tennessee", "Vermont"
			                                   };
	

	/*
	@Test
	public void DemandHubChat() throws InterruptedException
	{
		Thread.sleep(4000);
		WebElement el = driver.findElement(By.xpath("//*[@id=\"demandhub-web-chat-root\"]/div/div[4]/img[2]"));
		el.click();
		Thread.sleep(2000);
		el.click();
	}*/
}
