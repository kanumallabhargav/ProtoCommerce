package functions;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporter;

public class Listeners implements ITestListener
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
