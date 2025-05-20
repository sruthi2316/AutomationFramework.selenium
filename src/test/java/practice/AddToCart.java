package practice;


import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AddToCart 
{

	public static void main(String[] args) throws InterruptedException, IOException
	{
		//Read Common Data
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		
		
		WebDriver driver=new EdgeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		//driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		
		WebElement ele = driver.findElement(By.xpath("//div[@class='inventory_item_name '][1]"));
		
		ele.click();
		Thread.sleep(1000);
		driver.findElement(By.id("add-to-cart")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Logout")).click();

	}

}
