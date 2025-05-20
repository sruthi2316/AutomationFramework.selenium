package objectRepository;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;



public class InventoryPage extends SeleniumUtility
{
	//identify the webelements
//	@FindBy(className="inventory_item_name ")
//	private WebElement productName;
	
	@FindBy(id="shopping_cart_container")
	private WebElement cartContainer;
	
	@FindBy(className = "product_sort_container")
	private WebElement sortFilter;
	
	@FindBy(id="react-burger-menu-btn")
	private WebElement menuButton;
	
	@FindBy(id="logout_sidebar_link")
	private WebElement logoutBtn;
	
	//create constructor and initialize
	public InventoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization-provide getter method

//	public WebElement getProductName() 
//	{
//		return productName;
//	}

	public WebElement getCartcontainer() 
	{
		return cartContainer;
	}

	public WebElement getSortFilter() 
	{
		return sortFilter;
	}

	public WebElement getMenuButton()
	{
		return menuButton;
	}

	public WebElement getLogoutBtn() 
	{
		return logoutBtn;
	}
	
	//Bussiness Library
	/**
	 * This method will click on dynamic product
	 * @param driver
	 * @param productName
	 */
	
	public void clickOnProduct(WebDriver driver,String productName)
	{
		driver.findElement(By.xpath("//div[.='"+productName+"']")).click();
		
	}
	
	
	/**
	 * This method will click on cart container button
	 */
	
	public void clickOnCartContainer()
	{
		cartContainer.click();
	}
	/**
	 * This method will logout of application
	 */
	
	public void logoutOfApp()
	{
		menuButton.click();
		logoutBtn.click();
	}
	
	public void clickOnLowestPriceProduct(WebDriver driver, String sortOption, String productName)
	{
		handleDropdown(sortFilter,sortOption);
		driver.findElement(By.xpath("//div[.='"+productName+"']")).click();
	    
	}

	
	
	
	
	
	

}
