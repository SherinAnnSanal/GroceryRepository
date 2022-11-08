package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.PushNotificationElemntPage;

public class PushNotificationTestcase extends BaseClass {
	LoginPage lp;
	PushNotificationElemntPage pushObj;

	@Test
	public void chkBgColor() {
		lp = new LoginPage(driver);
		lp.presteps();
		pushObj = new PushNotificationElemntPage(driver);

		String actual = pushObj.getBgColor();
		// System.out.println(actual);
		String expected = "rgba(23, 162, 184, 1)";
		Assert.assertEquals(actual, expected, Constant.bgColorErrorMsg);
	}

	@Test
	public void chkText() {
		lp = new LoginPage(driver);
		lp.presteps();
		pushObj = new PushNotificationElemntPage(driver);

		String actual = pushObj.getTitle();
		String expected = "Push Notifications";
		Assert.assertEquals(actual, expected, Constant.titleErrorMsg);

	}

	@Test
	public void chkMsg() {
		lp = new LoginPage(driver);
		lp.presteps();
		pushObj = new PushNotificationElemntPage(driver);

		boolean actual = pushObj.getMsgfromAlert();
		boolean expected = true;
		Assert.assertEquals(expected, actual, Constant.textErrorMsg);

	}

}
