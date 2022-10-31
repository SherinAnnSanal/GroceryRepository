package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.MobSliderRepo;

public class MobSliderTestcase extends BaseClass {
	LoginPage lp;
	MobSliderRepo ms;

	@Test
	public void chkImagePresent() throws InterruptedException {
		lp = new LoginPage(driver);
		lp.presteps();
		ms = new MobSliderRepo(driver);
		String path=System.getProperty("user.dir") + "//src//main//resources//Images//image.jpg";
		boolean img = ms.verifyImageUpload(path);
		System.out.println(img);
	}

	@Test
	public void chkTitle() {
		lp = new LoginPage(driver);
		lp.presteps();
		ms = new MobSliderRepo(driver);
		String actual = ms.getTitle();
		String expected = "List Mobile Sliders";
		Assert.assertEquals(actual, expected, Constant.titleErrorMsg);
	}

	@Test
	public void chkStatus() {
		lp = new LoginPage(driver);
		lp.presteps();
		ms = new MobSliderRepo(driver);
		boolean actual = ms.chkStatusBtnPresent();
		boolean expected = true;
		Assert.assertEquals(actual, expected, Constant.StatusError);

	}

	@Test
	public void chkbgcolor() throws InterruptedException {
		lp = new LoginPage(driver);
		lp.presteps();
		ms = new MobSliderRepo(driver);
		String actual = ms.getBgColor();
		String expected = "rgba(220, 53, 69, 1)";
		Assert.assertEquals(actual, expected, Constant.StyleError);

	}
}
