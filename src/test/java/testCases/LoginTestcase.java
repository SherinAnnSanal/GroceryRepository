package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;

public class LoginTestcase extends BaseClass {

	LoginPage lp;
	List<String>loginList;

	@DataProvider(name = "data")
	private Object[][] getUserData() {
		return new Object[][] { { "admin", "admin" }, { "admin2", "admin3" }};
	}

	@Test
	//(dataProvider = "data")
	//public void verifyLoggedUsers(String username, String Password) throws InterruptedException 
	public void verifyLoggedUsers() throws InterruptedException 
	{
		lp = new LoginPage(driver);
		
		//Test data from excel file
		loginList=lp.getLoginDetails();
		lp.getUserName(loginList.get(0));
		lp.getPassWord(loginList.get(1));
		//Direct Login
		/* 
		 * lp.getUserName(username); lp.getPassWord(Password);
		 */
		lp.clickSignin();

		// lp.presteps();

		String actual = lp.profileVerification();
		String expected = "Admin";
		Assert.assertEquals(expected, actual,Constant.titleErrorMsg);

	}

	@Test(groups={"SmokeTest"})
	public void verifyLoggedUsers1() throws InterruptedException {
		lp = new LoginPage(driver);
		boolean actual = lp.textArea_username();
		boolean expected = true;
		Assert.assertEquals(actual, expected, "textarea is disbaled");

	}
	
	@Test
	public void verifyCheckBox() throws InterruptedException {
		lp = new LoginPage(driver);
		boolean actual = lp.getRememberMe();
		boolean expected = false;
		Assert.assertEquals(actual, expected, "RememberMe checkbox is selected");

	}
	
	
	/*
	 * @Test public void verifyDashboardElements() { DashboardPage dp=new
	 * DashboardPage(driver); String actual=dp.getColorHome(); String expected =
	 * "Admin"; Assert.assertEquals(expected, actual, "color is not same");
	 * 
	 * }
	 */

}
