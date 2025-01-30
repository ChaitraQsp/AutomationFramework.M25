package swagLabs.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

	@FindBy(id = "react-burger-menu-btn")
	private WebElement menuBtn;

	@FindBy(linkText = "Logout")
	private WebElement logoutLnk;

	@FindBy(id = "shopping_cart_container")
	private WebElement cartContainerBtn;

	@FindBy(xpath = "//div[.='Sauce Labs Backpack']")
	private WebElement backPackName;

	// rule 3
	public InventoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// rule 4
	public WebElement getMenuBtn() {
		return menuBtn;
	}

	public WebElement getLogoutLnk() {
		return logoutLnk;
	}

	public WebElement getCartContainerBtn() {
		return cartContainerBtn;
	}

	public WebElement getBackPackName() {
		return backPackName;
	}

	// business library
	/**
	 * This method will click on a particular product whose info is fetched from excel file and 
	 * return to caller
	 * @param driver
	 * @param PRODUCTNAME
	 * @return
	 */
	public String clickOnAnyProduct(WebDriver driver, String PRODUCTNAME) {
		
		// handle dynamic xpath
		String productInfo = driver.findElement(By.xpath("//div[.='" + PRODUCTNAME + "']")).getText();
		driver.findElement(By.xpath("//div[.='" + PRODUCTNAME + "']")).click();

		return productInfo;
	}
	
	/**
	 * This method will click on backpack product
	 */
	public void clickOnBackPackProduct()
	{
		backPackName.click();
	}
	
	/**
	 * This method will perform logout operation 
	 */
	public void logOutOfApp()
	{
		menuBtn.click();
		logoutLnk.click();
	}
	
	/**
	 * This method will click on cart container button
	 */
	public void clickOnCartContainer()
	{
		cartContainerBtn.click();
	}
	
	
	
	
	
	
	
	
}
