package testCases;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.MngExpenseRepositoryPage;

public class MngExpenseTestcase extends BaseClass {
	LoginPage lp;
	MngExpenseRepositoryPage expOb;

	// @Test
	public void chkresetBtn() {
		lp = new LoginPage(driver);
		lp.presteps();
		expOb = new MngExpenseRepositoryPage(driver);

		String actual = expOb.getStyleResetBtn();
		// System.out.println("BG color :"+actual);
		String expected = "rgba(255, 193, 7, 1)";
		Assert.assertEquals(actual, expected, Constant.bgColorErrorMsg);
	}

	// @Test
	public void chkSearchBtn() {
		lp = new LoginPage(driver);
		lp.presteps();
		expOb = new MngExpenseRepositoryPage(driver);

		String actual = expOb.getStyleSearchBtn();
		String expected = "16px";
		Assert.assertEquals(actual, expected, Constant.StyleError);

	}

	@Test
	public void chkFileUpload() throws AWTException, IOException {
		lp = new LoginPage(driver);
		lp.presteps();
		expOb = new MngExpenseRepositoryPage(driver);

		 expOb.fileUpload();
		//System.out.println(actual);
	}

}
