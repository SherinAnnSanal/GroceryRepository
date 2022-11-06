package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.MngOfferCodeRepo;

public class MngOfferCodeTestcase extends BaseClass {

	LoginPage lp;
	MngOfferCodeRepo moc;

	@Test
	public void chkAddOffer() throws InterruptedException, IOException {
		lp = new LoginPage(driver);
		lp.presteps();
		moc = new MngOfferCodeRepo(driver);
		String actual = moc.addOffer();
		String expected="×\n"
				+ "Alert!\n"
				+ "Offer Created Successfully";
		Assert.assertEquals(actual, expected, Constant.textErrorMsg);
		//System.out.println(actual);

	}

	@Test
	public void chkUrlPage() {
		lp = new LoginPage(driver);
		lp.presteps();
		moc = new MngOfferCodeRepo(driver);
		String url = moc.currentUrlPage();
		System.out.println(url);
	}
}
