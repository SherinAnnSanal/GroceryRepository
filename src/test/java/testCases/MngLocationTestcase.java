package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.MngLocRepository;

public class MngLocationTestcase extends BaseClass {
	
	LoginPage lp;
	  
	  MngLocRepository mL;
	  
  @Test(priority=5)
  public void chkStateselected() throws InterruptedException 
  {
	  LoginPage lp=new LoginPage(driver);
	  lp.presteps();
	  MngLocRepository mL=new MngLocRepository(driver);
	  String actual=mL.getState();
	 
	  String expected="Bristol";
	 Assert.assertEquals(actual,expected,Constant.textErrorMsg);
	  
  }
  
  @Test(priority=3)
  public void chkStatus()
  {
	   lp=new LoginPage(driver);
	  lp.presteps();
	  mL=new MngLocRepository(driver);
	  String actual=mL.getStatus();
	  	 String expected="Active";
	 Assert.assertEquals(actual,expected,Constant.textErrorMsg);
	  
  }
  @Test(priority=2)
  public void getBgColor() {
	  lp=new LoginPage(driver);
	  lp.presteps();
	   mL=new MngLocRepository(driver);
	  String actual=mL.getStyle();
	  String expected="rgba(40, 167, 69, 1)";
	 Assert.assertEquals(actual,expected,Constant.styleError);
	  
	  
  }
  
	/*
	 * @DataProvider(name="locationParameters") public object[][] location() {
	 * return new object[][] {{"United Kingdom",""Street20","100"}} }
	 */
  @Test(priority=1)
  public void chkAddLocation()
  {
	  lp=new LoginPage(driver);
	  lp.presteps();
	   mL=new MngLocRepository(driver);
	   boolean actual=mL.addLocation();
	   boolean expected= true;
	   Assert.assertEquals(actual, expected,Constant.addError);
	   
  }
  
  @Test(priority=6)
  public  void chkDelLocation()
  {
	  lp=new LoginPage(driver);
	  lp.presteps();
	   mL=new MngLocRepository(driver);
	   boolean actual=mL.delLocation();
	   boolean expected=true;
	   Assert.assertEquals(actual, expected,Constant.delError);
	   
	   
  }
  
  @Test(priority=4)
  public void getDelCharge() {
	  lp=new LoginPage(driver);
	  lp.presteps();
	   mL=new MngLocRepository(driver);
	  String actual=mL.getCharge();
	  	String expected="₹100";
	Assert.assertEquals(actual,expected,Constant.textErrorMsg);
	  
	  
  }
}
