package com.util.pages;

import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.baseclass.pages.BaseClass;

public class Utility extends BaseClass 
{
	public static int rand(int s)
	{
		int randomNum = 0;
		for(int i=1; i<s ; i++)
		{
			randomNum = ThreadLocalRandom.current().nextInt(1, s+1);
			//System.out.println(randomNum);
		}

		return randomNum;
	}


	public static void ProductSearch(WebElement e, String s) throws Exception
	{
		Thread.sleep(3000);
		e.sendKeys(s, Keys.RETURN);
		Thread.sleep(3000);
	}



}
