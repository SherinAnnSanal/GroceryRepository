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
		String path = System.getProperty("user.dir") + "//src//main//resources//Images//image.jpg";
		boolean actual = ms.verifyImageUpload(path);
		boolean expected = true;
		Assert.assertEquals(actual, expected, Constant.uploadError);
	}

	@Test
	public void uploadBigImage() throws InterruptedException {
		lp = new LoginPage(driver);
		lp.presteps();
		ms = new MobSliderRepo(driver);
		String imgPath = System.getProperty("user.dir") + "//src/main//resources//Images//DSC02642.JPG";
		boolean actual = ms.uploadBigSizeImage(imgPath);
		boolean expected = true;
		Assert.assertEquals(actual, expected, Constant.uploadError);

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
		Assert.assertEquals(actual, expected, Constant.statusError);

	}

	@Test
	public void chkbgcolor() throws InterruptedException {
		lp = new LoginPage(driver);
		lp.presteps();
		ms = new MobSliderRepo(driver);
		String actual = ms.getBgColor();
		String expected = "rgba(220, 53, 69, 1)";
		Assert.assertEquals(actual, expected, Constant.styleError);

	}
}
