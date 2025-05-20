package practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgPractice
{
	@Test(invocationCount = 2, priority=1)
	public void createSample()
	{
		System.out.println("Create");
	}
	
	@Test(priority = -1)
	public void modifySample()
	{
		Assert.fail();  //Forcefully Fail the execution
		System.out.println("modify");
	}
	
	@Test(dependsOnMethods = "modifySample")  //skip the execution due to some method
	public void deleteSample()
	{
		System.out.println("Delete");
	}
	
	
	

}
