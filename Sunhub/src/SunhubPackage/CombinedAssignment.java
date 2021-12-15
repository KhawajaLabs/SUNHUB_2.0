package SunhubPackage;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import UtilityPackage.UtilClass;

public class CombinedAssignment 
{
	String baseURL = "https://beta.sunhub.com/";
	String path = ".\\Drivers\\Chrome Driver\\chromedriver.exe";  	 
	ChromeDriver driver;

	@BeforeTest
	public void Generic() throws Throwable 
	{		
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get(baseURL);		  
	}


	//***************** Function Includes Assignment No 1 ******************//	  

	@Test
	public void Login() throws Throwable 
	{	  
		driver.manage().window().maximize();

		driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[3]/ul/li[2]/div/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"login-dd\"]/div/div/div/div[1]/button[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[1]/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[1]/input")).sendKeys("nicemoments.01@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[2]/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[2]/input")).sendKeys("Kingfisher08*");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"cookieModal\"]/div/div/div/div/div/a[4]")).click();
		Thread.sleep(2000);  
		driver.findElement(By.xpath("//*[@id=\"signin\"]")).click();
		
		Thread.sleep(2000);  
		/*
		  String PageTitle = driver.getTitle();
		  String ExpectedTitle = "This is an Automation Test";
		  System.out.println("Title for this page is " + PageTitle);

		  try
		  {
		  Assert.assertEquals(PageTitle, ExpectedTitle);
		  }
		  catch(Exception e) 
		  {
			System.out.println(e.getMessage()); 
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		  }*/
		
		
		String ExpectedErrorMessage = "Email Or Password Is Incorrect.";
		String ActualErrorMessage = driver.findElement(By.xpath("//*[@id=\"login-error\"]")).getText();
		
		
	//******************************************** Get Current Date *************************************************	
		/*
		//Create an Abstract class to get time current date time with Date()
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");	
		 //Get current date time
		 Date date = new Date();		 
		 // Now format the date
		 String date1= dateFormat.format(date);		 
		 // Print the Date
		 System.out.println("This is date we have " + date1);	
		*/
		 LocalDateTime now = LocalDateTime.now();
		 int year = now.getYear();
		 String y = Integer.toString(year);
		 int month = now.getMonthValue();
		 String m = Integer.toString(month);
		 int day = now.getDayOfMonth();
		 String d = Integer.toString(day);
		 int hour = now.getHour();
		 String h = Integer.toString(hour);
		 int minute = now.getMinute();
		 String min = Integer.toString(minute);
		 int second = now.getSecond();
		 String sec = Integer.toString(second);
		 
		 // Now create a time to pass
		 
		String datetime = (m + "-" + d + "-" + y + " " + h + "_" + min + "_" + sec);
		 System.out.println("This is date time "  + datetime);
		 
		if(ExpectedErrorMessage.equalsIgnoreCase(ActualErrorMessage))
		{
			//System.out.println("Actual Error Message is " + ActualErrorMessage);
			//System.out.println("Expected Error Message is " + ExpectedErrorMessage);
			
			
			//Now we will pass this date time as a parameter to not override the images 
			//UtilClass.CaptureScreenShot(driver, datetime);
			TakesScreenshot tss =(TakesScreenshot)driver;		
			
			File source = tss.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./ScreenShots/" + datetime + " .png") );
			System.out.println("ScreenShot is taken successfully");
		}
	
	}

	
	
	 




//***************** Function Includes Assignment No 2 ******************//	    

@Test
public void Waits() throws Throwable 
{	 
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@id=\"v-pills-seller-dropdown-expander\"]")).click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@id=\"v-pills-listings-tab\"]")).click();	
	driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);	    
}


@AfterTest
public void Closing()
{
	driver.close();
	driver.quit();
}

}
