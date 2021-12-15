package com.sunhub.ITestListener;


import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sunhub.qa.util.TestUtil;

public class ExtentReportSetup extends TestUtil
{
	public ExtentReportSetup() throws Throwable 
	{
		super();
	}

	public static void ExtentReportSettings()
	{
		//Get Current Date to pass it for every new date
		
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyy hh-mm-ss");
		String dt = df.format(date);		
		String reportPath = "./Reports" + "/Report_" +dt+".html";  //"/Reports/Report_" +dt+".html";	
		
		spark = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();
		extent.attachReporter(TestUtil.spark);
		
		spark.config().setDocumentTitle("SUNHUB V 1.0 Report");
		spark.config().setReportName("SUNHUB V 1.0 Test Report");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setTimeStampFormat(dt);
		
		extent.setSystemInfo("Executed in Environment: ", prop.getProperty("BaseURL"));
		extent.setSystemInfo("Executed in Browser: ", prop.getProperty("browser")); 
		extent.setSystemInfo("Browser Version: ", System.getProperty("browser.version")); 
		extent.setSystemInfo("Executed in OS: ", System.getProperty("os.name"));
		extent.setSystemInfo("Executed by User: ", "Khawaja Muhammad Ali");		
	}
}
