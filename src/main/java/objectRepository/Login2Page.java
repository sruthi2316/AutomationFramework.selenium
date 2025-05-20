package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Login2Page  //Rule1
{
	//Rule2-  Declaration
	//@FindAll-identify single webelement thru multiple locators
	//OR-Operator-Auto-Healing Process
	 @FindAll({@FindBy(id="user-name"),@FindBy(xpath = "//input[@class='input_error form_input']")}) 
	 private WebElement usernameText;
	 
	 //@findBys-Identify single webelement thru multiple locators
	 //AND Operators
	 @FindBys({@FindBy(id="password"),@FindBy(xpath="//input[@name='password']")}) 
	 private WebElement passwordText;
	 
	 @FindBy(id="login-button") private WebElement loginButton;
	 
	 //Rule 3 Create constructor for element creation
	 
	 public Login2Page(WebDriver driver)
	 {
		 PageFactory.initElements(driver,this);
	 }

	 //Rule 4 Provide getters to access the element-Utilization
	 
	 public WebElement getUsernameText()
	    {
			return usernameText;
	    }

		public WebElement getPasswordText() 
		{
			return passwordText;
		}

		public WebElement getLoginButton() 
		{
			return loginButton;
		}
		
		public void loginToApp(String un, String pwd)
		{
			usernameText.sendKeys(un);
			passwordText.sendKeys(pwd);
			loginButton.click();
			
		}
		
}
