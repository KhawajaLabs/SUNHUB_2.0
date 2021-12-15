package com.sunhub.Checkout.pages;

import static org.testng.Assert.assertTrue;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.sunhub.qa.base.BaseClass;
import com.sunhub.qa.testdata.TestData;
import com.sunhub.qa.util.TestUtil;

public class GuestCheckoutFlow_PayPalNow extends BaseClass
{
	TestData td;

	//Page Factory - OR:

	@FindBy(xpath = "//*[@id=\"main-navbar\"]/div/div/div/ul/li[1]") 
	WebElement categoryClick;

	@FindBy(xpath = "*//div[2]/div/div[2]/div[3]/div/div/div/a[1]/i")
	WebElement increaseQuantity;

	@FindBy(xpath = "//*[@id=\'products\']/div[2]/div/div[2]/div[3]/div/a[1]/i")
	WebElement addToCart;

	@FindBy(xpath = "//*[@id=\'shoppingcartddmain\']/div/div/div/div[3]/div[2]") 
	WebElement viewcart;

	@FindBy(xpath = "//*[@id='content']/div/div/div[2]/a[1]") 
	WebElement gotoCheckout;


	/* ----------------- Shipping and billing information fields --------------- */

	@FindBy(xpath = "//*[@id=\"SHIPPING_FNAME\"]")
	WebElement fn;

	@FindBy(xpath = "//*[@id=\"SHIPPING_LNAME\"]")
	WebElement ln;

	@FindBy(xpath = "//*[@id=\"SIGNUP_CHECKOUT_EMAIL\"]")
	WebElement email;

	@FindBy(xpath = "//*[@id=\"SHIPPING_STREET\"]")
	WebElement address;

	@FindBy(xpath = "//*[@id=\"SHIPPING_CITY\"]")
	WebElement city;

	@FindBy(xpath = "//*[@id=\"SHIPPING_ZIP\"]")
	WebElement zip;

	@FindBy(xpath = "//*[@id=\"SHIPPING_PHONE\"]")
	WebElement phone;

	@FindBy(xpath = "//*[@id=\"billing-address\"]/div[1]/div/input")
	WebElement sameAsBilling;

	@FindBy(xpath = "//*[@id='stripe-btn']")
	WebElement stripeBtnClick;


	/*----------------------- PayPal Pay Now --------------------------*/

	@FindBy(xpath = "//*[@id=\"buttons-container\"]/div/div[1]/div/div[1]")
	WebElement payPalPayNow3;

	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement ppEmail;

	@FindBy(xpath = "//*[@id=\"btnNext\"]")
	WebElement ppnextBtn;

	@FindBy(xpath = "//*[@id=\"password\"]")
	WebElement pppassword;

	@FindBy(xpath = "//*[@id=\"keepMeLogin\"]/div[1]/label")
	WebElement PPLoginRememberMeCheckbox;

	@FindBy(xpath = "//*[@id=\"btnLogin\"]")
	WebElement PPLoginBtn;

	@FindBy(xpath = "//*[@id=\"CoachTip-61036881\"]/div/span/button")
	WebElement PPFinalBtnChildpopup1;

	@FindBy(xpath = "//*[@id=\"CoachTip-80947086\"]/div/span/button")
	WebElement PPFinalBtnChildpopup2;	

	@FindBy(xpath = "//*[@id=\"payment-submit-btn\"]")
	WebElement PPFinalBtn;


	/*---------------------------- Pay Later Functionality-----------------------------*/	

	@FindBy(xpath = "//*[@id=\'buttons-container\']/div/div/div")	                
	WebElement payPalPaylater;

	@FindBy(xpath = "//*[@id=\"pay-later\"]/div[1]/div/div/div/label/span")
	WebElement Later_pay_radio_btn;

	@FindBy(xpath = "//*[@id=\'payment-submit-btn\']")
	WebElement Later_pay_radio_btn_payNow;

