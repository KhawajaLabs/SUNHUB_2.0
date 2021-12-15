package com.sunhub.qa.util;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.hpbf.model.MainContents;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.ReportStats;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.sunhub.qa.base.BaseClass;
import com.sunhub.registeration.pages.BuyerRegistration;

import net.bytebuddy.utility.RandomString;


public class TestUtil extends BaseClass
{ 
	BuyerRegistration br;
	public static String n;

	public TestUtil() throws Throwable 
	{
		super();
	}

	
	/*---------- Variables ---------*/
	public static long PageLoadtimeOut = 2;
	public static long ImplicitWait = 10;
	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ReportStats reportStats;



	public static void screenShot(WebElement capt) throws IOException, InterruptedException 
	{
		//TakesScreenshot scht = (TakesScreenshot) driver;
		//File scrr = scht.getScreenshotAs(OutputType.FILE);
		
		File scr = capt.getScreenshotAs(OutputType.FILE);
		String filename = new SimpleDateFormat("yyyy-MM-dd- hh.mm.ss").format(new Date()); 
		System.out.println("This is date format we have " + filename); 
		File dest = new File("./ScreenShots/" + filename + ".png");
		FileUtils.copyFile(scr, dest);
		System.out.println("Screenshot is taken Successfully");
	}
	
	public static File ReturningScreenShot(WebElement capt) throws IOException, InterruptedException 
	{ 
		File scr = capt.getScreenshotAs(OutputType.FILE);
		String filename = new SimpleDateFormat("yyyy-MM-dd- hh.mm.ss").format(new Date()); 
		System.out.println("This is date format we have " + filename); 
		File dest = new File("./ScreenShots/" + filename + ".png");
		FileUtils.copyFile(scr, dest);
		System.out.println("Screenshot is taken Successfully");
		return dest;
	}
	

	public static int testTax(CharSequence i)
	{
		int value=0;
		Pattern p = Pattern.compile("\\d+");
		//Pattern p = Pattern.compile("[^\\d]*[\\d]+[^\\d]+([\\d]+)");
		Matcher m = p.matcher(i);


		if (m.find()) 
		{
			System.out.println(m.group());
			value =Integer.parseInt(m.group());
		}        
		/* while(m.find()) 
        {
            System.out.println(m.group(1));

        }*/

		return value;
	}


	public static void DemandHubChat() throws InterruptedException
	{
		try 
		{
			Thread.sleep(4000);
			WebElement el = driver.findElement(By.xpath("//*[@id=\"demandhub-web-chat-root\"]/div/div[4]/img[2]"));
			el.click();
			Thread.sleep(2000);
			el.click();
		}
		catch(Exception e)
		{
			
		}
	}

	public static int randomCall(int polling)
	{
		int randomNumber = ThreadLocalRandom.current().nextInt(1,polling+1);
		//System.out.println(randomNumber);
		return randomNumber;
	}

	public static void randomCall2(int polling)
	{
		int randomNumber = ThreadLocalRandom.current().nextInt(1,polling+1);
		System.out.println(randomNumber);
		//return randomNumber;
	}
	
	public static int fileCount()
	{
		File directory=new File("./AutoIT/Document Uploading");
	    int fileCount=directory.list().length;
	    return fileCount;
	}
	
	public static void productName(String name)
	{
		n = name;
	}	
	
	public static String randomNumber()
	{
		String uuid = UUID.randomUUID().toString();		
		return uuid;
	}
	
	public static String randomNumberSpecificLengthAplhabets()
	{
		String s = RandomStringUtils.randomAlphabetic(3); 	
		return s;
	}
	
	public static String randomNumberSpecificLengthNumbersOnly()
	{
		String s = RandomStringUtils.randomAlphanumeric(10); 	
		return s;
	}
	
	
	public static String OnlySpecificString()
	{
		String c = "1234567891011121314151617181920";
		String s = RandomStringUtils.random(4, c); 	
		return s;
	}
	
	public static void uploadImage(WebElement e) throws IOException, InterruptedException
	{
		WebElement AddImage = e;
		AddImage.click();
		Runtime.getRuntime().exec("./AutoIT/Image Uploader/Select single Image.exe");
	}
	
	public static void uploadDocument(WebElement d) throws IOException, InterruptedException
	{
		WebElement AddDocument = d;
		AddDocument.click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("./AutoIT/Document Uploading/Upload document AUTOIT Script.exe");
		Thread.sleep(2000);
	}
	
	
}

