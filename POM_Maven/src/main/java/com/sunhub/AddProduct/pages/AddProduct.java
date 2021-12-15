package com.sunhub.AddProduct.pages;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.batik.css.engine.value.svg.BaselineShiftManager;
import org.apache.commons.math3.stat.inference.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.internal.MouseAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Factory;

import com.google.inject.Key;
import com.lowagie.text.Utilities;
import com.sunhub.MyListing.pages.MyListing;
import com.sunhub.qa.base.BaseClass;
import com.sunhub.qa.util.TestUtil;

public class AddProduct extends BaseClass
{
	MyListing ml = new MyListing();

	/*-----------------------------------------------------------------
	 * -----------  Steps to Add a Product in to the system -----------	
	 *-----------------------------------------------------------------
	 * 1- A seller will log in to the system 
	 * 2- A seller will clicks on his/her name and select My Seller Central option
	 * 3- A seller then will click on an option named Sell an Item in the left pane 
	 */

	@FindBy(xpath = "//*[@id='login-dd']")
	static WebElement welcome_name_click;

	@FindBy(xpath = "//*[@id=\'login-dd\']/div/div/div[1]/ul/li[2]")
	static WebElement my_seller_central_click;

	@FindBy(xpath = "//*[@id=\'v-pills-seller-dropdown\']/li[2]")
	static WebElement sell_an_item_click;

	/*---*** Category selection ***---*/
	@FindBy(xpath = "//*[@id=\'NEW_ADD_PRODUCT_FORM\']/div[2]/div[1]/div[1]/div[2]/div/div[1]/div")
	static WebElement product_category_click;

	@FindBy(xpath = "//*[@id=\"NEW_ADD_PRODUCT_FORM\"]/div[2]/div[1]/div[1]/div[2]/div/div[1]/div/div/div/ul/li")
	static List<WebElement> product_category_selction;

	/*---*** Sub-category selection ***---*/
	@FindBy(xpath = "//*[@id=\'SI_SUB_CAT_DIV\']/div")	
	static WebElement sub_category_click;

	@FindBy(xpath = "//*[@id=\'SI_SUB_CAT_DIV\']/div/div/div/ul/li")
	static List<WebElement> sub_category_selection;

	/*---*** Age selection ***---*/
	@FindBy(xpath = "//*[@id=\'NEW_ADD_PRODUCT_FORM\']/div[2]/div[2]/div[1]/div[2]/div[1]/div")
	static WebElement age_dd_click;

	@FindBy(xpath = "//*[@id=\'NEW_ADD_PRODUCT_FORM\']/div[2]/div[2]/div[1]/div[2]/div[1]/div/div/div/ul/li")
	static List<WebElement> age_selection;

	/*---*** Condition selection ***---*/
	@FindBy(xpath = "//*[@id=\'NEW_ADD_PRODUCT_FORM\']/div[2]/div[2]/div[1]/div[2]/div[2]/div")
	static WebElement condition_click;

	@FindBy(xpath = "//*[@id=\'NEW_ADD_PRODUCT_FORM\']/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div/ul/li")
	static List<WebElement> condition_selection;


	/*---*** Weight Label ***---*/
	@FindBy(xpath = "//*[@id=\"NEW_ADD_PRODUCT_FORM\"]/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div/div/button")
	static WebElement weightGuage_click;

	@FindBy(xpath = "//*[@id=\'NEW_ADD_PRODUCT_FORM\']/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div/div/div/div/ul/li")
	static List<WebElement> weightGuage_selection;

	@FindBy(xpath = "//*[@id=\'SIF_weightt\']")
	static WebElement weightField;


	/*---*** Length Label ***---*/
	@FindBy(xpath = "//*[@id=\"NEW_ADD_PRODUCT_FORM\"]/div[2]/div[2]/div[1]/div[3]/div[2]/div/div/div/div/button")
	static WebElement lengthGuage_click;

	@FindBy(xpath = "//*[@id=\'NEW_ADD_PRODUCT_FORM\']/div[2]/div[2]/div[1]/div[3]/div[2]/div/div/div/div/div/div/ul/li")
	static List<WebElement> lengthGuage_selection;

	@FindBy(xpath = "//*[@id=\'SIF_ITEM_LENGTH\']")
	static WebElement lengthField;


