package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageDeliveryBoyPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "i[class='fas fa-bars']")
	WebElement bar;

	@FindBy(css = "a[class='btn btn-rounded btn-primary']")
	WebElement searchGenBtn;

	@FindBy(id = "ut")
	WebElement emailTextArea;

	@FindBy(xpath = "//i[@class='nav-icon fas fa-user-plus']")
	WebElement manageDelBoyBtn;

	@FindBy(css = "button[class='btn btn-block-sm btn-danger']")
	WebElement searchBtn;

	@FindBy(xpath = "//table/tbody/tr[1]/td[1]")
	WebElement nameFrmTble;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[7]/div/a")
	WebElement pwrdArea;

	@FindBy(css = "a[class='btn btn-rounded btn-warning']")
	// @FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")
	WebElement resetBtn;

	public String getBgColor() throws InterruptedException {

		gu.getClickElement(manageDelBoyBtn);
		gu.mediumDelay(3000);
		return gu.stylePropertyValidation(resetBtn, "background-color");
	}

	public String getNameAfterSearch() {

		gu.getClickElement(manageDelBoyBtn);
		gu.getClickElement(searchGenBtn);
		gu.sendKey(emailTextArea, "megha.123@gmail.com");
		gu.getClickElement(searchBtn);
		String name = gu.getElementText(nameFrmTble);
		return name;

	}

	public String getToolTip() {
		gu.getClickElement(bar);
		gu.getClickElement(manageDelBoyBtn);
		return gu.getToolTip(pwrdArea);

	}

}
