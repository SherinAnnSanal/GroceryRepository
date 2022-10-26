package elementRepository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

public class MngOfferCodeRepo
{
	WebDriver driver;
	GeneralUtilities gu= new GeneralUtilities();
	Actions ac;
	Properties prop;
	
	public MngOfferCodeRepo(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//ul[@class='nav nav-pills nav-sidebar flex-column']/li[13]/a")
	WebElement mngOffercodeMenu;
	
	@FindBy(css="a[class='btn btn-rounded btn-danger']")
	WebElement newBtn;
	
	@FindBy(xpath="//input[@value='yes']")
	WebElement yesRadBtn;
	
	@FindBy(id="offer_code")
	WebElement codeTxt;
	
	@FindBy(id="offer_per")
	WebElement percentTxt;
	
	@FindBy(id="offer_price")
	WebElement amtTxt;
	
	@FindBy(xpath="//div[@class='note-editable card-block']")
	WebElement descTxt;
	
	@FindBy(id="main_img")
	WebElement fileUploadText;
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement saveBtn;
	
	//WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(40));//explicit wait
	public String addOffer() throws InterruptedException, IOException
	{
	gu.getClickElement(mngOffercodeMenu);
	gu.getClickElement(newBtn);
	gu.sendKey(codeTxt,"12345");
	gu.getClickElement(yesRadBtn);
	gu.sendKey(percentTxt, "5");;
	gu.sendKey(amtTxt,"4000");
	gu.sendKey(descTxt,"Summer Offer");
	prop = new Properties();
	FileInputStream fileIO = new FileInputStream(
			System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\Config.properties");
	
	prop.load(fileIO);
	String path=System.getProperty("user.dir") + prop.getProperty("imgPath");
	gu.sendKey(fileUploadText,path);
	gu.getClickElement(saveBtn);
	System.out.println("Hello ..saved");
	
	// w.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-danger']")));
	// ac=new Actions(driver);
//	ac.moveToElement(saveBtn).click().perform();
	return codeTxt.getText();
	
	}
	public String  currentUrlPage()
	{
	//return	gu.getUrlPage(driver);
		return driver.getCurrentUrl();
	}
	
	

}
