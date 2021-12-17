package com.buyproduct.java;

import static org.testng.Assert.*;

import java.awt.Desktop.Action;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.baseclass.pages.BaseClass;
import com.util.pages.Utility;

public class buyproduct extends BaseClass
{
	int randomNumber;
	int num;
	String serviceName = null;
	Actions action = new Actions(driver);


	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[1]/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div/div[3]/div/div[3]/div[2]/button")
	WebElement addtocartclick;

	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/header/div[2]/div/div/div[2]/div/div[3]/div/div/a/span[2]")
	WebElement carticonclick;

	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/header/div[2]/div/div/div[2]/div/div[3]/div/div/div/div[3]/a[2]/span")
	WebElement checkoutclick;

	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[1]/div[2]/div/div/div/aside/div[1]/button")
	WebElement PlaceOrder;

	@FindBy(xpath = "//*[@id=\"rw_7_input\"]/div[1]")
	WebElement serviceClick;
	@FindBy(xpath = "//*[@id=\"rw_7_input\"]/div[2]/div/div/div")
	List<WebElement> service;

	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div/div")
	WebElement errorMessageCheckForNoService;

	@FindBy(xpath = "//*[@id=\"rw_23_input\"]")
	WebElement Fedexserviceclick;

	@FindBy(xpath = "//*[@id=\"q\"]")
	WebElement searchField;

	@FindBy(xpath = "//*[@id=\"rw_11_input\"]/div[1]")
	WebElement shippingMethodDD;


	@FindBy(xpath = "//*[@id=\"rw_11_input\"]/div[1]/div/span")
	List<WebElement> shippingMethodDDOptions;

	@FindBy(xpath = "//*[@id=\"rw_12_listbox\"]/div")
	List<WebElement> shippingMethodDDOptionsFull;







	public buyproduct() 
	{
		PageFactory.initElements(driver, this);	
	}

	public void checkoutWtihServiceAsBoth() throws Exception 
	{
		Utility.ProductSearch(searchField, prop.getProperty("both"));
		Thread.sleep(2000);
		addtocartclick.click();
		Thread.sleep(2000);
		carticonclick.click();
		Thread.sleep(2000);
		checkoutclick.click();
		Thread.sleep(4000);
		serviceClick.click();
		Thread.sleep(2000);

		assertTrue(serviceClick.isDisplayed(), "service dropdown is not appearing ");
		System.out.println("Service size is : " +  service.size());
		randomNumber = Utility.rand(service.size());
		System.out.println("Random number we have is : " +  randomNumber);	

		if(randomNumber == service.size())
		{
			num = randomNumber-1;
			System.out.println("New Random number we are using is : " +  num);

			try 
			{
				for(int i=0; i<service.size() ; i++)
				{
					if(service.get(i).getText().equalsIgnoreCase(service.get(num).getText()))
					{
						service.get(i).click();
						serviceName = service.get(i).getText();
						System.out.println("Selected service by the system is : " +  serviceName);
						break;
					}
				}
			}
			catch(Exception indexoutofboundException)
			{
				throw indexoutofboundException;
			}
		}
		else
		{
			try 
			{
				for(int i=0; i<service.size() ; i++)
				{
					if(service.get(i).getText().equalsIgnoreCase(service.get(randomNumber).getText()))
					{
						service.get(i).click();
						serviceName = service.get(i).getText();
						System.out.println("Selected service by the system is : " +  serviceName);
						break;
					}
				}
			}
			catch(Exception indexoutofboundException)
			{
				throw indexoutofboundException;
			}
		}

		if(serviceName.contentEquals("Fedex"))
		{				
			assertTrue(shippingMethodDD.isDisplayed(), "Shipping Method dropdown is not appearing ");				
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			shippingMethodDD.click();	
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			int size = shippingMethodDDOptionsFull.size();	

			System.out.println("Shipping method dropdown is : " +  size);

			assertTrue(size > 1, "Shipping Method dropdown is not showing shipping options ");

			randomNumber = Utility.rand(size);			

			for(int i=0; i<shippingMethodDDOptionsFull.size() ; i++)
			{
				if(shippingMethodDDOptionsFull.get(i).getText().contentEquals(shippingMethodDDOptionsFull.get(randomNumber).getText()))
				{				
					shippingMethodDDOptionsFull.get(i).click();
					break;
				}
			}	

			Thread.sleep(2000);
			action.moveToElement(PlaceOrder);
			Thread.sleep(2000);
			PlaceOrder.click();

		}
		else
		{
			System.out.println("asdoifuoasiufioasufiouaiofuasiofuoiasudfioasudfiouasiofuioasufiosudfiosdu");
			action.moveToElement(PlaceOrder);
			Thread.sleep(2000);
			PlaceOrder.click();
		}
	}

