package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class MngLocRepository {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public MngLocRepository(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column']/li[9]/a/p")
	WebElement mngLocMenu;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[6]/a[1]")
	WebElement editBtn;

	@FindBy(id = "st_id")
	WebElement editState;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement updateBtn;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[3]")
	WebElement stateTxt;
	
	 @FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[5]/a//span[@class='badge bg-success']")
	 WebElement statusBtn;
	 
	 @FindBy(xpath="//td[text()='Street20']//following-sibling::td[text()='United Kingdom']//following-sibling::td[text()='Craven Arms']//following-sibling::td[contains(text(),'100')]")
	 WebElement txtCharge;

	 @FindBy(css="a[class='btn btn-rounded btn-danger']")
	 WebElement newBtn;
	 
	 @FindBy(id="country_id")
	 WebElement dropdownCountry;
	 
	 @FindBy(id="st_id")
	 WebElement dropdownState;
	 
	 @FindBy(id="location")
	 WebElement txtLocation;
	 
	 @FindBy(id="delivery")
	 WebElement txtDeliveryCharge;
	 
	 
	 @FindBy(xpath="//button[@type='submit']")
	 WebElement saveBtn;
	 
	 @FindBy(xpath="//div[contains(@class,'alert alert-success alert-dismissible')]")
	 WebElement popupMsg;
	 
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[6]/a[2]/i")
	WebElement delLink;
	 
	 
	public String getState() throws InterruptedException {
		gu.getClickElement(mngLocMenu);
		gu.getClickElement(editBtn);
		gu.selectFuncbyVisibletext(editState, "Bristol");
		gu.getClickElement(updateBtn);
		gu.mediumDelay(3000);
		String stateText = gu.getElementText(stateTxt);
		return stateText;
	}
		
		public String getStatus()
		{
			gu.getClickElement(mngLocMenu);
			return gu.getElementText(statusBtn);
			
		}
		
		public String getStyle() {
			gu.getClickElement(mngLocMenu);
			return gu.stylePropertyValidation(statusBtn, "background-color");
		}
		
		public String getCharge()
		{
			gu.getClickElement(mngLocMenu);
			return gu.getElementText(txtCharge);
			
		}
		public boolean addLocation()
		{
			gu.getClickElement(mngLocMenu);
			gu.getClickElement(newBtn);
			gu.selectFuncbyindex(dropdownCountry, 1);
			gu.selectFuncbyVisibletext(dropdownState, "Craven Arms");
			gu.sendKey(txtLocation, "Street20");
			gu.sendKey(txtDeliveryCharge, "100");
			gu.getClickElement(saveBtn);
			return gu.isDisplay(popupMsg);
		}
		
		public boolean delLocation()
		{
			gu.getClickElement(mngLocMenu);
			gu.getClickElement(delLink);
			gu.alertHandlingaccept(driver);
			return gu.isDisplay(popupMsg);
			
		}
			
		}
	