	/*---*** Width Label ***---*/
	@FindBy(xpath = "//*[@id=\'NEW_ADD_PRODUCT_FORM\']/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div/div")
	static WebElement widthGuage_click;

	@FindBy(xpath = "//*[@id=\'NEW_ADD_PRODUCT_FORM\']/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div/div/div/div/ul/li")
	static List<WebElement> widthGuage_selection;

	@FindBy(xpath = "//*[@id=\'SIF_ITEM_WIDTH\']")
	static WebElement widthField;


	/*---*** Height Label ***---*/
	@FindBy(xpath = "//*[@id=\"NEW_ADD_PRODUCT_FORM\"]/div[2]/div[2]/div[1]/div[4]/div[2]/div/div/div/div/button")
	static WebElement heightGuage_click;

	@FindBy(xpath = "//*[@id=\'NEW_ADD_PRODUCT_FORM\']/div[2]/div[2]/div[1]/div[4]/div[2]/div/div/div/div/div/div/ul/li")
	static List<WebElement> heightGuage_selection;

	@FindBy(xpath = "//*[@id=\'SIF_ITEM_HEIGHT\']")
	static WebElement heightField;		

	/*---*** Product Title ***---*/
	@FindBy(xpath = "//*[@id=\'SIF_TITLE\']")
	static WebElement ptitle;

	/*---*** Product Description ***---*/
	@FindBy(xpath = "//*[@id=\'NEW_ADD_PRODUCT_FORM\']/div[2]/div[1]/div[2]/div/div[2]/div/div/div[3]/div[3]")
	static WebElement pdescription;

	/*---*** Brand Selection ***---*/
	@FindBy(xpath = "//*[@id=\'NEW_ADD_PRODUCT_FORM\']/div[2]/div[2]/div[1]/div[6]/div/div/button")
	static WebElement brandClick;

	@FindBy(xpath = "//*[@id=\'NEW_ADD_PRODUCT_FORM\']/div[2]/div[2]/div[1]/div[6]/div/div/div/div[2]/ul/li")
	static List<WebElement> brandSelection;

	/*---*** meta Title Selection ***---*/
	@FindBy(xpath = "//*[@id=\'SIF_SUB_TITLE\']")
	static WebElement mtitle;

	/*---*** Meta Description ***---*/
	@FindBy(xpath = "//*[@id=\'SIF_META_TITLE\']")
	static WebElement mDescription;

	/*---*** Manufacturer Selection ***---*/
	@FindBy(xpath = "//*[@id=\'new-manufacturer-check\']")
	static WebElement manufacturerBtn;	

	@FindBy(xpath = "//*[@id=\'SIF_HERSTELLER\']")
	static WebElement addManufacturer;

	@FindBy(xpath = "//*[@id=\'new-manufacturer-btn\']")
	static WebElement saveManufacturerBtn;

	@FindBy(xpath = "//*[@id=\'manuerror\']")
	static WebElement duplicateManufacturerError;

	@FindBy(xpath = "//*[@id=\'NEW_ADD_PRODUCT_FORM\']/div[2]/div[2]/div[1]/div[6]/div/div")	
	static WebElement existingBrandsClick;

	@FindBy(xpath = "//*[@id=\'NEW_ADD_PRODUCT_FORM\']/div[2]/div[2]/div[1]/div[6]/div/div/div/div[2]/ul/li")
	static List<WebElement> existingBrandsList;	

	/*---*** Document Attachment ***---*/
	@FindBy(xpath = "*//div[@class='col-6 col-md-11 mb-2']/label")	   
	static WebElement AddAttachment;	

	/*---*** Add Images ***---*/
	@FindBy(xpath = "//*[@id=\'SIY_ADD_PHOTOS\']")
	static WebElement AddImage;	

	/*---*** Add product Tags ***---*/
	@FindBy(xpath = "//*[@id=\'tags_id\']")
	static WebElement AddPTag;

	/*---*** Starting Price ***---*/
	@FindBy(xpath = "//*[@id=\'SIF_PREIS\']")
	static WebElement AddSPrice;

	/*---*** Discounted Price ***---*/
	@FindBy(xpath = "//*[@id=\'SIF_PSEUDOPREIS\']")
	static WebElement AddDPrice;

