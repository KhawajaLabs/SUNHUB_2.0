package UtilityPackage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UtilClass 
{
	/*
	 * @Test public static void CaptureScreenShot(WebDriver driver, String test)
	 * throws Throwable { TakesScreenshot tss =(TakesScreenshot)driver;
	 * 
	 * File source = tss.getScreenshotAs(OutputType.FILE);
	 * FileUtils.copyFile(source, new File("./ScreenShots/" + test + " .png") );
	 * System.out.println("ScreenShot is taken successfully"); }
	 */

	/*
	 * @Test public void screenShot() throws IOException, InterruptedException {
	 * File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 * 
	 * String filename = new SimpleDateFormat("yyyy-MM-dd- hh.mm.ss").format(new
	 * Date()); System.out.println("This is date format we have " + filename);
	 * 
	 * File dest = new File("./Pictures/" + filename + ".png");
	 * FileUtils.copyFile(scr, dest);
	 * 
	 * }
	 */
}
