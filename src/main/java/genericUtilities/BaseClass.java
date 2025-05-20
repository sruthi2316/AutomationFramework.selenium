package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class BaseClass 
{
	public JavaUtility jutil=new JavaUtility();
	public SeleniumUtility sutil=new SeleniumUtility();
	public FileUtilities futil=new FileUtilities();
	
	public WebDriver driver;
	
	//for listners
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig()
	{
		System.out.println("Database Connection Is Successful");
	}
	
//@Parameters("browser")
//@BeforeTest
   @BeforeClass(alwaysRun = true)
	public void bcConfig(/*String pvalue*/) throws IOException
	{
		String URL=futil.readDataFromPropertyFile("url");
		
	   driver=new FirefoxDriver();
		//for cross browser execution-"Run Time Polimorphism- driver"
//		if(pvalue.equals("edge"))
//		{
//			driver=new EdgeDriver();
//		}
//		else if(pvalue.equals("firefox"))
//		{
//			driver=new FirefoxDriver();
//		}
//		else
//		{
//			driver=new EdgeDriver();
//		}
		sutil.maximizeWindow(driver);
		sutil.addImplicitWait(driver);
		driver.get(URL);
		
		//For Listeners
		sdriver=driver;
		System.out.println("Browser Launch Successfully");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME=futil.readDataFromPropertyFile("username");
		String PASSWORD=futil.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("Login to app successfully");
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig()
	{
		InventoryPage ip=new InventoryPage(driver);
		ip.logoutOfApp();
		System.out.println("Logout Successfully");
		
	}
	
//@AfterTest
   @AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("Logout Closure Sucessfully");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("Database Closure Successful");
	}

}
