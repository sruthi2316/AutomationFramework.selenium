package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
* This Class will Provide Implementation Of ITestListner Interface using TestNg
* @author Dell

 */
public class ListnersImplementation implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) 
	{
		//Capture The Method Name
		String methodName=result.getMethod().getMethodName();
		System.out.println("#"+methodName+" Test Script Execution Started #");
		
		//create Test in Extent Report
		test=report.createTest(methodName);
		
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		//capture the method name
		String methodName=result.getMethod().getMethodName();
		System.out.println("#"+methodName+" Test Script Pass #");
		
		//Log the status as pass in extent report
		test.log(Status.PASS, methodName+"->Test Script Pass");
		
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		//Capture Method Name
		String methodName=result.getMethod().getMethodName();
		System.out.println("#"+methodName+" Test Script Fail #");
		
		//Capture Exception
		System.out.println(result.getThrowable());
		
		//Log the status as fail in extent report
		test.log(Status.FAIL, methodName+"->Test Script Fail");
		
		//Log the Exception in extent report
		test.log(Status.WARNING,result.getThrowable());
		
		//Capture Screenshot
		JavaUtility j=new JavaUtility();
		SeleniumUtility s=new SeleniumUtility();
		
		//configure screenshot name
		String screenshotname = methodName+"-"+j.getSystemDate();
		try 
		{
			//return from absolute get path in selenium utility
		  String path=s.captureScreenshot(BaseClass.sdriver, screenshotname);
		  
		  //attach the screenshot to extent report
		  test.addScreenCaptureFromPath(path);
		  
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		String methodName=result.getMethod().getMethodName();
		System.out.println("#"+methodName+"Test Script Skipped #");
		
		//Capture Exception
		System.out.println(result.getThrowable());
		
		//Log the  status as skip in extent report
		test.log(Status.SKIP, methodName+"->Test Script Skip");
		
		//Log the exception in extent Report
		test.log(Status.WARNING, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) 
	{
		
		System.out.println("# Suit Execution Started #");
		
		//Basic Configuration Of Extent Reports
		ExtentSparkReporter esr=new ExtentSparkReporter(".\\ExtentRports\\ Report"+new JavaUtility().getSystemDate()+".html");
		esr.config().setDocumentTitle("Swag Labs Execution");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Automation Frame Work Execution");
		
		//Report Generation
		report= new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Env", "Testing");
		report.setSystemInfo("Reporter Name", "Sruthi");
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println("# Suit Execution Finished #");
		//report generation Extent Report
		report.flush();
	}
	

}
