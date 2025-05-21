package inventoryTest;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtilities;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

@Listeners(genericUtilities.ListnersImplementation.class)
public class AddProductToCartTest extends BaseClass 
{
	
	
	@Test(groups="SmokeSuite")
    public void tc_01_AddProductToCartTest() throws IOException 
	{
		//Create Object of all utility
//				FileUtilities futil=new FileUtilities();
//				SeleniumUtility sutil=new SeleniumUtility();
//			    JavaUtility jutil=new JavaUtility();
			     
			
				//Read Common Data
				
//				String URL=  futil.readDataFromPropertyFile("url");
//				String USERNAME = futil.readDataFromPropertyFile("username");
//				String PASSWORD = futil.readDataFromPropertyFile("password");
		//Read Data from excel file
			//Read Data from excel file
			   String ProductName=futil.readDataFromExcelFile("Products", 1, 2);
				
				//Launch Browser
//				WebDriver driver=new EdgeDriver();		
//				sutil.maximizeWindow(driver);
//				sutil.addImplicitWait(driver);

				//load url
//				driver.get(URL);
				
				//Login to application
//				LoginPage lp=new LoginPage(driver);
//				lp.loginToApp(USERNAME, PASSWORD);
				
				//Click on a product
				InventoryPage ip=new InventoryPage(driver);
				ip.clickOnProduct(driver, ProductName);
				
				//Click on add to cart
				InventoryItemPage iip=new InventoryItemPage(driver);
				iip.clickOnAddToCartButton();
				
				//Navigate to cart
				ip.clickOnCartContainer();
				
				//Validate the product in cart
//				CartPage cp = new CartPage(driver);
//				String productInCart = cp.captureProductName();
//				System.out.println(productInCart);
//				if(productInCart.equals(ProductName))
//				{
//					System.out.println("PASS");
//					System.out.println(ProductName);
//				}
//				else
//				{
//					System.out.println("FAIL");
//				}
				
				//logout the application
//			ip.logoutOfApp();
				
				
  }
	@Test()
	public void sample()
	{
        Assert.fail();
		System.out.println("Sample");
	}

}
