package objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage
{
	
	//Identify webelements
	@FindBy(className = "inventory_item_name")
	private WebElement itemInfo;
	
	@FindBy(className = "btn btn_secondary btn_small cart_button")
	private WebElement removeButton;
	
	@FindBy(className="inventory_item_price")
	private WebElement productPrice;
	
	@FindBy(id="checkout")
	private WebElement checkOutButton;
	
	//create constructor-Initialization
	
	public CartPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization


	public WebElement getItemInfo()
	{
		return itemInfo;
	}

	public WebElement getRemoveButton() 
	{
		return removeButton;
	}

	public WebElement getProductPrice()
	{
		return productPrice;
	}

	public WebElement getCheckOutButton()
	{
		return checkOutButton;
	}
	
	//bussiness Library
	
	/**
	 * This method will return Productname
	 * @param itemInfo 
	 * @return
	 */
	
	public String captureProductName()
	{
		
		 return itemInfo.getText();
	}
	
	/**
	 * This method will return Product Price
	 * @return
	 */
	public String captureProductPrice()
	{
		return productPrice.getText();
	}
	
	/**
	 * This method will click On remove button
	 */
	public void clickOnRemoveBtn()
	{
		removeButton.click();
	}
	
	/**
	 * This method will click on check out button
	 */
	
	public void clickOnCheckOutBtn()
	{
		checkOutButton.click();
	}
	

}
