package com.facebook.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public static Logger log = Logger.getLogger(TestBase.class);
	
	public ExtentReports extent = new ExtentReports();
	public ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReporter.html");
	ExtentTest test;
	
	public TestBase() {
	try {
	prop = new Properties();
	FileInputStream ip = new FileInputStream("C:\\Users\\punit\\eclipse-workspace\\facebookpom\\src\\main\\java\\com\\facebook\\config\\config.properties");
	prop.load(ip);
	} catch (FileNotFoundException e) {
	e.printStackTrace();
	} catch (IOException e) {
	e.printStackTrace();
	}
	}
	public static void initialization() {
	String browserName = prop.getProperty("browser");
	log.info("Browser Name:" +prop.getProperty("browser"));
	
	if(browserName.equals("chrome")) 
	System.setProperty("webdriver.chrome.driver","C:\\Users\\punit\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	log.info("URL is" + prop.getProperty("url"));
	
	driver.get(prop.getProperty("url"));

	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);


	}

}
