package elementRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputFilter.Config;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GeneralUtilities;

public class MngExpenseRepositoryPage {

	WebDriver driver;
	public static Properties prop;
	GeneralUtilities gu = new GeneralUtilities();
	Robot rob;
	//WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(20));
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
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement updateBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']/h5")
	WebElement popupMsg;

	public String getStyleSearchBtn() {
		gu.getClickElement(MngExpenseMenu);
		gu.getClickElement(MngExpenseOption);

		String fontSize = gu.stylePropertyValidation(searchBtn, "font-size");
		
		return fontSize;
	}

	public String getStyleResetBtn() {
		gu.getClickElement(MngExpenseMenu);
		gu.getClickElement(MngExpenseOption);

		String bgColor123 = gu.stylePropertyValidation(resetBtn, "background-color");
		return bgColor123;
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

	
	  public void fileUpload() throws AWTException, IOException {
	  
	  //gu.getClickElement(MngExpenseMenu);
	  //gu.getClickElement(MngExpenseOption);
	  //gu.getClickElement(editBtn); gu.getClickElement(fileUploadBtn);
		  rob=new Robot();
	  MngExpenseMenu.click();
	  MngExpenseOption.click(); 
	  editBtn.click();
	 
	 // fileUploadBtn.click();
	 
	 
	  Actions ac=new Actions(driver);
	  ac.moveToElement(fileUploadBtn).click().perform();
	  prop = new Properties();
		FileInputStream fileIO = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\Config.properties");
		
		prop.load(fileIO);
		String path=System.getProperty("user.dir") + prop.getProperty("imgPath");
	  StringSelection ss=new StringSelection(path);
	  System.out.println(path);
	  System.out.println(ss);
	 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	 rob.delay(300); 
	  rob.keyPress(KeyEvent.VK_CONTROL);
	  rob.keyPress(KeyEvent.VK_V);
	  rob.keyRelease(KeyEvent.VK_V);
	  rob.keyRelease(KeyEvent.VK_CONTROL);
	  rob.delay(300);
	  rob.keyPress(KeyEvent.VK_ENTER);
	  rob.keyRelease(KeyEvent.VK_ENTER);
	  //gu.getClickElement(updateBtn);
	ac.moveToElement(updateBtn).click().perform();
	rob.delay(500);
	//w.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success alert-dismissible']/h5"))));
	System.out.println(popupMsg);
	  //return popupMsg.getText();
	  
	  }
	 

	 /* public void fileUpload(WebElement element) { Robot rob=new Robot();
	 * //WebElement upload=driver.findElement(By.id("uploadfile_0")); Actions ac=new
	 * Actions(driver); ac.moveToElement(element).click().perform();
	 * //upload.click();
	 * 
	 * StringSelection ss = new
	 * StringSelection("C:\\Users\\sanal\\Desktop\\image.jpg");
	 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	 * rob.delay(300); rob.keyPress(KeyEvent.VK_CONTROL);
	 * rob.keyPress(KeyEvent.VK_V); rob.keyRelease(KeyEvent.VK_V);
	 * rob.keyRelease(KeyEvent.VK_CONTROL); rob.keyPress(KeyEvent.VK_ENTER);
	 * rob.delay(300); rob.keyRelease(KeyEvent.VK_ENTER);
	 * 
	 * }
	 */
}
