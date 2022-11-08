package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.MngOrdersRepo;

public class MngOrdersTestcase extends BaseClass {

	LoginPage lp;
	MngOrdersRepo mo;

	@Test
	public void chkSrchByPaymentMode() {
		lp = new LoginPage(driver);
		lp.presteps();
		mo = new MngOrdersRepo(driver);
		List<WebElement> actual = mo.getListPayment();
		String expected = "Bank";// mo.getSelectedPayment();
		for (int i = 0; i < actual.size(); i++)
			Assert.assertEquals(actual.get(i).getText(), expected, Constant.selectError);

	}

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "Select" }, { "Out For Delivery" }, { "Delivered" } };
	}

	@Test(dataProvider = "data-provider")
	public void chkElementsStatus(String value) {
		lp = new LoginPage(driver);
		lp.presteps();
		mo = new MngOrdersRepo(driver);
		boolean actual=mo.compStringToStrList(value);
		boolean expected=true;
		
			Assert.assertEquals(actual, expected, Constant.selectError);

		}
		// System.out.println("Hai");

	

}
