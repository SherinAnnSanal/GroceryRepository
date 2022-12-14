package elementRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class MobSliderRepo {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public MobSliderRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column']/li[11]/a")
	WebElement mblSlideMenu;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]/img")
	WebElement firstCell;

	@FindBy(css = "h1[class='m-0 text-dark']")
	WebElement pgHead;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[2]/td[2]/a/span")
	WebElement statusBtn;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newBtn;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[2]/td[3]/a[1]")
	WebElement editBtn;

	@FindBy(xpath = "//form[@id='form']/div/div[2]/div/input")
	WebElement chooseFileBtn;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement updateBtn;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[2]/td[1]/img")
	WebElement imgCell;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement errorPopupMsg;

	@FindBy(css = "button[type='submit']")
	WebElement saveBtn;

	/*
	 * @FindBy(xpath =
	 * "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[2]/td[3]"
	 * ) WebElement stateTxt;
	 *
	 * @FindBy(
	 * xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[20]/td[4]"
	 * ) WebElement txtCharge;
	 */

	public boolean verifyImageUpload(String s) throws InterruptedException {
		gu.getClickElement(mblSlideMenu);
		gu.getClickElement(editBtn);
		gu.sendKey(chooseFileBtn, s);
		gu.mediumDelay(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		gu.getClickElement(updateBtn);

		// js.executeAsyncScript("arguments[0].click()",updateBtn);

		return gu.isDisplay(imgCell);

	}

	public boolean uploadBigSizeImage(String s) throws InterruptedException {
		gu.getClickElement(mblSlideMenu);
		gu.getClickElement(newBtn);
		gu.sendKey(chooseFileBtn, s);
		gu.getClickElement(saveBtn);
		gu.mediumDelay(3000);
		return gu.isDisplay(errorPopupMsg);

	}

	public String getTitle() {
		gu.getClickElement(mblSlideMenu);

		return gu.getElementText(pgHead);
	}

	public boolean chkStatusBtnPresent() {

		gu.getClickElement(mblSlideMenu);
		boolean status = gu.isDisplay(statusBtn);
		return status;

	}

	public String getBgColor() throws InterruptedException {

		gu.getClickElement(mblSlideMenu);
		gu.mediumDelay(3000);
		return gu.stylePropertyValidation(newBtn, "background-color");
	}

}
