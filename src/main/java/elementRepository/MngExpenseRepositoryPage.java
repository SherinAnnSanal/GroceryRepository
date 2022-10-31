package elementRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;

public class MngExpenseRepositoryPage {

	WebDriver driver;
	public static Properties prop;
	GeneralUtilities gu = new GeneralUtilities();
	Robot rob;

	// WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(20));
	public MngExpenseRepositoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column']/li[2]/a/p")
	WebElement MngExpenseMenu;

	@FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column']/li[2]/ul[2]/li/a/p")
	WebElement MngExpenseOption;

	@FindBy(css = "a[class='btn btn-rounded btn-primary']")
	WebElement searchBtn;

	@FindBy(css = "a[class='btn btn-rounded btn-warning']")
	WebElement resetBtn;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[7]/td[9]/a[1]")
	WebElement editBtn;

	@FindBy(id = "ex_date")
	WebElement dateTxtBox;

	@FindBy(xpath = "//form[@id='form']/div/div[1]/div[9]/input")
	WebElement fileUploadBtn;

	@FindBy(xpath = "div[class='datepicker-days'] th[class='datepicker-switch']")
	WebElement monthCalendar;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement updateBtn;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement popupMsg;

	@FindBy(xpath = "//div[@class='datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-bottom']")
	WebElement calendar;

	public String getStyleSearchBtn() {
		gu.getClickElement(MngExpenseMenu);
		gu.getClickElement(MngExpenseOption);

		String fontSize = gu.stylePropertyValidation(searchBtn, "font-size");

		return fontSize;
	}

	public String getStyleResetBtn() {
		gu.getClickElement(MngExpenseMenu);
		gu.getClickElement(MngExpenseOption);

		String bgColor = gu.stylePropertyValidation(resetBtn, "background-color");
		return bgColor;
	}

	/*
	 * public String editCalendar() { gu.getClickElement(MngExpenseMenu);
	 * gu.getClickElement(MngExpenseOption); gu.getClickElement(editBtn);
	 * gu.getClickElement(dateTxtBox);
	 * while(!driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText
	 * ().contains("April"))//also can use equalsIgnoreCase instead of contains {
	 * driver.findElement(By.
	 * xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); }
	 * 
	 * int count=driver.findElements(By.className("ui-state-default")).size();
	 * for(int i=0;i<count;i++) { String
	 * text=driver.findElements(By.className("ui-state-default")).get(i).getText();
	 * if(text.equalsIgnoreCase("27")) {
	 * driver.findElements(By.className("ui-state-default")).get(i).click(); break;
	 * }
	 * 
	 * }
	 */

	public String fileUpload(String image) throws AWTException, IOException, InterruptedException {

		gu.getClickElement(MngExpenseMenu);
		gu.getClickElement(MngExpenseOption);
		gu.getClickElement(editBtn);
		rob = new Robot();
		gu.mediumDelay(3000);

		WebElement click = driver.findElement(By.xpath("//*[@type='file']"));
		Actions a = new Actions(driver);
		a.moveToElement(click).click().perform();
		gu.mediumDelay(3000);

		StringSelection ss = new StringSelection(image);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rob.delay(250);

		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.delay(250);
		rob.keyRelease(KeyEvent.VK_ENTER);
		gu.mediumDelay(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		gu.mediumDelay(3000);

		gu.getClickElement(updateBtn);
		return gu.getElementText(popupMsg);

	}

}
