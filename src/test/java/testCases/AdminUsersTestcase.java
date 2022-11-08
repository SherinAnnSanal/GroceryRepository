package testCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.AdminUsersRepo;
import elementRepository.LoginPage;

public class AdminUsersTestcase extends BaseClass {
	
	LoginPage lp;
	AdminUsersRepo ad;
	
  @Test
  public void compUserTypes() 
  {
	  lp = new LoginPage(driver);
	  ad=new AdminUsersRepo(driver);
		lp.presteps();
		boolean actual=ad.compareUsertypes();
		boolean exected=true;
		Assert.assertEquals(actual, exected,Constant.dropdownItemsError );
		
		
	  
  }
  
  @Test
  public void validateUniqueUserName()
  {
	  lp = new LoginPage(driver);
	  ad=new AdminUsersRepo(driver);
		lp.presteps();
		boolean actual=ad.chkUniqueUsername();
		boolean expected=true;
		Assert.assertEquals(actual,expected,Constant.notUniqueError);
  }
}
