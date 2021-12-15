package com.sunhub.registeration.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.xpath.XPath;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.asprise.ocr.Ocr;
import com.google.inject.Key;
import com.sunhub.qa.base.BaseClass;
import com.sunhub.qa.util.TestUtil;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import java.net.HttpURLConnection;

public class BuyerRegistration extends BaseClass
{
	File f;
	WebElement e;

	public BuyerRegistration() throws Throwable 
	{
		PageFactory.initElements(driver, this);
	}

	//Page Factory - OR:

	@FindBy(xpath = "//*[@id=\"navbarDropdownMenuLink\"]") 
	WebElement ShowsigninMenu;

	@FindBy(xpath = "//*[@id=\"login-dd\"]/div/div/div[1]/div/button[1]") 
	WebElement registerButton;

	@FindBy(xpath = "//*[@id=\"SIGNUP_EMAIL\"]") 
	WebElement emailField;

	@FindBy(xpath = "//*[@id=\"SIGNUP_PASSWORD\"]") 
	WebElement pwdField;

	@FindBy(xpath = "//*[@id=\"SIGNUP_CPASSWORD\"]") 
	WebElement pwdCnfrmField;

	@FindBy(xpath = "//*[@id=\"signup-modal-captcha\"]") 
	WebElement captcha;
	
	@FindBy(xpath = "//*[@id=\"captcha_signup\"]") 
	WebElement captchaInput;
	
	
	@FindBy(xpath = "//*[@id=\"registersignin\"]/div/div/div") 
	WebElement ErrorShot;
	

	@FindBy(xpath = "//*[@id=\"registerContainerProfileButtonNextFree\"]")
	WebElement createAccountBtn;

	@FindBy(xpath = "//*[@id=\"successfulregister\"]/div/div")
	WebElement successMessage;

	@FindBy(id = "email-error")
	WebElement ErrorMessage;

	@FindBy(xpath = "//*[@id=\"addOverlay\"]")
	WebElement maili;

	@FindBy(xpath = "//*[@id=\"success-modal-close\"]")
	WebElement okBtn;
	

	public void NonExistingEmailRegistration() throws IOException, InterruptedException, TesseractException
	{		
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		ShowsigninMenu.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		registerButton.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		emailField.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		emailField.sendKeys(prop.getProperty("buyer_reqgister_email"));
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		pwdField.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		pwdField.sendKeys(prop.getProperty("buyer_reqgister_pwd"));
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		pwdCnfrmField.click();
		pwdCnfrmField.sendKeys(prop.getProperty("buyer_reqgister_pwd"));
		Thread.sleep(15000);				
		createAccountBtn.click();	
	}

	public void ExistingEmailRegistration() throws InterruptedException, Throwable
	{
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		ShowsigninMenu.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		registerButton.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		emailField.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		emailField.sendKeys(prop.getProperty("buyer_reqgister_email"));
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		pwdField.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		pwdField.sendKeys(prop.getProperty("buyer_reqgister_pwd"));
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		pwdCnfrmField.click();
		pwdCnfrmField.sendKeys(prop.getProperty("buyer_reqgister_pwd"));
		Thread.sleep(1000);	
		captchaInput.click();
		Thread.sleep(10000);
		createAccountBtn.click();	
		Thread.sleep(2000);
		assertTrue(ErrorMessage.isDisplayed(), "Did not display Error Message");		      
	}
		
	public void CaptureCaptcha() throws IOException, InterruptedException, TesseractException 
	{
	    driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		ShowsigninMenu.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		registerButton.click();
		Thread.sleep(3000);		
		File obtainedImage = TestUtil.ReturningScreenShot(captcha);
		Thread.sleep(3000);	
	    ITesseract instance = new Tesseract();
		String imageText = instance.doOCR(obtainedImage);
		System.out.println("Result is : " + imageText);		
	}

}
