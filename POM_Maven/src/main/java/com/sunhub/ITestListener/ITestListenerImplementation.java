package com.sunhub.ITestListener;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.inject.internal.InternalFlags.IncludeStackTraceOption;
import com.sunhub.qa.util.TestUtil;

public class ITestListenerImplementation extends TestUtil implements ITestListener
{
	
	public ITestListenerImplementation() throws Throwable 
	{
		super();
	}

	public void onTestStart(ITestResult result) 
	{
		test = extent.createTest(result.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult result) 
	{
		test.log(Status.PASS, "Test Method: " +result.getMethod().getMethodName()+" is Passed");
		test.log(Status.INFO, "Test Class within a Package: " + result.getInstanceName());
	}
	
	public void onTestFailure(ITestResult result) 
	{		
		test.log(Status.INFO, "Test Class within a Package: " + result.getInstanceName());
		test.log(Status.INFO, "Test Method: " + result.getName());
		test.log(Status.INFO, "Date: " + result.getMethod().getDate());
		test.log(Status.FAIL, "Test Mehod: " +result.getMethod().getMethodName()+" is Failed");
		test.log(Status.FAIL, result.getThrowable());		
	}
	
	public void onTestSkipped(ITestResult result) 
	{
		test = extent.createTest(result.getMethod().getMethodName());
	}
	
	
	public void onStart(ITestContext context)
	{
		ExtentReportSetup.ExtentReportSettings();
	}
	
	public void onFinish(ITestContext context) 
	{
		reportStats = extent.getStats();
		extent.flush();		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}
	
	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
	}
	
}
