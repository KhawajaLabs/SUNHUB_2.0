package com.sunhub.MyListing.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sunhub.AddProduct.pages.AddProduct;
import com.sunhub.qa.base.BaseClass;

public class MyListing extends BaseClass
{	
	
	@FindBy(xpath = "//*[@id=\'product-search\']")
	static 	WebElement SearchbarListing;
	
	@FindBy(xpath = "//*[@id=\'activity-listings-table\']/tbody/tr/td")
	static WebElement errorMessage;
	
	
	public MyListing() throws Throwable 
	{
		PageFactory.initElements(driver, this);
	}	
		
	public static void verifyProduct(String name)
	{
		SearchbarListing.sendKeys(name);
	}
}
