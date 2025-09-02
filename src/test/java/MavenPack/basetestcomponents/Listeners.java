 package MavenPack.basetestcomponents;

 import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import MavenPack.resources.ExtentReporterNG;


public class Listeners extends BaseTest implements ITestListener
{
	ExtentTest test ; 
	ExtentReports  extent = ExtentReporterNG.getReportObject();
	
	ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();//each object creation have its own thread.it won't intterupt the other overriding variable.
	
	@Override
	public void onTestStart(ITestResult result)
	{

	 test =	extent.createTest(result.getMethod().getMethodName()); //title of the method name
	 extenttest.set(test);	//push object into threadlocal,[for each tc:assign unique thread id.->testobject->map]
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
    
		 //test.log(Status.PASS, "Test Passed");
		 extenttest.get().log(Status.PASS, "Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		
      //test.fail(result.getThrowable()) ; 
		extenttest.get().fail(result.getThrowable()) ;
  
      try {
		driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      String  filepath=null;
      try {
		filepath =getScreenshot(result.getMethod().getMethodName(), driver); //testcase name
	
	} catch (IOException e) 
      {
		
		e.printStackTrace();
	}
  	//test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		extenttest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		//System.out.println("I failed executing listeners parse code AND THE TEST METHOD NAME IS"  + result.getName());
        //screenshot, attachement
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
	
	
}
