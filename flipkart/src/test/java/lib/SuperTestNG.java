package lib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SuperTestNG {

	public WebDriver driver = null;
	public Properties prop = null;
	public static Logger logger = null;

	@BeforeMethod
	public void preCondition() {
		logger = LogManager.getLogger(SuperTestNG.class);
		logger.info("Initiating the browser driver");

		// Variable declaration
		String browserName;
		FileInputStream fis;

		// Accessing property file for browser selection
		try {
			prop = new Properties();
			fis = new FileInputStream(".\\src\\test\\resources\\utility\\config.Properties");
			prop.load(fis);
		} catch (IOException e1) {

			logger.error("Config file not found " + e1.toString());
		}

		// Get the Browser Name from property file
		browserName = prop.getProperty("browserType");

		// Initiate browser based on browser type
		try {

			if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.firefox.marionette", ".\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}

			else if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			}

			else if (browserName.equalsIgnoreCase("IE")) {
				System.setProperty("Webdriver.ie.driver", ".\\drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			logger.info("Successfully Initiated the browser driver");
		}

		catch (WebDriverException ex) {
			// TODO Auto-generated catch block
			logger.error("Error Occured while initating the WebDriver" + ex.toString());
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Error Occured while initating the WebDriver" + e.toString());
		}
	}

	@AfterMethod
	public void postCondition() {

		// Closing all the open browser windows
		try {
			driver.quit();
			logger.info("Successfully closed the driver");
		}

		catch (WebDriverException ex) {
			// TODO Auto-generated catch block
			logger.error("Error occured while quiting the driver" + ex.toString());
		}
	}
}
