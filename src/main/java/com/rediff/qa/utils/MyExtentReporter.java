package com.rediff.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

// for extent reporter to work, go to mvnrepository.com --> type extentReports --> click on 5.0.9 --> 
// copy the dependency --> go to pom.xml file --> paste it on top of grasshopper dependency  --> right click on the
// project --> maven --> force update 

// extentreports.com --> click on docs --> version 5 --> java --> getting started --> reporters... we will be using ExtentSparkReporter because its free


public class MyExtentReporter {

	public static ExtentReports generateExtentReport() throws Exception {
		//Step 1: create object of ExtentReports
		ExtentReports extentReport = new ExtentReports();
		
		//Step 2: create the folder in test-output and pass the extentReport as an html file
		File extentReportFile = new File(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html");
	
		//Step 3: create the Object of ExtentSparkReporter
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
	
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("REDIFF TEST RESULTS");
		sparkReporter.config().setDocumentTitle("RediffAutomationTest");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);
		
		
		Properties configProp = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\rediff\\qa\\config\\config.properties");
		configProp.load(ip);
		
		extentReport.setSystemInfo("Application url", configProp.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", configProp.getProperty("browserName"));
		extentReport.setSystemInfo("User Name", configProp.getProperty("validUsername"));
		extentReport.setSystemInfo("Password", configProp.getProperty("validPassword"));
		
		extentReport.setSystemInfo("Operating System", configProp.getProperty("os.version"));
		extentReport.setSystemInfo("Tester Name", configProp.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version", configProp.getProperty("java.version"));
		
		return extentReport;


	}
	
}
