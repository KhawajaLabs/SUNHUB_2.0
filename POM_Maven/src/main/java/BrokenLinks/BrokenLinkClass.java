package BrokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sunhub.qa.base.BaseClass;

public class BrokenLinkClass extends BaseClass
{


	public BrokenLinkClass() throws Throwable 
	{
		super();
	}

	@SuppressWarnings("unused")
	public void FindLinkBreakage() throws InterruptedException
	{
		Thread.sleep(10000);

		String url = "";
		HttpURLConnection huc = null;
		int respCode;
		int countValid = 0;
		int countInValid = 0;


		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = links.iterator();

		while(it.hasNext())
		{

			url = it.next().getAttribute("href");

			/*if(!url.equalsIgnoreCase(prop.getProperty("BaseURL")))
			{
				System.out.println(url);
			}
			else
			{
				continue;
			}	*/		

			if(url == null)
			{
				System.out.println(url + "Nul: This URL is either not configured for anchor tag or it is empty");
				continue;
			}

			if(url.isEmpty())
			{
				System.out.println(url + " Empty: This URL is either not configured for anchor tag or it is empty");
				continue;
			}


			if(url.startsWith("tel"))
			{
				//System.out.println(url + " belongs to another domain, skipping it.");
				continue;
			}

			try 
			{
				if(url!= prop.getProperty("BaseURL1"))
				{				
					huc = (HttpURLConnection)(new URL(url).openConnection());
					huc.setRequestMethod("HEAD");
					huc.connect();
					respCode = huc.getResponseCode();			

					if(respCode >= 400)
					{
						countValid ++;
						System.out.println(url+" is a broken link");
					}
					else
					{
						countInValid ++;
						System.out.println(url+" is a valid link");
					}
				}

			}
			catch (MalformedURLException e) 
			{
				// TODO Auto-generated catch block
				//e.printStackTrace();
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}
}







