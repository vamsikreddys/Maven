package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartHomePageObject {

	private WebDriver driver;

	// Constructor
	public FlipkartHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	// Page Objects
	By loginPopUpCancelButton = By.cssSelector("button[class='_2AkmmA _29YdH8']");
	By menuElectronics = By.cssSelector("li[class='Wbt_B2 _1YVU3_']:nth-child(1) span[class='_1QZ6fC _3Lgyp8']");
	By subMenuMobiles = By.cssSelector("a[title='Mobiles']");
	By chekBox6GBandAbove = By.cssSelector("div[class=\"_3mk-PQ\"] div[title=\"6 GB & Above\"]");
	By txtfilterSelection = By.cssSelector("div[class=\"_3clSXm\"] div[class=\"_3UZZGt\"]");

	// Methods
	public void loginPopUpCancelButtonClick() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement btn_loginPopUpCancel = wait.until(ExpectedConditions.elementToBeClickable(loginPopUpCancelButton));
		btn_loginPopUpCancel.click();
	}

	public void menuElectronicsClick() {
		WebElement lnk_menuElectronics = driver.findElement(menuElectronics);
		lnk_menuElectronics.click();
	}

	public void subMenuMobileClick() {
		WebElement lnk_subMenuMobile = driver.findElement(subMenuMobiles);
		lnk_subMenuMobile.click();
	}

	public void chekBox6GBandAboveClick() {
		WebElement ckb_chekBox6GBandAbove = driver.findElement(chekBox6GBandAbove);
		ckb_chekBox6GBandAbove.isDisplayed();
		ckb_chekBox6GBandAbove.click();
	}

	public WebElement lblFilterSelectionVerify() {
		WebElement txt_filterSelection = driver.findElement(txtfilterSelection);
		return txt_filterSelection;

	}
}
