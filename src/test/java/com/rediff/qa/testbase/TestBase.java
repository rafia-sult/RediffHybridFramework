package com.rediff.qa.testbase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.rediff.qa.utils.Utilities;

public class TestBase {

	public static WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	public FileInputStream ip;
	public ChromeOptions options;
	
	public TestBase() throws Exception {
		//this is for create account
		prop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\rediff\\qa\\config\\config.properties");
		prop.load(ip);
		
		//this is for login test
		dataprop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\com\\rediff\\qa\\testData\\testData.properties");
		dataprop.load(ip);
	}

	public WebDriver initializeBrowserAndOpenApplication(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			options.addArguments("--start-maximized");
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.implicitWaitTime));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.pageLoadTime));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Utilities.scriptTime));
		driver.get(prop.getProperty("url"));
		return driver;
		

	}

}
