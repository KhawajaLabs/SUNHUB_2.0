package com.signin.pages;

import static org.testng.Assert.*;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.pages.BaseClass;

public class Signin extends BaseClass
{
	//page factory methods


	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/header/div[2]/div/div/div[2]/div/div[3]/div/a[1]/span")
	WebElement signinclick;

	@FindBy(xpath = "//*[@name=\"email\"]")	
	WebElement emailinputclick;	

	@FindBy(xpath = "//*[@name=\"email\"]")
	WebElement emailtext;	

	@FindBy(xpath = "//*[@name=\"password\"]")	
	WebElement pswdinputClick;

	@FindBy(xpath = "//*[@name=\"password\"]")	
	WebElement pswdinput;

	@FindBy(xpath = "//*[@class=\"btn btn-outline-primary-2\"]")
	WebElement loginbuttonclick;


	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[4]/div")
	WebElement errormsg;
	
	@FindBy(xpath = "//*[@id=\"react-tabs-39\"]/form/div[1]/input")
	WebElement TTerrormsg;

	//*[@id="react-tabs-39"]/form/div[1]/input



	public Signin()
	{
		PageFactory.initElements(driver, this);
	}

	public void rightUserNameAndRightPassword() throws Exception
	{
		Thread.sleep(6000);
		signinclick.click();
		Thread.sleep(5000);
		emailinputclick.click();
		Thread.sleep(1000);
		emailtext.sendKeys(prop.getProperty("username"));
		pswdinputClick.click();
		pswdinput.sendKeys(prop.getProperty("pswd"));
		Thread.sleep(1000);
		loginbuttonclick.click();
	}

	public void rightUserNameAndWrongPassword() throws Exception
	{
		Thread.sleep(5000);
		signinclick.click();
		emailinputclick.click();
		emailtext.sendKeys(prop.getProperty("username"));
		pswdinputClick.click();
		pswdinput.sendKeys(prop.getProperty("wrongpswd"));
		loginbuttonclick.click();
		Thread.sleep(2000);
		assertTrue(errormsg.isDisplayed(), "Error message is not displayed");
	}

	public void wrongUserNameAndWrongPassword() throws Exception
	{
		Thread.sleep(5000);
		signinclick.click();
		Thread.sleep(5000);
		emailinputclick.click();
		emailtext.sendKeys(prop.getProperty("wrongusername"));
		pswdinputClick.click();
		pswdinput.sendKeys(prop.getProperty("wrongpswd"));
		loginbuttonclick.click();
		Thread.sleep(2000);
	}


	public void wrongUserNameAndWrightPassword() throws Exception
	{
		Thread.sleep(5000);
		signinclick.click();
		emailinputclick.click();
		emailtext.sendKeys(prop.getProperty("wrongusername"));
		pswdinputClick.click();
		pswdinput.sendKeys(prop.getProperty("pswd"));
		loginbuttonclick.click();	
		assertTrue(errormsg.isDisplayed(), "Error message is not displayed");
	}





}