	@FindBy(xpath = "//*[@id=\"svg_1\"]")
	WebElement Child_Popup_1;

	@FindBy(xpath = "//*[@id=\"payment-submit-btn\"]")
	WebElement continue_with_4_Payments;

	@FindBy(xpath = "//*[@id=\"submitButton\"]")
	WebElement Pay_with_4_Payments;

	@FindBy(xpath = "//*[@id=\'submitButton\']")
	WebElement Pay_Later_Agree_apply;	

	@FindBy(xpath = "//*[@id=\'payment-submit-btn\']")
	WebElement PPLater_final_pay;

	@FindBy(xpath = "//*[@id='submitButton']")
	WebElement Continue_Btn;	

	@FindBy(xpath = "/html/body/div[2]/div/div[3]/article/section/div[2]/div/div/div/div/footer/div/div/div/label/p")
	WebElement checkbox;

	@FindBy(xpath ="/html/body/div[2]/div/div[3]/article/section/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[1]/button")
	WebElement SelectCard;

	@FindBy(xpath = "//*[@id=\'submitButton\']")
	WebElement AgreeBtn_after_chkbox;

	@FindBy(xpath = "//*[@id=\'payment-submit-btn']")
	WebElement FinalpayBtn; 


	/************************** This is a Country drop down handling part **************************/	

	@FindBy(xpath = "//*[@id=\"form-checkout\"]/div[3]/div[1]/div/button")	
	WebElement coun;	
	@FindBy(xpath = "//*[@id=\"form-checkout\"]/div[3]/div[1]/div/div/div/ul/li")		
	java.util.List<WebElement> shipping_country;	


	/************************** This is a State drop down handling part **************************/	

	@FindBy(xpath = "//*[@id=\"form-checkout\"]/div[3]/div[2]/div/button/div/div/div")	
	WebElement shipping_StateClick1;
	/*@FindBy(xpath = "//*[@id=\"form-checkout\"]/div[3]/div[2]/div/button/div/div ")	
	WebElement shipping_StateClick2;
	@FindBy(xpath = "//*[@id=\"form-checkout\"]/div[3]/div[2]/div/button/div  ")	
	WebElement shipping_StateClick3;
	@FindBy(xpath = "//*[@id=\"form-checkout\"]/div[3]/div[2]/div/button ")	
	WebElement shipping_StateClick4;
	@FindBy(xpath = "//*[@id=\"form-checkout\"]/div[3]/div[2]/div")	
	WebElement shipping_StateClick5;*/

	@FindBy(xpath = "//*[@id=\"form-checkout\"]/div[3]/div[2]/div/div/div[2]/ul/li")		  
	java.util.List<WebElement> shipping_state_list; 	

	@FindBy(xpath = "//*[@id=\'form-checkout\']/div[3]/div[2]/div/div/div[2]/ul/li")	
	WebElement SelectedState;	

	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div[2]/div[4]/div/div[1]/div[4]/div")		  
	WebElement service;

	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div[2]/div[4]/div/div[1]/div[4]/div")		  
	WebElement selectServiceClick;

	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div[2]/div[4]/div/div[1]/div[4]/div/div/div/ul/li")		   
	java.util.List<WebElement> selectService;	

	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div[2]/div[4]/div/div[1]/div[4]/div/button/div/div/div")
	WebElement selectedService;

	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div[2]/div[4]/div/div[1]/div[6]/div/button")	
	WebElement shipbyClick;

	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div[2]/div[4]/div/div[1]/div[6]/div/div/div/ul/li")		  
	java.util.List<WebElement> shipbySelect;

	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div[2]/div[4]/div/div[1]/div[6]/div/button/div/div/div")
	WebElement selectedShipment;

	@FindBy(xpath = "//*[@id=\"stripe-btn\"]")		  
	WebElement payWithStripeBtn;

	@FindBy(xpath = "//*[@id=\"email\"]")		  
	WebElement stripeEmail;

