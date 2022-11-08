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

	public List<WebElement> getListPayment() {
		gu.getClickElement(mngOrderMenu);
		gu.getClickElement(searchBtn);
		gu.selectFuncbyVisibletext(paymentDropdown, "Bank");
		String selected = gu.FirstSelectedOption(paymentDropdown);
		gu.getClickElement(searchBtn2);
		return listPayment;

	}
	

	public List<String> getListStatus() {
		List<String> list1 = new ArrayList();
		list1=gu.addList(list1,"Select");
		list1=gu.addList(list1,"Paid");
		list1=gu.addList(list1,"unpaid");
		list1=gu.addList(list1,"Delivered");
		list1=gu.addList(list1,"Out For Delivery");
		System.out.println("list:"+list1);
				return list1;

	}

	public boolean compStringToStrList(String s) {
		boolean flag = false;
		gu.getClickElement(mngOrderMenu);
		gu.getClickElement(searchBtn);
		String actual = gu.selectFuncbyVisibletext(statusDropdown, s);
		List<String> expected = getListStatus();
		if (expected.contains(actual)) {
			flag = true;
		}

		return flag;
		/*
		 * for(int i=0;i<expected.size();i++) { flag=false; if
		 * (actual.equals(expected.get(i))) { flag=true; break;
		 * 
		 * }
		 * 
		 * }
		 * 
		 * return flag; }
		 */

	}
}
