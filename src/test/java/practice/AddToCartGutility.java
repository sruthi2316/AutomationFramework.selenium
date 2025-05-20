package practice;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtilities.FileUtilities;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class AddToCartGutility 
{

	public static void main(String[] args) throws IOException
	{
		
		//Create Object of all utility
		FileUtilities futil=new FileUtilities();
		SeleniumUtility sutil=new SeleniumUtility();
	    JavaUtility jutil=new JavaUtility();
	     
	
		//Read Common Data
		
		String URL=  futil.readDataFromPropertyFile("url");
		String USERNAME = futil.readDataFromPropertyFile("username");
		String PASSWORD = futil.readDataFromPropertyFile("password");
		
	//Read Data from excel file
		
		
		String ProductName=futil.readDataFromExcelFile("Products", 1, 2);
		
		//Launch Browser
		WebDriver driver=new EdgeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//load url
		driver.get(URL);
		
		//driver.get("https://www.saucedemo.com/");
		
		//login to application
//		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
//		driver.findElement(By.id("password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("login-button")).click();
		LoginPage lp=new LoginPage(driver);
		lp.getUsernameText().sendKeys(USERNAME);
		lp.getPasswordText().sendKeys(PASSWORD);
		lp.getLoginButton().click();
		
		//click on product -Dynamic xpath
		WebElement ele = driver.findElement(By.xpath("//div[.='"+ProductName+"']"));
		String pname=ele.getText();
		ele.click();
		
		//click on add to cart
		driver.findElement(By.id("add-to-cart")).click();
		
		//navigate to cart
		driver.findElement(By.id("shopping_cart_container")).click();
		
		//capture the screenshot
		String screenshotname="addProductToCart-"+jutil.getSystemDate();
		String path=sutil.captureScreenshot(driver, screenshotname);
		System.out.println(path);
		
		//validate the product in the cart
		
		String prodIncart=driver.findElement(By.className("inventory_item_name")).getText();
		if(prodIncart.equals(pname))
		{
			System.out.println("Pass");
			System.out.println(prodIncart);
		}
		else
		{
			System.out.println("Fail");
		}
		
		driver.findElement(By.id("react-burger-menu-btn")).click();
		
		driver.findElement(By.linkText("Logout")).click();

	}

}
