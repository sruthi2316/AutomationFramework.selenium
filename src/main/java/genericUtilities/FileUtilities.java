package genericUtilities;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This Class Consist Of Generic Method Related To File Operation
 * @author Dell
 */

public class FileUtilities 
{
	/**
	 * 
	 * This Method Will Read Data From Property File And Return Value
	 * @param key
	 * @return value
	 * @throws IOException
	 */
  public String readDataFromPropertyFile(String key) throws IOException
  {
	  FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	  Properties p=new Properties();
	  p.load(fis);
	  String value = p.getProperty(key);
	  return value;
  }
  
  /**
   * 
   * This Method Will Read Data From Property File And Return Value
   * @param sheetName
   * @param rowNum
   * @param cellNum
   * @return value1
   * @throws IOException
   */
  
  public String readDataFromExcelFile(String sheetName,int rowNum,int cellNum) throws IOException
  {
	  FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	  Workbook wb=WorkbookFactory.create(fise);
	  Sheet sh=wb.getSheet(sheetName);
	  Row rw=sh.getRow(rowNum);
	  Cell cl=rw.getCell(cellNum);
	  String value1=cl.getStringCellValue();
	  return value1;
	  
	  
	 
  }

}
