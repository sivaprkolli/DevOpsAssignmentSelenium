package com.automation.DevOpsAssignment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
public static WebDriver driver;
public ReadPropertiesData readPropertiesData;
	
	@BeforeSuite
	public void launchBrowser() throws Exception {
		readPropertiesData = new ReadPropertiesData();
		String browserName = readPropertiesData.readPropertyValue("browser");
		if(browserName.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(browserName.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else if(browserName.equals("internetExplorer")) {

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			
		}else if(browserName.equals("safari")) {
			driver = new SafariDriver();
		}else if(browserName.equals("cloud-chrome")) {
			new DesiredCapabilities();
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("platform", Platform.MAC);
			dc.setCapability("name", "ParaBank Test");
			dc.setCapability("project", "DevOps Assignment");
			dc.setCapability("build", "ParaBank Automation");
			driver = new RemoteWebDriver(new URL("http://siva266:7Wfwz8qNKAn9X4XyNTXE@hub.browserstack.com:80/wd/hub"), dc);
			
		}else if(browserName.equals("cloud-firefox")) {
			new DesiredCapabilities();
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("platform", Platform.WINDOWS);
			dc.setCapability("name", "ParaBank Test");
			dc.setCapability("project", "DevOps Assignment");
			dc.setCapability("build", "ParaBank Automation");
			driver = new RemoteWebDriver(new URL("http://siva266:7Wfwz8qNKAn9X4XyNTXE@hub.browserstack.com:80/wd/hub"), dc);
			
		}else if(browserName.equals("cloud-safari")) {
			new DesiredCapabilities();
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("platform", Platform.MAC);
			dc.setCapability("name", "ParaBank Test");
			dc.setCapability("project", "DevOps Assignment");
			dc.setCapability("build", "ParaBank Automation");
			driver = new RemoteWebDriver(new URL("http://siva266:7Wfwz8qNKAn9X4XyNTXE@hub.browserstack.com:80/wd/hub"), dc);
			
		}
		else if(browserName.equals("docker-chrome")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("browserName", "chrome");
			chromeOptions.merge(desiredCapabilities);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);

		}
	}
	
	@BeforeTest
	public void launchApplication() {
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void killSession() {
		driver.quit();
	}

}
