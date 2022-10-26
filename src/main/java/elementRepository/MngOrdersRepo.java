package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

import utilities.GeneralUtilities;

public class MngOrdersRepo {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	// WebDriverWait w = new WebDriverWait(driver,
	// Duration.ofSeconds(30));//explicit wait
	public MngOrdersRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column']/li[3]/a/p")
	WebElement mngOrderMenu;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchBtn;

	@FindBy(id = "pt")
	WebElement paymentDropdown;

	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchBtn2;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[5]")
	List<WebElement> listPayment;

	@FindBy(id = "st")
	WebElement statusDropdown;

	public String getSelectedPayment() {
		gu.getClickElement(mngOrderMenu);
		gu.getClickElement(searchBtn);
		gu.selectFuncbyVisibletext(paymentDropdown, "Bank");
		String selected = gu.FirstSelectedOption(paymentDropdown);
		gu.getClickElement(searchBtn2);
		return selected;
	}

	public List getListPayment() {
		gu.getClickElement(mngOrderMenu);
		gu.getClickElement(searchBtn);
		gu.selectFuncbyVisibletext(paymentDropdown, "Bank");
		String selected = gu.FirstSelectedOption(paymentDropdown);
		gu.getClickElement(searchBtn2);
		return listPayment;

	}

	public String getSelectedStatus(String s) {
		gu.getClickElement(mngOrderMenu);
		gu.getClickElement(searchBtn);
		gu.selectFuncbyVisibletext(statusDropdown, s);
		String selected = gu.FirstSelectedOption(statusDropdown);
		gu.getClickElement(searchBtn2);

		return selected;
	}

	public List<String> getListStatus() {
		List<String> li = new ArrayList();
//li=	gu.addList("Select","Paid","UnPaid","Delivered","Out for Delivery");
		gu.addList("Paid");
		gu.addList("UnPaid");
		gu.addList("Delivered");
		gu.addList("Out for Delivery");

		return li;
	}

}
