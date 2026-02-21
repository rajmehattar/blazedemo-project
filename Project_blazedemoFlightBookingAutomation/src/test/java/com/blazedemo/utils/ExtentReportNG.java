package com.blazedemo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportNG {

	public static ExtentReports getReportObject() {

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String path = System.getProperty("user.dir") + "//reports//blazedemo_ExtentReport_" + timestamp + ".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path); // create object(reporter) for ExtentSparkReporter

		reporter.config().setReportName("blazedemo Automation Test Results"); // this will create the report name
		reporter.config().setDocumentTitle("Test Results | Travel_blazedemo "); // this will set the title in web
																				// browser window
		reporter.config().setTheme(Theme.STANDARD); // this will set a standard theme
		reporter.config().setTimeStampFormat("dd-MM-yyyy"); // this will set the timestamp

		ExtentReports extent = new ExtentReports(); // this class is responsible to drive all the report execution
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Aditya Parkar");
		extent.setSystemInfo("Project Name", "Travel_blazedemo");
		extent.setSystemInfo("Operating System", "Window 11");

		return extent;

	}

}
