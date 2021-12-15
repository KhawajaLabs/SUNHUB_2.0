package com.sunhub.qa.test_cases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sunhub.qa.base.BaseClass;
import com.sunhub.registeration.pages.BuyerRegistration;

import BrokenLinks.BrokenLinkClass;

public class TestBrokenLinksTest extends BaseClass 
{
	BrokenLinkClass brClass;

	public TestBrokenLinksTest() throws Throwable 
	{
		super();
	}

	
	@BeforeMethod
	public void setup() throws Throwable
	{
		Initialization();
		brClass = new BrokenLinkClass();
	}
	
	@Test
	public void FindBrokenLinks() throws InterruptedException 
	{
		brClass.FindLinkBreakage();
	}
	
}
