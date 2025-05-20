package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage //Rule 1
{
	//Rule2- Identify the web element using @FindBy- Declaration
		 @FindBy(id="user-name") 
		 private WebElement usernameText;
		 
		 @FindBy(name="password") private WebElement passwordText;
		 
		 @FindBy(id="login-button") private WebElement loginButton;
		 
		 //Rule 3 Create constructor for element creation
		 
		 public LoginPage(WebDriver driver)
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