	/*---*** MOQ ***---*/
	@FindBy(xpath = "//*[@id=\'SIF_MOQ\']")
	static WebElement moq;

	/*---*** Add Quantity at Location ***---*/
	@FindBy(xpath = "//*[@id=\'SIF_S_QTY_1\']")
	static WebElement quantityAddManual;

	/*---*** Add Quantity using buttons ***---*/
	@FindBy(xpath = "//*[@id=\'shipping-location\']/tbody/tr/td[5]/div/div/a[1]")
	static WebElement quantityAddUp;

	/*---*** Decrease Quantity using buttons ***---*/
	@FindBy(xpath = "//*[@id=\'shipping-location\']/tbody/tr/td[5]/div/div/a[2]")
	static WebElement quantityAddDown;

	/*---*** Type DropDown Selection ***---*/
	@FindBy(xpath = "//*[@id=\'NEW_ADD_PRODUCT_FORM\']/div[3]/div/div[4]/div[2]/div/div/div/div/button")
	static WebElement typeSelectionClick;

	/*---*** Type DropDown Selection ***---*/
	@FindBy(xpath = "//*[@id=\'NEW_ADD_PRODUCT_FORM\']/div[3]/div/div[4]/div[2]/div/div/div/div/div/div/ul/li")
	static List<WebElement> typeSelection;	

	/*---*** Save Item ***---*/
	@FindBy(xpath = "//*[@id=\'NEW_ADD_PRODUCT_FORM\']/div[4]/div/button[2]")
	static	WebElement saveItem;

	/*---*** Verification of newly added Item ***---*/
	@FindBy(xpath = "//*[contains(text(), 'Testing 13')]")
	static WebElement itemVerification;

	/*---*** Verification of newly added Item ***---*/
	@FindBy(xpath = "//*[@id=\'product-search\']")
	static WebElement searchItemForVerification;

	/*---*** Verification of newly added Item by searching and comparing with searched item ***---*/
	@FindBy(xpath = "//*[@id=\'product-search\']")
	static WebElement ErrorMessageifThereIsNoProductAppears;

	/*---*** Error message in case of Greater Discounted Price than Starting Price ***---*/
	@FindBy(xpath = "//*[@id=\'discountError\']")
	static WebElement ErrorMessageDescntpriceGreaterThanStartinPrice;

	/*---*** Total images uploaded to find their total divs ***---*/
	@FindBy(xpath = "//img[@class= 'card-img-top border-1']//parent::div[@class='square-div col-md-3 mt-2 pl-0 pr-0']")
	static List<WebElement> totalImages;

	/*---*** Total Documents uploaded to find their total divs ***---*/
	@FindBy(xpath = "//*[@class = 'square-div col-md-3 mt-2 pl-0 pr-0']/div[@class='hover-actions']")
	static List<WebElement> totalDocuments;

	/*---*** Total Documents Divs Appeared after uploading documents ***---*/
	@FindBy(xpath = "*//div[@class='card-body  ']/div")
	List<WebElement> totalDcmntDivs; 

	/*---*** Total Del buttons Divs Appeared after uploading documents ***---*/
	@FindBy(xpath = "//*[@id='NEW_ADD_PRODUCT_FORM']/div[2]/div[2]/div[2]/div[2]/div/div[3]/a[@class='remove-document']/i[@class='fad fa-trash-alt ']")
	List<WebElement> totalDelDivs; 





	public AddProduct() throws Throwable 
	{
		PageFactory.initElements(driver, this);
	}


	public void AddProductInSystem(String STPrice, String DSCNTPrice, int check) throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		welcome_name_click.click();		
		my_seller_central_click.click();		
		sell_an_item_click.click();
		Thread.sleep(1000);		

		/*------- Category Selection -------*/
		product_category_click.click();		
		
		System.out.println("Product Category Size is: " + product_category_selction.size());		
		int randomGeneration1 = TestUtil.randomCall(product_category_selction.size()-1);	
		System.out.println("We are sending to random function size is: " + product_category_selction.size() + 
				" and in return we have random size = " + randomGeneration1);
		
