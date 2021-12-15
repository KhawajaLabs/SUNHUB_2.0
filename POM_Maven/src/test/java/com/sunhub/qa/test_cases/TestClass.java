package com.sunhub.qa.test_cases;


import org.testng.annotations.Test;

import com.sunhub.qa.util.TestUtil;

import TestPackage.TestClassPage;

public class TestClass 
{
	TestClassPage TCP = new TestClassPage();


	@Test
	public void TestingPurpose()
	{
		TCP.fileCount();
	}

	@Test
	public void LongRandomName()
	{
		String n = TestUtil.randomNumber();
		System.out.println("This is random generated Number " + n); 
	}

	@Test
	public void randomNumberSpecificLengthOnlyAphabets()
	{
		String n = TestUtil.randomNumberSpecificLengthAplhabets();
		System.out.println("This is the specific length random generated word : " + n); 
	}		

	@Test
	public void randomNumberSpecificLengthOnlyNumbers()
	{
		String n = TestUtil.randomNumberSpecificLengthNumbersOnly();
		System.out.println("This is the specific length random generated Alpha Number : " + n); 
	}	

	@Test
	public void randomNumberAlphabetsWithSpecificString()
	{		
	    String n = TestUtil.OnlySpecificString();
		System.out.println("This is the specific length random generated Alphabets : " + n); 
	}   	
	
	@Test
	public void rand()
	{		
		int randomUpload = TestUtil.randomCall(2); 
		System.out.println(randomUpload);
	}   
	
}
