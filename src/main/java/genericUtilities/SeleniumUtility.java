package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This Class Contain All Reusable Method Related To Selenium tool
 * @author Dell
 */

public class SeleniumUtility 
{
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This Method will add implicit wait of 10 seconds
	 * @param driver
	 */
	public void addImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for 10 seconds for element tob clickable 
	 * @param driver
	 * @param element
	 * 
	 */
	public void WaitForElementTobeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * this method will wait for 10 seconds for element to be visible
	 * @param driver
	 * @param element
	 */
	public void WaitForElementTobeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will handle dropdown by index
	 * @param ele
	 * @param index
	 */
	
	public void handleDropdown(WebElement ele, int index)
	{
		Select s=new Select(ele);
		s.selectByIndex(index);
	}
	
	/**
	 * This method will handle dropdown by value
	 * @param ele
	 * @param value
	 */
	public void handleDropdown(String value,WebElement ele )
	{
		Select s=new Select(ele);
		s.selectByValue(value);
		
	}
	
	
	/**
	 * This method will handle dropdown by visible text
	 * @param ele
	 * @param text
	 */
	public void handleDropdown(WebElement ele, String text)
	{
		Select s= new Select(ele);
		s.selectByVisibleText(text);
	}
	/**
	 * This Method will perform click and hold action on element
	 * @param driver
	 * @param ele
	 */
	
	public void clickAndHoldAction(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.clickAndHold(ele).perform();
	}
	
	/**
	 * this method will perform double click actions on element
	 * @param driver
	 * @param ele
	 */
	public void doubleClickAction(WebDriver driver, WebElement ele)
	{
		Actions act=new Actions(driver);
		act.doubleClick(ele).perform();
	}
	
	/**
	 * This method will perform right click actions on element
	 * @param driver
	 * @param ele
	 */
	public void rightClickAction(WebDriver driver,WebElement ele)
	{
		Actions act= new Actions(driver);
		act.contextClick(ele).perform();;
	}
	
	
	/**
	 * This method will perform drag and drop action  
	 * @param driver
	 * @param ele1
	 * @param ele2
	 */

	public void dragAndDropAction(WebDriver driver, WebElement ele1,WebElement ele2)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(ele1, ele2).perform();
	}
	
	/**
	 * This method will perform mouse hover action
	 * @param driver
	 * @param ele
	 */
	public void mouseHoverAction(WebDriver driver, WebElement ele)
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	/**
	 * This method will perform scrolling ction
	 * @param driver
	 * @param ele
	 */
	
	public void scrollToAction(WebDriver driver, WebElement ele)
	{
		Actions act=new Actions(driver);
		act.scrollToElement(ele).perform();
	}
	
	/**
	 * This method will handle frame by index
	 * @param driver
	 * @param frameIndex
	 */
	
	public void handleFrameby(WebDriver driver, int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
		
	/**
	 * This method wil handle frame by frame name 
	 * @param driver
	 * @param name
	 */
	public void handleFrame(WebDriver driver, String name)
	{
		driver.switchTo().frame(name);
	}
	
	/**
	 * This method will handle frame by webelement
	 * @param driver
	 * @param ele
	 */
	public void handleFrame(WebDriver driver, WebElement ele)
	{
		driver.switchTo().frame(ele);
	}
	
	
	/**
	 * This method will accept the alert popup
	 * @param driver
	 */
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will cancel the alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will enter data to alert popup
	 * @param driver
	 * @param s
	 */
	public void enterAlertText(WebDriver driver ,String s)
	{
		driver.switchTo().alert().sendKeys(s);
	}
	
	/**
	 * This method will capture text from alert popup
	 * @param driver
	 */
	public void getAlertText(WebDriver driver)
	{
		driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will handle window
	 * @param driver
	 * @param windowID
	 */
	public void handleWindow(WebDriver driver, String windowID)
	{
		driver.switchTo().window(windowID);
	}
	
	/**
	 * This  method  will capture screeshot and  return the path to  caller
	 * @param driver
	 * @param screenshotname
	 * @return
	 * @throws IOException
	 */
	
	public String captureScreenshot(WebDriver driver, String screenshotname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshot\\" +screenshotname+ ".png");
		FileHandler.copy(src, dst);
		return dst.getAbsolutePath(); //for extent report
		
	}
	
	
	
	
}
