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

	@Test(priority=1)
	public void chkAddOffer() throws InterruptedException, IOException {
		lp = new LoginPage(driver);
		lp.presteps();
		moc = new MngOfferCodeRepo(driver);
		boolean actual = moc.addOffer();
		boolean expected = true;
		Assert.assertEquals(actual, expected, Constant.textErrorMsg);
		// System.out.println(actual);

	}

	@Test(priority=4)
	public void chkUrlPage() {
		lp = new LoginPage(driver);
		lp.presteps();
		moc = new MngOfferCodeRepo(driver);
		String url = moc.currentUrlPage();
		System.out.println(url);
	}

	@Test(priority=2)
	public void chkupdateOffer() {
		lp = new LoginPage(driver);
		lp.presteps();
		moc = new MngOfferCodeRepo(driver);
		String actual = moc.updateOffer();
		String expected = "10%";
		Assert.assertEquals(actual, expected, Constant.updateError);

	}
	
	@Test(priority=3)
	public void chkDelOffer() throws InterruptedException
	{
		lp = new LoginPage(driver);
	lp.presteps();
	moc = new MngOfferCodeRepo(driver);
	
	 boolean actual=moc.delOffer();
	 boolean expected=true;
	 Assert.assertEquals(actual, expected,Constant.delError);
	
		
	}
}
