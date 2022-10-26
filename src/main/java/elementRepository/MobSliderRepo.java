package elementRepository;

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
	
	
	  @FindBy(xpath ="//ul[@class='nav nav-pills nav-sidebar flex-column']/li[11]/a")
	  WebElement  mblSlideMenu;
	 
	 
@FindBy(xpath =
	  "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]/img")
	WebElement firstCell;
	 
	   @FindBy(css= "h1[class='m-0 text-dark']") 
	   WebElement pgHead ;
	  
	/* @FindBy(xpath = "//button[@class='btn btn-danger']") WebElement updateBtn;
	 * 
	 * @FindBy(xpath =
	 * "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[2]/td[3]"
	 * ) WebElement stateTxt;
	 * 
	 * @FindBy(
	 * xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[2]/td[5]/a/span"
	 * ) WebElement statusBtn;
	 * 
	 * 
	 * @FindBy(
	 * xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[20]/td[4]"
	 * ) WebElement txtCharge;
	 */
	  
	  public String getImageSelected()
	  {
		  gu.getClickElement(mblSlideMenu);
		  System.out.println(gu.getElementText(firstCell));
		 return  gu.getElementText(firstCell);
		  
	  }
	  
	  public String getTitle()
	  {
		  gu.getClickElement(mblSlideMenu);
		  
		  return gu.getElementText(pgHead);
	  }

}