		for(int i=0 ; i<product_category_selction.size(); i++)
		{
			System.out.println("Outside of the loop, i = " + i + " and randomGeneration number = " + randomGeneration1);
			
			if(i == randomGeneration1)
			{
				System.out.println("Inside the loop, i = " + i + " and randomGeneration number = " + randomGeneration1);
				product_category_selction.get(i).click();
				break;
			}
		}		
		Thread.sleep(4000);

		/*------- Sub Category Selection -------*/
		sub_category_click.click();		
		int randomGeneration2 = TestUtil.randomCall(sub_category_selection.size()-1);
		for(int i=0 ; i<sub_category_selection.size(); i++)
		{
			if(i == randomGeneration2)
			{
				Thread.sleep(1000);
				sub_category_selection.get(i).click();
				break;
			}
		}		

		/*------- Age Selection -------*/
		age_dd_click.click();		
		int randomGeneration3 = TestUtil.randomCall(age_selection.size()-1);
		for(int i=0 ; i<age_selection.size(); i++)
		{
			if(i == randomGeneration3)
			{
				Thread.sleep(1000);
				age_selection.get(i).click();
				break;
			}
		}

		/*------- Condition Selection -------*/
		condition_click.click();		
		int randomGeneration4 = TestUtil.randomCall(condition_selection.size()-1);
		for(int i=0 ; i<condition_selection.size(); i++)
		{
			if(i == randomGeneration4)
			{
				Thread.sleep(1000);
				condition_selection.get(i).click();
				break;
			}
		}		

		/*------- Weight Selection -------*/		
		weightGuage_click.click();
		Thread.sleep(1000);
		for(WebElement wgList : weightGuage_selection)
		{
			if(wgList.getText().equalsIgnoreCase("kg"))
			{
				wgList.click();
				break;
			}
		}
		weightField.sendKeys("12");

		/*------- Length Selection -------*/	
		lengthGuage_click.click();
		Thread.sleep(1000);
		for(WebElement lgList : lengthGuage_selection)
		{
			if(lgList.getText().equalsIgnoreCase("ft"))
			{
				lgList.click();
				break;
			}
		}
		lengthField.sendKeys("12");

		/*------- Width Selection --------*/
		widthGuage_click.click();
		Thread.sleep(1000);
		for(WebElement widthList : widthGuage_selection)
		{
			if(widthList.getText().equalsIgnoreCase("ft"))
			{
				widthList.click();
				break;
			}
		}		
		widthField.sendKeys("12");

		/*------- Height Selection -------*/
		heightGuage_click.click();		
		Thread.sleep(1000);
		for(WebElement heightgList : heightGuage_selection)
		{
			if(heightgList.getText().equalsIgnoreCase("ft"))
			{
				heightgList.click();
				break;
			}
		}
		heightField.sendKeys("12");

		/*------- Brand Selection --------*/
		brandClick.click();		
		int randomGeneration5 = TestUtil.randomCall(brandSelection.size()-1);
		for(int i=0 ; i<brandSelection.size(); i++)
		{
			if(i == randomGeneration5)
			{
				Thread.sleep(1000);
				brandSelection.get(i).click();
				break;
			}
		}			

		/*------- Product Title -------*/
		String title = TestUtil.OnlySpecificString();
		ptitle.sendKeys("Testing " + title);

		/*------- Product Description -------*/
		pdescription.sendKeys("This is a testing 25 device");

		/*------- Meta Title -------*/
		mtitle.sendKeys("Testing 25");

		/*------- Meta Description -------*/
		mDescription.sendKeys("Testing 25");

		/*------- Add Manufacturer -------*/
		Thread.sleep(2000);
		manufacturerBtn.click();
		Thread.sleep(2000);
		String bName = TestUtil.OnlySpecificString();
		addManufacturer.sendKeys("Test " + bName);
		Thread.sleep(2000);
		saveManufacturerBtn.click();
		Thread.sleep(2000);

		/*------ Add Document Files -------*/
	
		System.out.println("Document uploading");
		TestUtil.uploadDocument(AddAttachment);
		Thread.sleep(2000);

		/*------ Add Images -------*/
		
		System.out.println("Image uploading");
		TestUtil.uploadDocument(AddImage);
		Thread.sleep(2000);

