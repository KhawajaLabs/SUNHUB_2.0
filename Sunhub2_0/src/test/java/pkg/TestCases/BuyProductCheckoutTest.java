package pkg.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseclass.pages.BaseClass;
import com.buyproduct.java.buyproduct;
import com.catagorysearch.pages.Catagorysearch;
import com.signin.pages.Signin;
import com.util.pages.Utility;

public class BuyProductCheckoutTest extends BaseClass

{
	public class Product_Purchase extends BaseClass
	{
		buyproduct b;
		Catagorysearch c;
		Signin s;
	
		public Product_Purchase()
		{
			super();
		}
		
		@BeforeMethod
		public void buying() 
		{
			Initialization();
			b = new buyproduct();
			c = new Catagorysearch();
			s = new Signin();
		}

		@Test		
		public void FunctionBothCheckout() throws Exception 
		{
			s.rightUserNameAndRightPassword();			
			b.checkoutWtihServiceAsBoth();
		}
		
		@Test		
		public void errorMEssageOnNoServiceSelectionInCheckout() throws Exception 
		{
			s.rightUserNameAndRightPassword();
			c.CategoryByShoppAll();
			b.errorMessageCheckoutWtihoutService();
		}
		
		@Test		
		public void LocalPickupCheckout() throws Exception 
		{
			s.rightUserNameAndRightPassword();
			b.CheckoutWithLocalpickup();
		}
		
		@Test		
		public void FreeshippingCheckout() throws Exception 
		{
			s.rightUserNameAndRightPassword();
			b.CheckoutWithFreeshipping();
		}
		
		@Test		
		public void FedexCheckout() throws Exception 
		{
			s.rightUserNameAndRightPassword();
			b.CheckoutWithFedexWithNoShippingMethod();
		}

	}	
	
	/*@AfterMethod
	public void buying() 
	{
		driver.close();
		driver.quit();
	}*/
	
}
