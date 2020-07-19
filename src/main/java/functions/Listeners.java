package functions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporter;
import resources.screenshotOnFailure;

public class Listeners extends Base implements ITestListener
{

	ExtentReports extent = ExtentReporter.getReport();
	ExtentTest test;
	public void onFinish(ITestContext arg0) 
	{
		extent.flush();
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) 
	{
		test.fail(result.getThrowable());
		String methodName = result.getMethod().getMethodName();
		try 
		{
			@SuppressWarnings("unused")
			WebDriver driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		screenshotOnFailure screenShotObject = new screenshotOnFailure();
		try 
		{
			screenShotObject.getScreenshot(methodName,driver);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) 
	{
		   test = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult arg0) 
	{
		test.log(Status.PASS, "Test Case Passed");
	}
}