		/*------ Add Tags -------*/
		AddPTag.click();
		AddPTag.sendKeys("Tag 1", Keys.ENTER);
		AddPTag.sendKeys("Tag 2", Keys.ENTER);
		AddPTag.sendKeys("Tag 3", Keys.ENTER);
		AddPTag.sendKeys("Tag 4", Keys.ENTER);
		AddPTag.sendKeys("Tag 5", Keys.ENTER);

		/*-- Add Starting Price --*/
		AddSPrice.sendKeys(STPrice);

		/*-- Add Discount Price --*/
		AddDPrice.sendKeys(DSCNTPrice);

		/*-- Add MOQ --*/
		moq.sendKeys("1");

		/*-- Add Manual Quantity --*/
		quantityAddManual.sendKeys("100");

		/*-- Add Quantity Using UP Button --*/
		Thread.sleep(2000);
		quantityAddUp.click();quantityAddUp.click();quantityAddUp.click();quantityAddUp.click();

		/*-- Decrease Quantity Using Down Button --*/
		Thread.sleep(2000);
		quantityAddDown.click();quantityAddDown.click();quantityAddDown.click();

		/*-- Random selection of Shipping Type --*/
		typeSelectionClick.click();
		Thread.sleep(2000);
		int shippingModeCount = typeSelection.size();
		System.out.println("Type Selection size = " + shippingModeCount);
		int selectedType = TestUtil.randomCall(shippingModeCount-1);
		System.out.println("We passed shiiping list size = " + shippingModeCount + "-1 " + " to Random Function and random function gave us "
				+ selectedType + " in return");

		for(int i=0 ; i<=selectedType ; i++)
		{
			System.out.println("i = " + i + " ---- " + i +"< =" + selectedType +" ---- " + " i++ as " + i);
			if(i == selectedType)
			{
				typeSelection.get(i).click();
				break;
			}
		}		

		String pName = ptitle.getText();		
		/*--- Saving Item ---*/
		Thread.sleep(2000);
		saveItem.click();	

