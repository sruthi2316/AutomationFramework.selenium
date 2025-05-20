package practice;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AddCartExcelFile 
{

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		//Read Common Data
				FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
				Properties p=new Properties();
				p.load(fis);
				String URL=p.getProperty("url");
				String USERNAME=p.getProperty("username");
				String PASSWORD=p.getProperty("password");
				
			//Read Data from excel file
				
				FileInputStream fies=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
				Workbook wb=WorkbookFactory.create(fies);
				Sheet sh=wb.getSheet("Products");
				Row rw=sh.getRow(1);
				Cell cl=rw.getCell(2);
				String ProductName=cl.getStringCellValue();
				
				//Launch Browser
				WebDriver driver=new EdgeDriver();		
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//load url
				
				driver.get(URL);
				//driver.get("https://www.saucedemo.com/");
				
				//login to application
				driver.findElement(By.id("user-name")).sendKeys(USERNAME);
				driver.findElement(By.id("password")).sendKeys(PASSWORD);
				driver.findElement(By.id("login-button")).click();
				
				//click on product -Dynamic xpath
				WebElement ele = driver.findElement(By.xpath("//div[.='"+ProductName+"']"));
				String pname=ele.getText();
				ele.click();
				
				//click on add to cart
				driver.findElement(By.id("add-to-cart")).click();
				
				//navigate to cart
				driver.findElement(By.id("shopping_cart_container")).click();
				
				//validate the product in the cart
				
				String prodIncart=driver.findElement(By.className("inventory_item_name")).getText();
				if(prodIncart.equals(pname))
				{
					System.out.println("Pass");
					System.out.println(prodIncart);
				}
				else
				{
					System.out.println("Fail");
				}
				
				driver.findElement(By.id("react-burger-menu-btn")).click();
				Thread.sleep(1000);
				driver.findElement(By.linkText("Logout")).click();
				

	}

}
