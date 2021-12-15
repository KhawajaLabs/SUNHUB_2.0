package com.sunhub.qa.test_cases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sunhub.AddProduct.pages.AddProduct;
import com.sunhub.Login.pages.BuyerLoginPage;
import com.sunhub.qa.base.BaseClass;

public  class AddProductTest extends BaseClass
{
	AddProduct ap;
	BuyerLoginPage blp;
	MyListingTest mt;

	public AddProductTest() throws Throwable
	{
		super();
	}

	@BeforeMethod
	public void SetUp() throws Throwable
	{
		Initialization();
		ap = new AddProduct();
		blp = new BuyerLoginPage();
		mt = new MyListingTest();
	}
	
	@Test(priority = 1, groups = "smoke")
	public void AddProduct() throws Throwable
	{
		int chk = 1;
		blp.ValidateLogin(prop.getProperty("business_username"), prop.getProperty("business_password"));
	    ap.AddProductInSystem(prop.getProperty("startingPrice"), prop.getProperty("DiscountedPrice"), chk);
	}	
	
	@Test(priority = 2,groups = "smoke")
	public void existingBrandVerification() throws Exception
	{
		blp.ValidateLogin(prop.getProperty("business_username"), prop.getProperty("business_password"));
		ap.VerifiedExistingManufacturer();
	}
	
	@Test(priority = 3, groups = "smoke")
	public void AgeAndConditionCheck() throws Exception
	{
		blp.ValidateLogin(prop.getProperty("business_username"), prop.getProperty("business_password"));
		ap.CheckAgeAndNewconditionMatch();
	}
	
	@Test(priority = 4)
	public void VerificationOfAddedManufacturer() throws Exception
	{
		blp.ValidateLogin(prop.getProperty("business_username"), prop.getProperty("business_password"));
		ap.VerifyAddedManufacturer();
	}	
	
	@Test(priority = 5)
	public void verifyDiscountedPrice() throws Exception
	{
		int chk = 0;
		blp.ValidateLogin(prop.getProperty("business_username"), prop.getProperty("business_password"));
		ap.AddProductInSystem(prop.getProperty("startingPrice"), prop.getProperty("discountedPriceGreaterThanStartingprice"), chk);
	}	
	
	@Test(priority = 6)
	public void ImageDeletionCheck() throws InterruptedException, IOException, AWTException
	{
		blp.ValidateLogin(prop.getProperty("business_username"), prop.getProperty("business_password"));
		ap.ImagedeletionCheck();
	}
	
	@Test(priority = 7)
	public void DocumentDeletionCheck() throws InterruptedException, IOException
	{
		blp.ValidateLogin(prop.getProperty("business_username"), prop.getProperty("business_password"));
		ap.DocumentDeletionCheck();
	}	
}

