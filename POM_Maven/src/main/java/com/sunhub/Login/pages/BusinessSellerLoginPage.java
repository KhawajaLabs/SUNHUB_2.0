package com.sunhub.Login.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sunhub.qa.base.BaseClass;
import com.sunhub.qa.util.TestUtil;

public class BusinessSellerLoginPage extends BaseClass
{
	
	//Page Factory - OR:
	
		@FindBy(xpath = "//*[@id=\"navbarDropdownMenuLink\"]") 
		WebElement ShowsigninMenu;
		
		@FindBy(xpath = "//*[@id=\"login-dd\"]/div/div/div[1]/div/button[2]")
		WebElement siginClick;
		
		@FindBy(xpath = "//*[@id=\"login-form\"]/div[1]/input")
		WebElement emailInputClick;
		
		@FindBy(xpath = "//*[@id=\"login-form\"]/div[1]/input") 
		WebElement emailInput;
		
		@FindBy(xpath = "//*[@id=\"login-form\"]/div[2]/input") 
		WebElement PWDInputClick;
		
		@FindBy(xpath = "//*[@id=\"login-form\"]/div[2]/input")
		WebElement PWDInput;
		
		@FindBy(xpath = "//*[@id=\"signin\"]")
		WebElement SignInBtnClick;
		
		public  BusinessSellerLoginPage() throws Throwable 
		{
			PageFactory.initElements(driver, this);
		}
		
		@SuppressWarnings("deprecation")
		public void BSellerValidateLogin(String un, String pwd)
		{
			ShowsigninMenu.click();
			driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
			siginClick.click();
			driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
			emailInputClick.click();
			driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
			emailInput.sendKeys(un);
			driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
			PWDInputClick.click();
			driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
			PWDInput.sendKeys(pwd);
			driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
			SignInBtnClick.click();	
		}
}
