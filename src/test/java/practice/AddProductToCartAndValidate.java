package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AddProductToCartAndValidate {
	
	public static void main(String[] args) {
		
		//Step 1: Launch the browser
		WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//selenium4
		
		
		driver.get("https://www.saucedemo.com/");
		
		//Step 2: Login to Application
		//Step 2: Login to Application
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//Step 3: Click on product - Sauce Labs Bike Light
		String productToBeAdded = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']")).getText();
		driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']")).click();
		
		//Step 4: click on add To cart
		driver.findElement(By.id("add-to-cart")).click();
		
		//Step 5: Navigate to Cart
		driver.findElement(By.id("shopping_cart_container")).click();
		
		//Step 6: Validate the product
		String productDetailInCart = driver.findElement(By.className("inventory_item_name")).getText();
		if(productDetailInCart.equals(productToBeAdded))
		{
			System.out.println("PASS");
			System.out.println(productDetailInCart);
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Step 7: Logout of Application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

}
