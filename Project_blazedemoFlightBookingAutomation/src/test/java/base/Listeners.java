package base;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.blazedemo.utils.ExtentReportNG;


public class Listeners implements ITestListener{
	
	ExtentTest test;
	ExtentReports extent = ExtentReportNG.getReportObject();

	@Override
	public void onTestStart(ITestResult result) { // will invoke each time a test is invoked

		// to create an entry for any test in the report
		test = extent.createTest(result.getMethod().getMethodName()); // this will get the method name of
		                                                       // the current test and set an entry here
	}

	@Override
	public void onTestSuccess(ITestResult result) { // will invoke each time a test is passed
		
		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {  // will invoke each time a test fails
		
		//test.fail(result.getThrowable()); // this will give the error message for failed test
		
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try {
			String imgPath = new BaseTest().captureScreenshot(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush(); // this will generate the html report
	}

}
