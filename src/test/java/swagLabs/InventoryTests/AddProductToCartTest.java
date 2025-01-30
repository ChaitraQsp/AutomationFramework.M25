package swagLabs.InventoryTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import swagLabs.GenericUtility.BaseClass;
import swagLabs.GenericUtility.ExcelFileUtility;
import swagLabs.GenericUtility.PropertyFileUtility;
import swagLabs.GenericUtility.SeleniumUtility;
import swagLabs.ObjectRepository.CartPage;
import swagLabs.ObjectRepository.InventoryPage;
import swagLabs.ObjectRepository.LoginPage;
import swagLabs.ObjectRepository.ProductPage;

@Listeners(swagLabs.GenericUtility.ListenersImplementation.class)
public class AddProductToCartTest extends BaseClass{

	@Test(groups = "SmokeSuite")
	public void tc_001_AddProductToCartTest() throws IOException
    {
		// Read Test Data From Excel File
		String PRODUCTNAME = eUtil.readDataFromExcel("Inventory", 1, 2);
		System.out.println(PRODUCTNAME);

		// Step 3: Click on product - ProductName from excel
		InventoryPage ip = new InventoryPage(driver);
		String productAdded = ip.clickOnAnyProduct(driver, PRODUCTNAME);
		
		// Step 4: click on add To cart button
		ProductPage pp = new ProductPage(driver); 
		pp.clickOnAddToCartBtn();
		
		// Step 5: Navigate to Cart
		ip.clickOnCartContainer();

		// Step 6: Validate the product in Cart
		CartPage cp = new CartPage(driver);
		String productInCart = cp.getProductInfo();
	
		Assert.assertEquals(productInCart, productAdded);
		
		Assert.assertTrue(productInCart.equals(productAdded));
		
		System.out.println(productInCart);	

	}
	
	@Test(retryAnalyzer = swagLabs.GenericUtility.RetryAnalyserImplementation.class)
	public void sampleTest()
	{
		Assert.fail();
		System.out.println("sample");
	}

}
