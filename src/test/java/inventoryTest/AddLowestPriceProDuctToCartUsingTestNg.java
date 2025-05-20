package inventoryTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtilities;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class AddLowestPriceProDuctToCartUsingTestNg extends BaseClass 
{
	@Test(groups="RegressionSuite")
	public void tc_02_AddLowestPriceProductToCartTest() throws IOException
	{
		// Create Object of all Utilities
				FileUtilities fUtil = new FileUtilities();
				JavaUtility jUtil = new JavaUtility();
				SeleniumUtility sUtil = new SeleniumUtility();
				
				// Read common Data
//				String URL = fUtil.readDataFromPropertyFile("url");
//				String USERNAME = fUtil.readDataFromPropertyFile("username");
//				String PASSWORD = fUtil.readDataFromPropertyFile("password");
				
				// Read Data from excel file
				String PRODUCTNAME = fUtil.readDataFromExcelFile("Products", 4, 3); // Run time data
				String SORTOPTION = fUtil.readDataFromExcelFile("Products", 4, 2);
				
				// Launch the browser
//				WebDriver driver = new EdgeDriver();
//				sUtil.maximizeWindow(driver);
//				sUtil.addImplicitWait(driver);
				
				// Load the URL
//				driver.get(URL);

				// Login to Application
//				LoginPage lp = new LoginPage(driver);
//				lp.loginToApp(USERNAME, PASSWORD);
				
				// Click on a product
				InventoryPage ip = new InventoryPage(driver);
				ip.clickOnLowestPriceProduct(driver, SORTOPTION, PRODUCTNAME);
				
				//click on add to cart button
				InventoryItemPage iip=new InventoryItemPage(driver);
				iip.clickOnAddToCartButton();
				
				//Navigate to cart
				ip.clickOnCartContainer();
				
				//Validate the product in cart
//				CartPage cp=new CartPage(driver);
//				String productInCart=cp.captureProductName();
//				
//				Assert.assertEquals(productInCart,PRODUCTNAME);
//				Assert.assertTrue(productInCart.equals(PRODUCTNAME));
//				System.out.println(productInCart);
//				if(productInCart.equals(PRODUCTNAME))
//				{
//					System.out.println("PASS");
//					System.out.println(productInCart);
//				}
//				else
//				{
//					System.out.println("FAIL");
//				}
				
				//logout the application
//			ip.logoutOfApp();



	}

}