		/*I am passing this check value from the function I am calling this to verify that 
		 * whether I have to test the starting price functionality greater that discounted price or not*/
		if(check == 0) 
		{
			Assert.assertTrue(ErrorMessageDescntpriceGreaterThanStartinPrice.isDisplayed(), "Discounted price is greater than the Starting Price"
					+ " and system is not restricting it.");
		}		
	}

	public void VerifiedExistingManufacturer() throws InterruptedException
	{
		Thread.sleep(3000);
		welcome_name_click.click();		
		my_seller_central_click.click();		
		sell_an_item_click.click();
		Thread.sleep(3000);	

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0, -100)");		

		existingBrandsClick.click();
		Thread.sleep(2000);
		String selectedBrandName = null;		
		int brandListSize = TestUtil.randomCall(existingBrandsList.size() -1);

		for(int j=1; j<=existingBrandsList.size(); j++)
		{
			if(j == brandListSize)
			{
				selectedBrandName = existingBrandsList.get(j).getText().toString();
				break;
			}
		}

		System.out.println("Selected brand name is " + selectedBrandName);
		manufacturerBtn.click();
		addManufacturer.sendKeys(selectedBrandName);
		saveManufacturerBtn.click();
		Thread.sleep(2000);		
		Assert.assertTrue(duplicateManufacturerError.isDisplayed(), "Error message did not appear");
	}

	public void CheckAgeAndNewconditionMatch() throws InterruptedException
	{
		Thread.sleep(2000);
		welcome_name_click.click();		
		my_seller_central_click.click();		
		sell_an_item_click.click();
		Thread.sleep(2000);		
		age_dd_click.click();
		Thread.sleep(2000);
		for(int i=0; i<=age_selection.size(); i++)
		{
			if(age_selection.get(i).getText().toString().equalsIgnoreCase("New"))
			{
				age_selection.get(i).click();
				break;
			}
		}

		condition_click.click();
		for(int i=0; i<condition_selection.size(); i++)
		{
			//System.out.println("Option no " + i +" "+ condition_selection.get(i).getText().toString());
			Assert.assertFalse(condition_selection.get(i).getText().toString().equalsIgnoreCase("Used"), "Used should not be the part of this dropdown.");		
		}
	}

	public void VerifyAddedManufacturer() throws InterruptedException
	{
		Thread.sleep(2000);
		welcome_name_click.click();		
		my_seller_central_click.click();		
		sell_an_item_click.click();
		Thread.sleep(2000);	

		String bName = TestUtil.randomNumberSpecificLengthNumbersOnly();

		manufacturerBtn.click();
		addManufacturer.sendKeys(bName);
		saveManufacturerBtn.click();
		Thread.sleep(2000);
		brandClick.click();

		boolean res = false;
		for(int i=0; i<brandSelection.size(); i++)
		{
			if(brandSelection.get(i).getText().toString().equalsIgnoreCase(bName))
			{
				res = true;
			}
		}
		Assert.assertTrue(res, "Brand name did not add successfully because it did not appear in the Brand Dropdown.");
	}

	public void ImagedeletionCheck() throws InterruptedException, IOException, AWTException
	{	
		Thread.sleep(2000);
		welcome_name_click.click();		
		my_seller_central_click.click();		
		sell_an_item_click.click();
		Thread.sleep(5000);

		int randomUpload = TestUtil.randomCall(5);	
		System.out.println("This is random number we have : " + randomUpload);
		int count =0;

		for(int i=0; i<randomUpload; i++)
		{		
			TestUtil.uploadImage(AddImage);
			count++;
		}

		int totalImagesUploadedBeforeDeletion = totalImages.size();
		System.out.println("This is count for total uploaded images div before deletion : " + totalImagesUploadedBeforeDeletion);

		List<WebElement> delImg = driver.findElements(By.xpath("//*[@class = 'square-div col-md-3 mt-2 pl-0 pr-0']/div[@class='hover-actions']"));
		int randomDeletion = TestUtil.randomCall(delImg.size());
		System.out.println(randomDeletion);		

		WebElement delImg2 = driver.findElement(By.xpath("//*[@id=\'SIY_PRODUCT_IMAGES\']/div/div[3]/div[1]/div/i["+randomDeletion+"]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", delImg2);
		Thread.sleep(2000);

		int totalImagesUploadedAfterDeletion = totalImages.size();		
		System.out.println("This is count for total appeared images div after deletion : " + totalImagesUploadedAfterDeletion);	

		Assert.assertTrue(totalImagesUploadedBeforeDeletion > totalImagesUploadedAfterDeletion, "Image has not been deleted by the system");
	}	

	public void DocumentDeletionCheck() throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		welcome_name_click.click();		
		my_seller_central_click.click();		
		sell_an_item_click.click();
		Thread.sleep(5000);

		int randomUpload = TestUtil.randomCall(5);	
		System.out.println("Random number we have : " + randomUpload + " and " +randomUpload+ " File(s) should be uploaded");
		int count =0;

		for(int i=0; i<randomUpload; i++)
		{
			//Runtime.getRuntime().exec("./AutoIT/Document Uploading/Upload document AUTOIT Script.exe");
			TestUtil.uploadDocument(AddAttachment);
			Thread.sleep(2000);
			count++;
		}
		System.out.println("Before deletion count is: "+ count);

		int no_of_uploaded_dcmnts = totalDcmntDivs.size()-1;
		System.out.println(no_of_uploaded_dcmnts + " files uploaded.");

		int totalDeletebuttons = totalDelDivs.size()-1;

		int randomDelDcmnts = TestUtil.randomCall(totalDeletebuttons);

		if(randomDelDcmnts==1)
		{
			totalDelDivs.get(0).click();
		}
		else
		{
			for(int i=0; i<=no_of_uploaded_dcmnts; i++)
			{
				if(i==randomDelDcmnts)
				{
					totalDelDivs.get(i).click();
					break;
				}
			}		
		}
		List<WebElement> ele = driver.findElements(By.xpath("//*[@id='NEW_ADD_PRODUCT_FORM']/div[2]/div[2]/div[2]/div[2]/div/div[3]/a[@class='remove-document']/i[@class='fad fa-trash-alt ']"));
		int newDelsize = ele.size();
		int customizedSize = newDelsize-1;
		System.out.println("After deletion count is: " + customizedSize);

		Assert.assertTrue(customizedSize == count-1, "File did not delete from the system.");
	}	
}
