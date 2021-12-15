package pkg.TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseclass.pages.BaseClass;
import com.catagorysearch.pages.Catagorysearch;
import com.signin.pages.Signin;

public class CategorySearchVerificationTest extends BaseClass
{
	Catagorysearch c;
	Signin s;
	
	public CategorySearchVerificationTest()
	{
		super();
	}

	@BeforeMethod
	public  void setup()
	{
		Initialization();
		c= new Catagorysearch();
		s= new Signin();
	}
	
	@Test
	public void Signin1() throws Exception
	{		
		s.rightUserNameAndRightPassword();
		Thread.sleep(3000);
		c.CategoryByShoppAll();
	}
}
