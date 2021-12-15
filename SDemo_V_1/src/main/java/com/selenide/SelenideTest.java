package com.selenide;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

import java.awt.desktop.OpenURIEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.module.ModuleDescriptor.Opens;
import java.util.Properties;

import static com.codeborne.selenide.Condition.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.commands.ContextClick;
import com.codeborne.selenide.commands.SetValue;

public class SelenideTest 
{	

	@Test
	public void GoogleSearchTest()
	{
		open("https://www.google.com/");	
		$(By.name("q")).setValue("Bacha party Lahore").pressEnter();
		$(By.id("logo")).shouldHave(Condition.appear);		
		String header = $(By.xpath("//*[@id=\"rso\"]/div[1]/div/table/tbody/tr[3]/td[1]/div/h3/a")).getText();		
		System.out.println("Required header is : " + header);		
		assertEquals(header, "Toys", "Match Failed");		
		int s = $$(By.cssSelector(".LC20lb.MBeuO.DKV0Md")).size();		
		System.out.println("Size is : " + s);
		$$(By.cssSelector(".LC20lb.MBeuO.DKV0Md")).shouldHave(CollectionCondition.size(7));
	}	
}
