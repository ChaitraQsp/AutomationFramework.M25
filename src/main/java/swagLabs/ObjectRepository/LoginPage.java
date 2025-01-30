package swagLabs.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //rule 1
	
	//rule 2
	@FindBy(id = "user-name")   //during compile time
	private WebElement usernameEdt; //findElements()
	
	             //1 - logical OR - Auto healing                   
	@FindAll({@FindBy(name = "password"),@FindBy(xpath = "//input[@type='password']")}) // multiple locator -> one web element
	private WebElement passwordEdt;
	
	/*// - logical AND operator 
	@FindBys({@FindBy(name = "password"),@FindBy(xpath = "//input[@type='password']")})
	private WebElement passwordEdt;
	*/
	
	@FindBy(id = "login-button")
	private WebElement loginBtn;
	
	//Rule 3
	public LoginPage(WebDriver driver) //during run time
	{
		PageFactory.initElements(driver, this);
	}

	//rule 4
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business Library - Generic method 
	
	/**
	 * This method will perform login operation
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME, String PASSWORD)
	{
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
	

}
