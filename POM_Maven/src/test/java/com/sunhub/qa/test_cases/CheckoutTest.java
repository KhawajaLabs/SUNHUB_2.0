package com.sunhub.qa.test_cases;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sunhub.Checkout.pages.GuestCheckoutFlow_PayPalNow;
import com.sunhub.Login.pages.BuyerLoginPage;
import com.sunhub.qa.base.BaseClass;

public class CheckoutTest extends BaseClass 
{
	GuestCheckoutFlow_PayPalNow gcf;
	BuyerLoginPage blp;

	public CheckoutTest() throws Throwable
	{
		super();
	}

	@BeforeMethod
	public void SetUp() throws Throwable 
	{
		Initialization();  
		gcf = new GuestCheckoutFlow_PayPalNow();
		blp = new BuyerLoginPage();
	}


	/*
	 * @Test(priority = 2) public void NonExistingShopperGuestPPLNow() throws
	 * InterruptedException {
	 * gcf.NonExistingUserGuestPayPalNow(prop.getProperty("first_name"),
	 * prop.getProperty("last_name"), prop.getProperty("email"),
	 * prop.getProperty("address"), prop.getProperty("city"),
	 * prop.getProperty("zip"), prop.getProperty("phone") ); }
	 */

	@Test(priority = 1)
	public void NonExistingShopperGuestPPLLater() throws InterruptedException
	{		
		gcf.NonExistingUserGuestPayPalLater(prop.getProperty("first_name"), prop.getProperty("last_name"), prop.getProperty("email"), prop.getProperty("address"), 
				prop.getProperty("city"), prop.getProperty("zip"), prop.getProperty("phone")
				);
	}

	@Test(priority = 2)
	public void NonRegisteredUser_registeration_while_guest_checkout() throws InterruptedException
	{	
		gcf.registeration_on_guest_checkout();
	}

	@Test(priority = 3)
	public void CheckoutWithStripePayment() throws InterruptedException
	{
		blp.ValidateLogin(prop.getProperty("buyer_username"), prop.getProperty("buyer_password"));
		gcf.ExistingUserCheckoutAfterLogin(); 
	}

	@Test(priority = 4)
	public void TaxCalculation() throws InterruptedException
	{		
		gcf.Tax( prop.getProperty("first_name"), prop.getProperty("last_name"), prop.getProperty("email"), 
				prop.getProperty("address"), prop.getProperty("city"), prop.getProperty("zip"), 
				prop.getProperty("phone")
				); 
	}
	
	@Test(priority = 5)
	public void ExistingUserGuestCheckout() throws InterruptedException
	{
		gcf.ExistingUserCheckoutAsGuest(prop.getProperty("first_name"), prop.getProperty("last_name"), prop.getProperty("email"), 
				prop.getProperty("address"), prop.getProperty("city"), prop.getProperty("zip"), 
				prop.getProperty("phone")); 
	}



	/*@AfterMethod public void quit() throws Throwable 
	{ 
		driver.close();  		  
		driver.quit(); 
	}*/

}
