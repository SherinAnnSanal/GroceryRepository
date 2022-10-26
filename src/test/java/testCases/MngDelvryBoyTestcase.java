package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageDeliveryBoyPage;

public class MngDelvryBoyTestcase extends BaseClass{
	
LoginPage lp;
ManageDeliveryBoyPage mngDB;

  @Test
  public void chkBgColor() throws InterruptedException
  {
	  lp=new LoginPage(driver);
	  lp.presteps();
	  mngDB=new ManageDeliveryBoyPage(driver);
	  
	  
	  String actual=mngDB.getBgColor();
	//  System.out.println("bgcolor=" +actual);
	  String expected="rgba(255, 193, 7, 1)";
	  Assert.assertEquals(actual,expected,Constant.bgColorErrorMsg);
  }
  
  @Test
  public void chkToolTip()
  {
	  lp=new LoginPage(driver);
	  lp.presteps();
	  mngDB=new ManageDeliveryBoyPage(driver);
	  
	  String actual=mngDB.getToolTip();
	  System.out.println(actual);
	  String expected="Show Details";
	  Assert.assertEquals(actual,expected,Constant.titleErrorMsg);
	  
  }
  
  @Test
  public void chkName()
  {
	  lp=new LoginPage(driver);
	  lp.presteps();
	  mngDB=new ManageDeliveryBoyPage(driver);
	  
	  String actual= mngDB.getNameAfterSearch();
	  //System.out.println(actual);
	  String expected="Megha";
	  Assert.assertEquals(actual,expected,Constant.profileNameErrorMsg);
	  
  }
  
}
