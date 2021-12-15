package GridTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridImplementation {

	public static void main(String[] args) throws MalformedURLException 
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
		
		ChromeOptions options = new ChromeOptions();
		options.merge(dc);
		
		String hubURL = "http://192.168.0.151:4444/wd/hub";
		WebDriver driver = new RemoteWebDriver(new URL(hubURL), options);
		
		driver.get("http://www.google.com");
		System.out.println("page title is : " + driver.getTitle());
		
		driver.quit();
		
	}
}
