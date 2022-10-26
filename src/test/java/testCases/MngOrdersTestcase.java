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
			Assert.assertEquals(actual.get(i).getText(), expected, Constant.SelectError);

	}

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "Select" }, { "Paid2" }, { "Delivered" } };
	}

	@Test(dataProvider = "data-provider")
	public void chkElementsStatus(String value) {
		lp = new LoginPage(driver);
		lp.presteps();
		mo = new MngOrdersRepo(driver);
		List<String> actual = mo.getListStatus();
		String expected = mo.getSelectedStatus(value);
		for (int i = 0; i < actual.size(); i++) {
			Assert.assertEquals(actual.get(i), expected, Constant.SelectError);

		}
		// System.out.println("Hai");

	}

}