	@FindBy(xpath = "//*[@id=\'cardNumber\']")		  
	WebElement stripeCardNo;

	@FindBy(xpath = "//*[@id=\'cardExpiry\']")		  
	WebElement stripeExpiry;

	@FindBy(xpath = "//*[@id=\'billingName\']")		  
	WebElement cardHolderName;

	@FindBy(xpath = "//*[@id=\'cardCvc\']")		  
	WebElement stripeCVC;

	/*This is a SELCT list of regions we have to implement*/
	@FindBy(xpath = "//*[@id=\'billingCountry\']")		  
	WebElement stripeRegion;

	@FindBy(xpath = "//*[@id='root']/div/div/div[2]/div/form/div[2]/div[5]/button/div[3]")		                 
	WebElement StripeFinalPayment;

	@FindBy(xpath = "//*[@id=\'content\']/div/div[1]/div[1]/h4")		  
	WebElement verifyOrderConfirmationMessagePage;

	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div[2]/div[1]/ul/li[3]")
	WebElement tax;


	String taxVerifi;
	String serviceName;
	String ExemptedStates;


	/*** Registration while guest Checkout Page Factory ***/

	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div[1]/div[1]/p/a")
	WebElement GuestSignup;

	@FindBy(xpath="//*[@id=\'SIGNUP_EMAIL\']")
	WebElement GuestEmail;

	@FindBy(xpath="//*[@id=\'SIGNUP_PASSWORD\']")
	WebElement GuestPwd;

	@FindBy(xpath="//*[@id=\'SIGNUP_CPASSWORD\']")
	WebElement GuestConfirmPwd;

	@FindBy(xpath="//*[@id=\'registerContainerProfileButtonNextFree\']")
	WebElement GuestCreateAccount;

	@FindBy(xpath = "//*[@id='success-modal-close']")	
	WebElement SuccessMessagePopup;



	//Constructor for Initializing the Page Objects
	public GuestCheckoutFlow_PayPalNow() throws Throwable
	{
		PageFactory.initElements(driver, this); 
	}

	/******************************** Pay Now ***********************************/

