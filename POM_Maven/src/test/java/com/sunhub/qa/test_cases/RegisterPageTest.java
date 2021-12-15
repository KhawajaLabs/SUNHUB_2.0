package com.sunhub.qa.test_cases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sunhub.qa.base.BaseClass;
import com.sunhub.registeration.pages.BuisnessSellerRegistration;
import com.sunhub.registeration.pages.BuyerRegistration;

import net.sourceforge.tess4j.TesseractException;

@SuppressWarnings("unused")
public class RegisterPageTest extends BaseClass
{	
	BuyerRegistration br;
	BuisnessSellerRegistration bs;

	public RegisterPageTest() throws Throwable
	{
		super();
	}

	@BeforeMethod
	public void setup() throws Throwable
	{
		Initialization();
		br = new BuyerRegistration();
	}

	@Test(priority=1)
	public void NonExistingEmailCheck() throws IOException, InterruptedException, TesseractException
	{
		br.NonExistingEmailRegistration();
	}

	@Test(priority=2)
	public void ExistingEmailValidationforRegisteration() throws Throwable
	{
		br.ExistingEmailRegistration();
	}

	@Test
	public void Captcha() throws IOException, InterruptedException, Throwable
	{
		br.CaptureCaptcha();
	}
	
	
	/*@AfterMethod 
	public void quit() throws Throwable 
	{ 
		Thread.sleep(5000);
		driver.close();
		driver.quit(); 
	}*/





}
