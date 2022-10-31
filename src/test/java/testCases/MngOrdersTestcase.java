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
		return new Object[][] { { "Select" }, { "Paid" }, { "Delivered" } };
	}

	@Test(dataProvider = "data-provider")
	public void chkElementsStatus(String value) {
		lp = new LoginPage(driver);
		lp.presteps();
		mo = new MngOrdersRepo(driver);
		System.out.println("List in testcase");
		List<String> expected = mo.getListStatus();
		//System.out.println(expected);
		String actual = mo.getSelectedStatus(value);
		//System.out.println("expected selected in testcase: "+expected);
		for (int i = 0; i < expected.size(); i++) {
			Assert.assertEquals(actual,expected.get(i),Constant.SelectError);

		}
		// System.out.println("Hai");

	}

}
