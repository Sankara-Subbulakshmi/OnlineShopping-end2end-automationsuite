package MavenPack.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG 
{

	public static ExtentReports getReportObject()
	{
		
		 ExtentReports  extent  =new ExtentReports();
		 ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/index.html"); 
		 reporter.config().setReportName("Web Automation Result");
		 reporter.config().setDocumentTitle("Test Results");	
		 extent.attachReporter(reporter);
		 extent.setSystemInfo("Tester", "Subbulakshmi");
		 return extent;
		
		
	}
	
	
	
}
