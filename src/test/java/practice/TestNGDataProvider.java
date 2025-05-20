package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProvider
{
	
	@Test(dataProvider= "getData")
	public void createSample(String name,int id)
	{
		System.out.println("Name: " +name+" Id: " +id);
		System.out.println("----------------------------");
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[3][2];
		 
		// 3 rows- 3 dataset and each has 2 columns-2 information
		data[0][0]="sruthi";
		data[0][1]=14;
		
		data[1][0]="vihaan";
		data[1][1]=21;
		
		data[2][0]="jijin";
		data[2][1]=8;
		
		return data;
				
	}

}
