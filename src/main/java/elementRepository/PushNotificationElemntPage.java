package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class PushNotificationElemntPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public PushNotificationElemntPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "i[class='nav-icon fas fa-fas fa-bell']")
	WebElement PushMenu;

	@FindBy(css = "h1[class='m-0 text-dark']")
	WebElement pageTitle;

	@FindBy(css = "button[name='create']")
	WebElement sendBtn;

	@FindBy(id = "title")
	WebElement titleTxtBox;

	@FindBy(id = "description")
	WebElement descTxtBox;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement msg;

	public String getTitle() {
		gu.getClickElement(PushMenu);
		return gu.getElementText(pageTitle);
	}

	public String getBgColor() {

		gu.getClickElement(PushMenu);
		return gu.stylePropertyValidation(sendBtn, "background-color");

	}

	public boolean getMsgfromAlert() {
		gu.getClickElement(PushMenu);
		gu.sendKey(titleTxtBox, "Offers");
		gu.sendKey(descTxtBox, "Summer Offer:50%");
		gu.getClickElement(sendBtn);
		return gu.isDisplay(msg);

	}

}
