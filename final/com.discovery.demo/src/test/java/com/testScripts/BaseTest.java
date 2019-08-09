package com.testScripts;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.ReporterConfig;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.test.properties.ReadPropertyData;


public class BaseTest {

	public WebDriver driver;
	//Dimension d= new Dimension(1000, 700);
	static ReadPropertyData propertydata=new ReadPropertyData();
	
	 String baseurl=propertydata.getApplicationURL();
	 

@Parameters({"browserType"})		
@BeforeClass
public  void browserSetUp(String browser) {
	 
if(browser.equals("chrome")){
		 
		 System.setProperty("webdriver.chrome.driver", propertydata.getChromePath());
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		 driver.get(baseurl);
		 Reporter.log("Discovery.com HomePage is Launched",true);
	 }	 
	 
else if(browser.equals("firefox")){
		 
	FirefoxProfile fp=new FirefoxProfile();
	fp.setAcceptUntrustedCertificates(false);
	
		 System.setProperty("webdriver.gecko.driver", propertydata.getFirefoxPath());
		 driver=new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		 driver.get(baseurl);
		 Reporter.log("Discovery.com HomePage is Launched",true);
	}

else if(browser.equals("ie")){
	System.setProperty("webdriver.ie.driver", propertydata.getIEPath());

		DesiredCapabilities caps=DesiredCapabilities.internetExplorer();
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		driver=new InternetExplorerDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get(baseurl);
		Reporter.log("Discovery.com HomePage is Launched",true);}
	}
				
@AfterClass
public  void browserClose(){
	
	driver.quit();
	Reporter.log("Browser is closed.",true);
	
}
public static void getScreenShot(WebDriver driver,String tname) throws IOException {
	// String timestamp=new SimpleDateFormat("yyyy-MM-ddhh:mm:ss").format(new Date());
	 String destination = System.getProperty("user.dir") + "/screenshots/"+tname+".png";
	 File finalDestination = new File(destination);
	 TakesScreenshot ts = (TakesScreenshot) driver;
	 File source = ts.getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(source, finalDestination);
	 Reporter.log("Screenshots are Captured",true);
	 }
}
