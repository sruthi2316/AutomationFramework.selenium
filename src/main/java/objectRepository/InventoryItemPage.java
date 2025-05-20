package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage
{
	//identify
	@FindBy(id="add-to-cart")
	private WebElement addToCartButton;
	
	@FindBy(className = "inventory_details_price")
	private WebElement productPrice;
	
	@FindBy(id="remove")
	private WebElement removeButton;
	
	//initialization
	public InventoryItemPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getAddToCartButton()
	{
		return addToCartButton;
	}

	public WebElement getProductPrice() 
	{
		return productPrice;
	}

	public WebElement getRemoveButton() 
	{
		return removeButton;
	}
	
	//Bussines Library
	/**
	 * This method will click on add to cart btn
	 */
	
	public void clickOnAddToCartButton()
	{
		addToCartButton.click();
		
	}
	
	
	
	
	
	
	

}
