package lib;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listners implements ITestListener {

	private WebDriver driver;

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		SuperTestNG.logger.error("Test case Failed : " + result.getName());

		Object currentClass = result.getInstance();
		driver = ((SuperTestNG) currentClass).driver;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

		try {
			FileUtils.copyFile(scrFile, new File(".\\Screenshot\\" + result.getName() + timeStamp + ".png"));
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			SuperTestNG.logger.error("Could not take screenshot, see error : " + e.toString());
		}
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		SuperTestNG.logger.info("Test case Started : " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		SuperTestNG.logger.info("Test Successfully Completed : " + result.getName());
	}
}
