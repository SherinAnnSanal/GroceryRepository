package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.MngLocRepository;

public class MngLocationTestcase extends BaseClass {
	
	LoginPage lp;
	  
	  MngLocRepository mL;
	  
  @Test
  public void chkStateselected() throws InterruptedException 
  {
	  LoginPage lp=new LoginPage(driver);
	  lp.presteps();
	  MngLocRepository mL=new MngLocRepository(driver);
	  String actual=mL.getState();
	 
	  String expected="Bristol";
	 Assert.assertEquals(actual,expected,Constant.textErrorMsg);
	  
  }
  
  @Test
  public void chkStatus()
  {
	   lp=new LoginPage(driver);
	  lp.presteps();
	  mL=new MngLocRepository(driver);
	  String actual=mL.getStatus();
	  	 String expected="active";
	 Assert.assertEquals(actual,expected,Constant.textErrorMsg);
	  
  }
  @Test
  public void getBgColor() {
	  lp=new LoginPage(driver);
	  lp.presteps();
	   mL=new MngLocRepository(driver);
	  String actual=mL.getStyle();
	  	 String expected="rgba(255, 193, 7, 1)";
	 Assert.assertEquals(actual,expected,Constant.StyleError);
	  
	  
  }
  
  @Test
  public void getDelCharge() {
	  lp=new LoginPage(driver);
	  lp.presteps();
	   mL=new MngLocRepository(driver);
	  String actual=mL.getCharge();
	  System.out.println(actual);
	  	String expected="₹50";
	Assert.assertEquals(actual,expected,Constant.textErrorMsg);
	  
	  
  }
}
