package swagLabs.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	//Declaration
	@FindBy(className = "inventory_item_name")
	private WebElement itemName;
	
	//initialization
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getItemName() {
		return itemName;
	}
	
	//Business library
	/**
	 * This method will capture the product info in Cart and return to Caller
	 * @return
	 */
	public String getProductInfo()
	{
		return itemName.getText();
	}

	
}
