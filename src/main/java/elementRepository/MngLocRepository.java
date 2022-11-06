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
	
	 @FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[4]/td[5]/a/span")
	 WebElement statusBtn;
	 
	 @FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[20]/td[4]")
	 WebElement txtCharge;

	public String getState() throws InterruptedException {
		gu.getClickElement(mngLocMenu);
		gu.getClickElement(editBtn);
		gu.selectFuncbyVisibletext(editState, "Bristol");
		System.out.println(gu.FirstSelectedOption(editState));
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
			
		}
	


