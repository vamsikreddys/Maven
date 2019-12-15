package lib;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class ProjectSpecific {

	public static void waitForSomeTime(int waitTime, Logger logger) {

		try {
			Thread.sleep(waitTime);
			logger.info("Waiting for " + waitTime +"miliseconds");

		} catch (InterruptedException exe) {

			logger.error(exe.toString());

		} catch (Exception ex) {
			logger.error(ex.toString());
		}
	}

	public static String getPageTitle(WebDriver driver, Logger logger) {
		String title = null;
		try {
			title = driver.getTitle();
			logger.info("Successfully retrieved the page title");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			logger.error("Error Occured while capturing the title" + e.toString());
		}

		return title;
	}

}
