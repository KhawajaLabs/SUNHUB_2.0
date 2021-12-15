package pkg.TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseclass.pages.BaseClass;
import com.signin.pages.Signin;

public class signinTest extends BaseClass
{
	Signin Sobj; 

	public signinTest()
	{
		super();
	}

	@BeforeMethod
	public  void setup()
	{
		Initialization();
		Sobj= new Signin();
	}

	@Test
	public void Signin1() throws Exception
	{		
		Sobj.rightUserNameAndRightPassword();
	}

	@Test
	public void Signin2() throws Exception
	{		
		Sobj.rightUserNameAndWrongPassword();
	}

	@Test
	public void Signin3() throws Exception
	{		
		Sobj.wrongUserNameAndWrongPassword();
	}


	@Test
	public void Signin4() throws Exception
	{		
		Sobj.wrongUserNameAndWrightPassword();
	}
}


