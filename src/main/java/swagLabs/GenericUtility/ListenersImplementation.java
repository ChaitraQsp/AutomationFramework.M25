package swagLabs.GenericUtility;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener interface of TEstNG
 * @author Chaitra M
 *
 */
public class ListenersImplementation implements ITestListener{

	// For Extent Reports
	ExtentReports report;
	ExtentTest test;
	
	// Configuring current system date for screenshot name and report name
	Date d = new Date();
	SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
	String date = f.format(d);

	public void onTestStart(ITestResult result) {
		
		//Capture the Test method name
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" Test Execution started");
		
		//Intimate the extent report for each @Test execution
		test = report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		
		//Capture the Test method name
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" Test Pass");
		
		//Log the status as PASS in Extent Report
		test.log(Status.PASS, methodName+" Test Pass");
	}

	public void onTestFailure(ITestResult result) {
		
		//Capture the Test method name
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" Test FAIL");
		
		//Capture the print the exception
		System.out.println(result.getThrowable());
		
		//Log the status as Fail in Extent Report
		test.log(Status.FAIL, methodName+" Test FAIL");
		
		//Log the Exception captured in Extent Report
		test.log(Status.WARNING, result.getThrowable());
		
		//Capture the screenshot
		
		 /*formulate screenshot name*/
		 String screenshotName = methodName+"-"+date;
		 SeleniumUtility s = new SeleniumUtility();
		 
		 try {
			String path = s.captureScreenShot(BaseClass.sdriver, screenshotName);
			
			//Attach screenshot to the Extent Report
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		
		//Capture the Test method name
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" Test Skip");
		
		//Capture the print the exception
		System.out.println(result.getThrowable());
		
		// Log the status as Skip in Extent Report
		test.log(Status.SKIP, methodName + " Test SKIP");

		// Log the Exception captured in Extent Report
		test.log(Status.WARNING, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
		System.out.println("Suite Execution started");
		
		//Extent Report Configuration
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\Report - "+date+".html");
		esr.config().setDocumentTitle("Swag Labs Execution Report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Execution Report - Build Version 2.3.0");
		
		//attach configuration to Extent Reports class
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Windows family");
		report.setSystemInfo("Base Environment", "Testing Env");
		report.setSystemInfo("Reporter Name", "Chaitra");
			
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("Suite Execution Finished");
		
		//Flush the content to extent Reports
		report.flush(); //report will generate
		
	}
	
	

}
