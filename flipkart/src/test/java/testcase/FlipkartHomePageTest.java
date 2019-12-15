package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import lib.ProjectSpecific;
import lib.SuperTestNG;
import objectrepository.FlipkartHomePageObject;

public class FlipkartHomePageTest extends SuperTestNG {

	@Test
	public void flipkartHomePageTest() {

		// Local variable declarations
		String homePageExpectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		String mobilePageExpectedTitle = "Mobile Phones: Buy Mobiles Online at Best Prices in India";
		String filterSelectionExpected = "6 GB & Above";

		// Creating an object of Home Page object class
		FlipkartHomePageObject homepage = new FlipkartHomePageObject(driver);

		homepage.loginPopUpCancelButtonClick();

		// Verifying the Home Page title
		Assert.assertEquals(ProjectSpecific.getPageTitle(driver, logger), homePageExpectedTitle);
		homepage.menuElectronicsClick();
		homepage.subMenuMobileClick();
		ProjectSpecific.waitForSomeTime(2000, logger);

		// Verifying the MobilePage title
		Assert.assertEquals(ProjectSpecific.getPageTitle(driver, logger), mobilePageExpectedTitle);

		// Selection the Check-box 6GB & Above and verify the filter selection
		homepage.chekBox6GBandAboveClick();
		Assert.assertEquals(homepage.lblFilterSelectionVerify().getText(), filterSelectionExpected);
	}
}
