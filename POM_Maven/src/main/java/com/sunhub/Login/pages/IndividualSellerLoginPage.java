package com.sunhub.Login.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sunhub.qa.base.BaseClass;
import com.sunhub.qa.util.TestUtil;

public class IndividualSellerLoginPage extends BaseClass
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
	
	
	@FindBy(xpath = "//*[@id=\"login-error\"]")
	WebElement intimationMessage;
	
	
	public IndividualSellerLoginPage() throws Throwable 
	{
		PageFactory.initElements(driver, this);
	}
	

	public void ISellerValidateLogin(String un, String pwd)
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
	
	public void ValidateIntimationMessageForWrongCredentials(String un, String pwd) throws Exception
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
		Thread.sleep(2000);
		
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 10);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//*[@id=\"login-error\"]")));
		 */
		
		String content = intimationMessage.getText();
		String text = "Email Or Password Is Incorrect.";
		
		assertEquals(content, text, "Text does not match");
	}
	
	public void IntimationMessageAppearance(String un, String pwd) 
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
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login-error\"]")));
		
		assertTrue(intimationMessage.isDisplayed(), "Intimation message did not appear");

	}
}
