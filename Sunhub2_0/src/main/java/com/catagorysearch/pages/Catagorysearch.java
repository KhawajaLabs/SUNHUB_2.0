package com.catagorysearch.pages;

import static org.testng.Assert.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.pages.BaseClass;
import com.signin.pages.Signin;

public class Catagorysearch extends BaseClass
{
	Actions action = new Actions(driver);
	
	@FindBy(xpath = "//*[@id=\"menu-home\"]/a") 
	WebElement shopAllclick; 
	
	@FindBy(xpath = "//*[@id=\"menu-home\"]/div/div/div/div[1]/ul/li[1]/a")
	WebElement catagoryclick; 
	
	@FindBy(xpath = "//*[@id=\"main-cat-1\"]")
	WebElement filtercheckclick; 

	
	public Catagorysearch()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void CategoryByShoppAll() throws Exception
	{
		Thread.sleep(3000);
		//shopAllclick.click();
		//catagoryclick.click();	
		//Thread.sleep(4000);
		//assertTrue(filtercheckclick.isSelected(), "Checkbox is not checked. This is a failure");
		
		action.moveToElement(shopAllclick).build().perform();
		Thread.sleep(4000);
		action.moveToElement(catagoryclick).click().build().perform();
		Thread.sleep(3000);
		assertTrue(filtercheckclick.isSelected(), "Checkbox is not checked. This is a failure");
	}
}