	public void NonExistingUserGuestPayPalNow(String fname, String lname, String eml, String add, String cty, String zp, String phn) throws InterruptedException
	{

		TestUtil.DemandHubChat();
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		categoryClick.click();
		Thread.sleep(1000);
		increaseQuantity.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);		
		addToCart.click();
		Thread.sleep(2000);
		try{viewcart.click();}catch(Exception e){}
		Thread.sleep(4000);
		gotoCheckout.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);		
		fn.sendKeys(fname);
		ln.sendKeys(lname);
		email.sendKeys(eml);
		address.sendKeys(add);
		city.sendKeys(cty);
		zip.sendKeys(zp);
		phone.sendKeys(phn);
		Thread.sleep(2000);
		coun.click();	
		Thread.sleep(2000);

		try 
		{
			for(int i=0; i<=shipping_country.size() ; i++)
			{
				if(shipping_country.get(i).getText().contains("United"))
				{
					shipping_country.get(i).click();
					break;
				}
			}
		}
		catch(Exception e)
		{

		}

		shipping_StateClick1.click();

		for(int i=0; i<=shipping_state_list.size(); i++)
		{
			System.out.println(shipping_state_list.get(i).getText());				

			if(shipping_state_list.get(i).getText().contains("Arizona")) 
			{ 
				shipping_state_list.get(i).click(); 
				break; 
			}			 
		}

		/***********************Service and Shipping Selection************************/

		Thread.sleep(1000);
		sameAsBilling.click();
		Thread.sleep(1000);

		if(selectServiceClick.isDisplayed())
		{	
			Thread.sleep(1000);
			selectServiceClick.click();
			Thread.sleep(2000);

			/* I am calling this function because I want to to select shipping method 
			 * randomly and on random base I want to run this functionality. */

			int random_Shipping_method_selection = TestUtil.randomCall(selectService.size()-1);
			System.out.println("Random generation we have is  : " + random_Shipping_method_selection);

			switch(random_Shipping_method_selection)
			{
			case 1:

				for(int i=0; i<selectService.size(); i++)
				{
					if(i == random_Shipping_method_selection)
					{
						selectService.get(i).click();						
						break;
					}					
				}

				Thread.sleep(2000);			
				shipbyClick.click();
				Thread.sleep(2000);

				int randomGeneration = TestUtil.randomCall(shipbySelect.size()-1);

				for(int i=0; i<shipbySelect.size(); i++)
				{
					if(i == randomGeneration)
					{
						shipbySelect.get(i).click();
						break;
					}
				}
				break;


			case 2:
				System.out.println("Case 2 ran because Local Pickup Only is selected as a shipping method.");

				for(int i=0; i<selectService.size(); i++)
				{
					if(i == random_Shipping_method_selection)
					{
						selectService.get(i).click();						
						break;
					}	
				}
				break;
			}
		}

		driver.switchTo().frame(0);
		Thread.sleep(1000);
		payPalPayNow3.click();	
		Thread.sleep(3000);		

		String currentWindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		java.util.Iterator<String> i = allwindows.iterator();

		while(i.hasNext())
		{
			String childwindow = i.next();
			driver.switchTo().window(childwindow);
		}

		ppEmail.sendKeys(prop.getProperty("paypalemail"));			
		ppnextBtn.click();
		Thread.sleep(1000);
		pppassword.sendKeys(prop.getProperty("paypalpwd"));
		PPLoginRememberMeCheckbox.click();
		PPLoginBtn.click();

		/************************************* Fluent Wait**********************************************/
		/*@SuppressWarnings("deprecation")
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(20, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.MILLISECONDS);			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"payment-submit-btn\"]")));*/


		/************************************* Explicit Wait**********************************************/
		try
		{
			WebDriverWait wait1 = new WebDriverWait(driver,3); 
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"CoachTip-61036881\"]/div/span/button")));
			PPFinalBtnChildpopup1.click();
		}catch(Exception e) {}

		try
		{
			WebDriverWait wait1 = new WebDriverWait(driver,3);			 
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"CoachTip-80947086\"]/div/span/button")));
			PPFinalBtnChildpopup2.click();
		}catch(Exception e) {}

		try
		{
			WebDriverWait wait2 = new WebDriverWait(driver,10);			 
			wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"payment-submit-btn\"]"))).click();
		}catch(Throwable t) 
		{
			t.toString();
		}
	}

	/* 
	 * PAY LATER
	 * A NON EXISTING USER UYS SOMETHING AS A GUEST USER through PAYPAL
	 *  
	 */
	public void NonExistingUserGuestPayPalLater(String fname, String lname, String eml, String add, String cty, String zp, String phn) throws InterruptedException
	{
		TestUtil.DemandHubChat();
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		categoryClick.click();
		Thread.sleep(1000);
		increaseQuantity.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);		
		addToCart.click();
		Thread.sleep(2000);

		try	{viewcart.click();}catch(Exception e) {}

		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		gotoCheckout.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);		
		fn.sendKeys(fname);
		ln.sendKeys(lname);
		email.sendKeys(eml);
		address.sendKeys(add);
		city.sendKeys(cty);
		zip.sendKeys(zp);
		phone.sendKeys(phn);
		Thread.sleep(2000);
		coun.click();	
		Thread.sleep(2000);

		try 
		{
			for(int i=0; i<=shipping_country.size() ; i++)
			{
				if(shipping_country.get(i).getText().contains("United"))
				{
					shipping_country.get(i).click();
					break;
				}
			}
		}
		catch(Exception e){}

		shipping_StateClick1.click();

		for(int i=0; i<=shipping_state_list.size(); i++)
		{
			System.out.println(shipping_state_list.get(i).getText());				

			if(shipping_state_list.get(i).getText().contains("Arizona")) 
			{ 
				shipping_state_list.get(i).click(); 
				break; 
			}			 
		}

		/***********************Service and Shipping Selection************************/	


		Thread.sleep(1000);
		sameAsBilling.click();


		try
		{
			if(selectServiceClick.isEnabled())
			{	
				Thread.sleep(1000);
				selectServiceClick.click();
				Thread.sleep(2000);

				/* I am calling this function because I want to to select shipping method 
				 * randomly and on random base I want to run this functionality. */

				int random_Shipping_method_selection = TestUtil.randomCall(selectService.size()-1);
				System.out.println("Random generation we have is  : " + random_Shipping_method_selection);

				switch(random_Shipping_method_selection)
				{
				case 1:

					for(int i=0; i<selectService.size(); i++)
					{
						if(i == random_Shipping_method_selection)
						{
							selectService.get(i).click();						
							break;
						}					
					}

					Thread.sleep(2000);			
					shipbyClick.click();
					Thread.sleep(2000);

					int randomGeneration = TestUtil.randomCall(shipbySelect.size()-1);

					for(int i=0; i<shipbySelect.size(); i++)
					{
						if(i == randomGeneration)
						{
							shipbySelect.get(i).click();
							break;
						}
					}
					break;


				case 2:
					System.out.println("Case 2 ran because Local Pickup Only is selected as a shipping method.");

					for(int i=0; i<selectService.size(); i++)
					{
						if(i == random_Shipping_method_selection)
						{
							selectService.get(i).click();						
							break;
						}	
					}
					break;
				}
			}
		}
		catch(Exception e)
		{

		}

		Thread.sleep(1000);
		driver.switchTo().frame(0);
		payPalPaylater.click();	
		Thread.sleep(3000);		

		String currentWindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		java.util.Iterator<String> i = allwindows.iterator();

		while(i.hasNext())
		{
			String childwindow = i.next();
			driver.switchTo().window(childwindow);
		}

		ppEmail.sendKeys(prop.getProperty("paypalemail"));			
		ppnextBtn.click();
		Thread.sleep(1000);
		pppassword.sendKeys(prop.getProperty("paypalpwd"));
		PPLoginRememberMeCheckbox.click();
		PPLoginBtn.click();

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"svg_1\"]"))).click();
			//Child_Popup_1.click();
		}
		catch(Exception e){}

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/header/div[2]/div[2]/div/span/button"))).click();
			//Child_Popup_1.click();
		}
		catch(Exception e){}

		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		Later_pay_radio_btn.click();
		Later_pay_radio_btn_payNow.click();			
		Thread.sleep(3000);		
		driver.switchTo().frame(0);
		Continue_Btn.click();
		Thread.sleep(2000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,1000)");
		Pay_Later_Agree_apply.click();
		Thread.sleep(2000);
		SelectCard.click();
		checkbox.click();
		AgreeBtn_after_chkbox.click();
		Thread.sleep(2000);		
		driver.switchTo().parentFrame();
		Thread.sleep(2000);
		JavascriptExecutor js3 = (JavascriptExecutor) driver;		
		js3.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		FinalpayBtn.click();		
	}

	/* 
	 * User registers him/herself 
	 * during a Guest Checkout
	 * 
	 */
	public void registeration_on_guest_checkout() throws InterruptedException
	{
		TestUtil.DemandHubChat();
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		categoryClick.click();
		Thread.sleep(1000);
		increaseQuantity.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);		
		addToCart.click();
		Thread.sleep(2000);
		try{viewcart.click();}catch(Exception e){}
		Thread.sleep(4000);
		gotoCheckout.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);				
		Thread.sleep(1000);
		GuestSignup.click();
		GuestEmail.sendKeys("b20@mailinator.com");
		GuestPwd.sendKeys("Kingfisher0*");
		GuestConfirmPwd.sendKeys("Kingfisher0*");
		Thread.sleep(20000);
		GuestCreateAccount.click();	
	}

	/* 
	 * An existing User goes for checkout through Stripe  
	 */
	public void ExistingUserCheckoutAfterLogin() throws InterruptedException
	{
		TestUtil.DemandHubChat();
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		categoryClick.click();
		Thread.sleep(1000);
		increaseQuantity.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);		
		addToCart.click();
		Thread.sleep(2000);
		try{viewcart.click();}catch(Exception e){}
		Thread.sleep(4000);
		gotoCheckout.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);	

		/***********************Service and Shipping Selection************************/	

		try
		{
			if(selectServiceClick.isDisplayed())
			{	
				Thread.sleep(1000);
				selectServiceClick.click();
				Thread.sleep(2000);

				/* I am calling this function because I want to to select shipping method 
				 * randomly and on random base I want to run this functionality. */

				int random_Shipping_method_selection = TestUtil.randomCall(selectService.size()-1);
				System.out.println("Random generation we have is  : " + random_Shipping_method_selection);

				switch(random_Shipping_method_selection)
				{
				case 1:

					for(int i=0; i<selectService.size(); i++)
					{
						if(i == random_Shipping_method_selection)
						{
							selectService.get(i).click();						
							break;
						}					
					}

					Thread.sleep(2000);			
					shipbyClick.click();
					Thread.sleep(2000);

					int randomGeneration = TestUtil.randomCall(shipbySelect.size()-1);

					for(int i=0; i<shipbySelect.size(); i++)
					{
						if(i == randomGeneration)
						{
							shipbySelect.get(i).click();
							break;
						}
					}
					break;


				case 2:
					System.out.println("Case 2 ran because Local Pickup Only is selected as a shipping method.");

					for(int i=0; i<selectService.size(); i++)
					{
						if(i == random_Shipping_method_selection)
						{
							selectService.get(i).click();						
							break;
						}	
					}
					break;
				}
			}
		}
		catch(Exception e)
		{

		}

		stripeBtnClick.click();
		Thread.sleep(3000);
		stripeEmail.click();
		stripeEmail.sendKeys(prop.getProperty("stripeEmail"));
		stripeCardNo.click();
		stripeCardNo.sendKeys(prop.getProperty("stripeCardno"));
		stripeExpiry.click();
		stripeExpiry.sendKeys(prop.getProperty("stripeExpiry"));
		stripeCVC.click();
		stripeCVC.sendKeys(prop.getProperty("stripeCVC"));
		cardHolderName.click();
		cardHolderName.sendKeys(prop.getProperty("stripeName"));
		stripeRegion.click();

		Select regionList = new Select(stripeRegion);
		regionList.selectByVisibleText("Pakistan");		

		StripeFinalPayment.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		assertTrue(verifyOrderConfirmationMessagePage.isDisplayed(), "Order confirmation message page did not appear");
	}


	/* 
	 * An existing User goes for checkout through Stripe as a Guest 
	 */
	public void ExistingUserCheckoutAsGuest(String fname, String lname, String eml, String add, String cty, String zp, String phn) throws InterruptedException
	{
		TestUtil.DemandHubChat();
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		categoryClick.click();
		Thread.sleep(1000);
		increaseQuantity.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);		
		addToCart.click();
		Thread.sleep(2000);
		try{viewcart.click();}catch(Exception e){}
		Thread.sleep(4000);
		gotoCheckout.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);					
		fn.sendKeys(fname);
		ln.sendKeys(lname);
		email.sendKeys(eml);
		address.sendKeys(add);
		city.sendKeys(cty);
		zip.sendKeys(zp);
		phone.sendKeys(phn);
		Thread.sleep(2000);
		coun.click();	
		Thread.sleep(2000);

		try 
		{
			for(int i=0; i<=shipping_country.size() ; i++)
			{
				if(shipping_country.get(i).getText().contains("United"))
				{
					shipping_country.get(i).click();
					break;
				}
			}
		}
		catch(Exception e){}

		shipping_StateClick1.click();

		for(int i=0; i<=shipping_state_list.size(); i++)
		{
			System.out.println(shipping_state_list.get(i).getText());				

			if(shipping_state_list.get(i).getText().contains("Arizona")) 
			{ 
				shipping_state_list.get(i).click(); 
				break; 
			}			 
		}

		/***********************Service and Shipping Selection************************/	

		Thread.sleep(1000);
		sameAsBilling.click();

		try 
		{



			if(selectServiceClick.isDisplayed())
			{	
				Thread.sleep(1000);
				selectServiceClick.click();
				Thread.sleep(2000);

				/* I am calling this function because I want to to select shipping method 
				 * randomly and on random base I want to run this functionality. */

				int random_Shipping_method_selection = TestUtil.randomCall(selectService.size()-1);
				System.out.println("Random generation we have is  : " + random_Shipping_method_selection);

				switch(random_Shipping_method_selection)
				{
				case 1:

					for(int i=0; i<selectService.size(); i++)
					{
						if(i == random_Shipping_method_selection)
						{
							selectService.get(i).click();						
							break;
						}					
					}

					Thread.sleep(2000);			
					shipbyClick.click();
					Thread.sleep(2000);

					int randomGeneration = TestUtil.randomCall(shipbySelect.size()-1);

					for(int i=0; i<shipbySelect.size(); i++)
					{
						if(i == randomGeneration)
						{
							shipbySelect.get(i).click();
							break;
						}
					}
					break;


				case 2:
					System.out.println("Case 2 ran because Local Pickup Only is selected as a shipping method.");

					for(int i=0; i<selectService.size(); i++)
					{
						if(i == random_Shipping_method_selection)
						{
							selectService.get(i).click();						
							break;
						}	
					}
					break;
				}
			}
		}
		catch(Exception e){}

		stripeBtnClick.click();
		Thread.sleep(3000);
		stripeEmail.click();
		stripeEmail.sendKeys(prop.getProperty("stripeEmail"));
		stripeCardNo.click();
		stripeCardNo.sendKeys(prop.getProperty("stripeCardno"));
		stripeExpiry.click();
		stripeExpiry.sendKeys(prop.getProperty("stripeExpiry"));
		stripeCVC.click();
		stripeCVC.sendKeys(prop.getProperty("stripeCVC"));
		cardHolderName.click();
		cardHolderName.sendKeys(prop.getProperty("stripeName"));
		stripeRegion.click();

		Select regionList = new Select(stripeRegion);
		regionList.selectByVisibleText("Pakistan");		

		StripeFinalPayment.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		assertTrue(verifyOrderConfirmationMessagePage.isDisplayed(), "Order confirmation message page did not appear");
	}




	/*
	 * TAX Calculation
	 */
	public void Tax(String fname, String lname, String eml, String add, String cty, String zp, String phn) throws InterruptedException
	{
		TestUtil.DemandHubChat();
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		categoryClick.click();
		Thread.sleep(1000);
		increaseQuantity.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);		
		addToCart.click();
		Thread.sleep(2000);
		try{viewcart.click();}catch(Exception e){}
		Thread.sleep(4000);
		gotoCheckout.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);		
		fn.sendKeys(fname);
		ln.sendKeys(lname);
		email.sendKeys(eml);
		address.sendKeys(add);
		city.sendKeys(cty);
		zip.sendKeys(zp);
		phone.sendKeys(phn);
		Thread.sleep(2000);
		coun.click();	
		Thread.sleep(2000);

		try 
		{
			for(int i=0; i<=shipping_country.size() ; i++)
			{
				if(shipping_country.get(i).getText().contains("United"))
				{
					shipping_country.get(i).click();
					break;
				}
			}
		}
		catch(Exception e)
		{

		}

		shipping_StateClick1.click();

		for(int i=0; i<=shipping_state_list.size(); i++)
		{
			System.out.println(shipping_state_list.get(i).getText());				

			if(shipping_state_list.get(i).getText().contains("Arizona")) 
			{ 
				shipping_state_list.get(i).click(); 
				break; 
			}			 
		}

		/***********************Service and Shipping Selection************************/	


		Thread.sleep(1000);
		sameAsBilling.click();
		Thread.sleep(1000);

		try
		{
			if(selectServiceClick.isDisplayed())
			{	
				Thread.sleep(1000);
				selectServiceClick.click();
				Thread.sleep(2000);

				/* I am calling this function because I want to to select shipping method 
				 * randomly and on random base I want to run this functionality. */

				int random_Shipping_method_selection = TestUtil.randomCall(selectService.size()-1);
				System.out.println("Random generation we have is  : " + random_Shipping_method_selection);

				switch(random_Shipping_method_selection)
				{
				case 1:

					for(int i=0; i<selectService.size(); i++)
					{
						if(i == random_Shipping_method_selection)
						{
							selectService.get(i).click();						
							break;
						}					
					}

					Thread.sleep(2000);			
					shipbyClick.click();
					Thread.sleep(2000);

					int randomGeneration = TestUtil.randomCall(shipbySelect.size()-1);

					for(int i=0; i<shipbySelect.size(); i++)
					{
						if(i == randomGeneration)
						{
							shipbySelect.get(i).click();
							break;
						}
					}
					break;


				case 2:
					System.out.println("Case 2 ran because Local Pickup Only is selected as a shipping method.");

					for(int i=0; i<selectService.size(); i++)
					{
						if(i == random_Shipping_method_selection)
						{
							selectService.get(i).click();						
							break;
						}	
					}
					break;
				}
			}
		}
		catch(Exception e)
		{

		}


		/*-------------------------------- Tax Verification Procedure ----------------------------------*/			

		try 
		{
			int option = 0;

			if(selectedService.getText().contentEquals(prop.getProperty("service_type_one")))
			{
				option = 1;
			}
			else if(selectedService.getText().contentEquals(prop.getProperty("service_type_two")))
			{
				option = 2;
			}

			switch(option)
			{
			case 1:
				System.out.println("This is Local Pickup. There is no TAX. :)");
				break;			

			case 2:
				System.out.println("Selected State is " + shipping_StateClick1.getText().toString());

				try 
				{
					for(int i=0; i<=TestData.ExemptedStateList.length; i++)
					{	
						if(TestData.ExemptedStateList[i].contentEquals(shipping_StateClick1.getText()))
						{
							System.out.println(TestData.ExemptedStateList[i]+ " is exempted from TAX");
							System.out.println("This is selected TAX : " + tax.getText().toString());				            
							int actualTax = TestUtil.testTax(tax.getText().toString());						            
							assertTrue(actualTax==0, "Tax is greater than ZERO. It should be Zero");      
							break;
						}
					}
				}
				catch(Exception e){}

				break;
			}	
		}
		catch(Exception e){}


		try 
		{
			/* Here we have to implement one thing that might be we have a 
			 * state that is not exempted from Tax but product has registered 
			 * against a Reseller because we do not charge any Tax from a reseller. */

			for(int i=0; i<=TestData.ExemptedStateList.length; i++)
			{	
				if(TestData.ExemptedStateList[i].contentEquals(shipping_StateClick1.getText()))
				{
					System.out.println(TestData.ExemptedStateList[i]+ " is exempted from TAX");
					System.out.println("This is selected TAX : " + tax.getText().toString());				            
					int actualTax = TestUtil.testTax(tax.getText().toString());						            
					assertTrue(actualTax==0, "Tax is greater than ZERO. It should be Zero");      
					break;
				}
			}
		}
		catch(Exception e){}
	}



}
