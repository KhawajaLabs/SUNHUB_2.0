package com.sunhub.qa.test_cases;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sunhub.Login.pages.BusinessSellerLoginPage;
import com.sunhub.Login.pages.BuyerLoginPage;
import com.sunhub.Login.pages.IndividualSellerLoginPage;
import com.sunhub.Login.pages.ServiceProSellerLoginPage;
import com.sunhub.qa.base.BaseClass;
import com.sunhub.qa.util.TestUtil;

public class LoginPageTest extends BaseClass
{
	BuyerLoginPage BLPage;
	BusinessSellerLoginPage BSLPage;
	IndividualSellerLoginPage ISPage;
	ServiceProSellerLoginPage srvcpro;


	public LoginPageTest() throws Throwable 
	{ 
		super(); 
	}


	@BeforeMethod
	public void SetUp() throws Throwable 
	{
		Initialization();  
		BLPage = new BuyerLoginPage();
		BSLPage= new BusinessSellerLoginPage();
		ISPage = new IndividualSellerLoginPage();
		srvcpro = new ServiceProSellerLoginPage();
	}  


	@Test(priority=1)
	public void BuyerLogin() throws InterruptedException 
	{
		BLPage.ValidateLogin(prop.getProperty("business_username"), prop.getProperty("buyer_password")); 
	}	 

	@Test(priority=2)
	public void BsuinessLogin() 
	{
		BSLPage.BSellerValidateLogin(prop.getProperty("business_username"), prop.getProperty("buyer_password"));
	}  

	@Test(priority=3)
	public void ISellerLogin() 
	{	  
		ISPage.ISellerValidateLogin(prop.getProperty("individual_username"), prop.getProperty("individual_password"));
	}

	@Test(priority=4)
	public void SPSellerValidateLogin() 
	{	  
		srvcpro.SPSellerValidateLogin(prop.getProperty("servicepro_username"), prop.getProperty("servicepro_password"));
	}    

	@Test(priority=5)
	public void GeneralValidEmailWrongPasswordVerification() throws Exception 
	{	  
		ISPage.ValidateIntimationMessageForWrongCredentials(prop.getProperty("correcet_un"), prop.getProperty("wrong_pwd"));
	}

	@Test(priority=6)
	public void MessageAppearance()
	{
		ISPage.IntimationMessageAppearance(prop.getProperty("correcet_un"), prop.getProperty("wrong_pwd"));
	}




	@AfterMethod public void quit() throws Throwable 
	{ 
		driver.close();
		driver.quit(); 
	}


}
