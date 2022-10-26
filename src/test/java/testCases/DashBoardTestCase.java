package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.DashboardPage;
import elementRepository.LoginPage;

public class DashBoardTestCase extends BaseClass{
	LoginPage lp;
	DashboardPage dp;
	
  @Test(groups= {"SmokeTest"})
  public void checkProfileName()
  {
	  lp=new LoginPage(driver);
	  lp.presteps();
	  dp=new DashboardPage(driver);
	  String actual=dp.getProfileName();
	  String expected="Admin";
	  Assert.assertEquals(actual,expected,"Profile name is not admin");
	  
  }
  
  @Test
  public void checkColorHomeBtn()
  {
	  lp=new LoginPage(driver);
	  lp.presteps();
	  dp=new DashboardPage(driver);
	  String actual=dp.getColorHome();
	  //System.out.println(actual);
	  String expected="rgba(0, 123, 255, 1)";
	  Assert.assertEquals(actual,expected,"color of Home link is not as expected");
  }
  
  @Test
  public void checkEnableBar()
  {
	  lp=new LoginPage(driver);
	  lp.presteps();
	  dp=new DashboardPage(driver);
	  boolean actual=dp.getVerifyBar();
	  boolean expected=true;
	  Assert.assertEquals(actual,expected,"Button is not enabled");
	  
	  
  }
}