	public void errorMessageCheckoutWtihoutService() throws Exception 
	{
		Thread.sleep(4000);
		addtocartclick.click();
		Thread.sleep(2000);
		carticonclick.click();
		Thread.sleep(2000);
		checkoutclick.click();
		Thread.sleep(4000);

		action.moveToElement(PlaceOrder);
		Thread.sleep(2000);
		PlaceOrder.click();
		Thread.sleep(2000);

		String errorMEssageText = errorMessageCheckForNoService.getText();
		System.out.println(errorMEssageText);
		assertTrue(errorMessageCheckForNoService.isDisplayed(), "Error Message did not appear");
		Thread.sleep(5000);
	}

	public void CheckoutWithLocalpickup() throws Exception 
	{
		Thread.sleep(4000);
		Utility.ProductSearch(searchField, prop.getProperty("localpickup"));		
		Thread.sleep(4000);
		addtocartclick.click();
		Thread.sleep(2000);
		carticonclick.click();
		Thread.sleep(2000);
		checkoutclick.click();
		Thread.sleep(4000);
		serviceClick.click();
		Thread.sleep(2000);		


		for(int i=0; i<=service.size() ; i++)
		{
			if(service.get(i).getText().contains("Local"))
			{				
				service.get(i).click();
				break;
			}
		}		

		Thread.sleep(2000);
		action.moveToElement(PlaceOrder);
		Thread.sleep(2000);
		PlaceOrder.click();		
	}

	public void CheckoutWithFreeshipping() throws Exception 
	{
		Thread.sleep(4000);
		Utility.ProductSearch(searchField, prop.getProperty("freeshipping"));		
		Thread.sleep(4000);
		addtocartclick.click();
		Thread.sleep(2000);
		carticonclick.click();
		Thread.sleep(2000);
		checkoutclick.click();
		Thread.sleep(4000);
		serviceClick.click();
		Thread.sleep(2000);		


		for(int i=0; i<=service.size() ; i++)
		{
			if(service.get(i).getText().contains("Free"))
			{				
				service.get(i).click();
				break;
			}
		}		

		Thread.sleep(2000);
		action.moveToElement(PlaceOrder);
		Thread.sleep(2000);
		PlaceOrder.click();		
	}

	public void CheckoutWithFedexWithNoShippingMethod() throws Exception 
	{
		Thread.sleep(4000);
		Utility.ProductSearch(searchField, prop.getProperty("fedex"));		
		Thread.sleep(4000);
		addtocartclick.click();
		Thread.sleep(2000);
		carticonclick.click();
		Thread.sleep(2000);
		checkoutclick.click();
		Thread.sleep(4000);
		serviceClick.click();
		Thread.sleep(2000);		

		for(int i=0; i<service.size() ; i++)
		{
			if(service.get(i).getText().contains("Fedex"))
			{				
				service.get(i).click();
				break;
			}
		}	

		assertTrue(shippingMethodDD.isDisplayed(), "Shipping Method dropdown is not appearing ");		
		Thread.sleep(2000);
		shippingMethodDD.click();

		int size = shippingMethodDDOptions.size();	
		assertTrue(size > 1, "Shipping Method dropdown is not showing shipping options ");

		randomNumber = Utility.rand(size);

		for(int i=0; i<shippingMethodDDOptions.size() ; i++)
		{
			if(shippingMethodDDOptions.get(i).getText().contentEquals(shippingMethodDDOptions.get(randomNumber).getText()))
			{				
				shippingMethodDDOptions.get(i).click();
				break;
			}
		}	

		Thread.sleep(2000);
		action.moveToElement(PlaceOrder);
		Thread.sleep(2000);
		PlaceOrder.click();		
	}


}





