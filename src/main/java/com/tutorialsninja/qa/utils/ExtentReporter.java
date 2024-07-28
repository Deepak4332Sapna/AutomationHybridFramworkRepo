package com.tutorialsninja.qa.utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtentReport() {
	ExtentReports extentReports = new ExtentReports();	
	
	File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
	ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
	sparkReporter.config().setTheme(Theme.DARK);
	sparkReporter.config().setReportName("TutorialNinja Text Automation Reports");
	sparkReporter.config().setDocumentTitle("TN Automation Report");
	sparkReporter.config().setTimeStampFormat("dd/MM/YYYY hh:mm:ss");
	
	extentReports.attachReporter(sparkReporter);
	extentReports.setSystemInfo("Application URL", "https://tutorialsninja.com/demo/");
	extentReports.setSystemInfo("Browser Name", "chrome");
	extentReports.setSystemInfo("Email", "vivek1234@gmail.com");
	extentReports.setSystemInfo("Password", "vivek123");
	
	return extentReports;
	}
}
