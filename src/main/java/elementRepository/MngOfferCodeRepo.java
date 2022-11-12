package elementRepository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GeneralUtilities;

public class MngOfferCodeRepo {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	Actions ac;
	Properties prop;

	public MngOfferCodeRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column']/li[13]/a")
	WebElement mngOffercodeMenu;

	@FindBy(css = "a[class='btn btn-rounded btn-danger']")
	WebElement newBtn;

	@FindBy(xpath = "//input[@value='yes']")
	WebElement yesRadBtn;

	@FindBy(css = "input[value='no']")
	WebElement noRadBtn;

	@FindBy(id = "offer_code")
	WebElement codeTxt;

	@FindBy(id = "offer_per")
	WebElement percentTxt;

	@FindBy(id = "offer_price")
	WebElement amtTxt;

	@FindBy(xpath = "//div[@class='note-editable card-block']")
	WebElement descTxt;

	@FindBy(id = "main_img")
	WebElement fileUploadText;

	@FindBy(xpath = " //button[@type='submit']")
	WebElement saveBtn;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement popupMsg;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[contains(text(),'12345')]//following-sibling::td[5]//a[1]")
	WebElement updateTableBtn;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[contains(text(),'12345')]//following-sibling::td[5]//a[2]")
	WebElement delBtn;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement updateBtn;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[contains(text(),'12345')]")
	WebElement codeCell;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[contains(text(),'12345')]//following-sibling::td[1]")
	WebElement percentCell;
	
	
	public boolean addOffer() throws InterruptedException, IOException {
		gu.getClickElement(mngOffercodeMenu);
		gu.getClickElement(newBtn);
		gu.sendKey(codeTxt, "12345");
		gu.getClickElement(noRadBtn);
		gu.sendKey(percentTxt, "5");
		gu.sendKey(amtTxt, "4000");
		gu.sendKey(descTxt, "Summer Offer");
		prop = new Properties();
		FileInputStream fileIO = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\Config.properties");

		prop.load(fileIO);
		String path = System.getProperty("user.dir") + prop.getProperty("imgPath");

		gu.sendKey(fileUploadText, path);

		// gu.scrollDownOperation(driver);
//	System.out.println("scrolled down");
		// gu.getClickElement(saveBtn);
		// System.out.println("Hello ..saved");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 250)"); // if the element is on bottom.
		jse.executeScript("arguments[0].click();", saveBtn);

		return gu.isDisplay(popupMsg);

	}

	public String currentUrlPage() {
		// return gu.getUrlPage(driver);
		return driver.getCurrentUrl();
	}

	public boolean delOffer() throws InterruptedException {

		gu.getClickElement(mngOffercodeMenu);
		gu.getClickElement(delBtn);
		gu.alertHandlingaccept(driver);
		gu.mediumDelay(3000);
		return gu.isDisplay(popupMsg);
	}

	public String updateOffer() {
		gu.getClickElement(mngOffercodeMenu);
		gu.getClickElement(updateTableBtn);
		percentTxt.clear();
		gu.sendKey(percentTxt, "10");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 250)"); // if the element is on bottom.
		jse.executeScript("arguments[0].click();", updateBtn);

		return gu.getElementText(percentCell);

	}

}
