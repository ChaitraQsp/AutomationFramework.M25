package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.checkerframework.checker.units.qual.m;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import swagLabs.GenericUtility.ExcelFileUtility;
import swagLabs.GenericUtility.PropertyFileUtility;
import swagLabs.GenericUtility.SeleniumUtility;
import swagLabs.ObjectRepository.LoginPage;

public class AddProductToCartUsingDDTandGU {

	public static void main(String[] args) throws IOException {
		
		//Create object of Utilities
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		// Read the Common Data From Property File
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");

		// Read Test Data From Excel File
		String PRODUCTNAME = eUtil.readDataFromExcel("Inventory", 1, 2);
		System.out.println(PRODUCTNAME);

		// Step 1: Launch the browser
		WebDriver driver = new EdgeDriver();

		sUtil.maximizeWindow(driver);
		sUtil.addimplicitlyWait(driver);

		driver.get(URL);

		// Step 2: Login to Application
//		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
//		driver.findElement(By.id("password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("login-button")).click();
		
		LoginPage lp = new LoginPage(driver);
		
//		lp.getUsernameEdt().sendKeys(USERNAME);
//		lp.getPasswordEdt().sendKeys(PASSWORD);
//		lp.getLoginBtn().click();
		
		lp.loginToApp(USERNAME, PASSWORD);
		
		
		// Step 3: Click on product - use Dynamic Xpath to pass ProductName from excel
		// sheet to xpath
		String productToBeAdded = driver.findElement(By.xpath("//div[text()='" + PRODUCTNAME + "']")).getText();
		driver.findElement(By.xpath("//div[text()='" + PRODUCTNAME + "']")).click();

		// Step 4: click on add To cart
		driver.findElement(By.id("add-to-cart")).click();

		// Step 5: Navigate to Cart
		driver.findElement(By.id("shopping_cart_container")).click();

		// Step 6: Validate the product
		String productDetailInCart = driver.findElement(By.className("inventory_item_name")).getText();
		if (productDetailInCart.equals(productToBeAdded)) {
			System.out.println("PASS");
			System.out.println(productDetailInCart);
		} else {
			System.out.println("FAIL");
		}

		// Step 7: Logout of Application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

}
