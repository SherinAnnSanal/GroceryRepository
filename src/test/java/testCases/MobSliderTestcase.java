package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.MobSliderRepo;

public class MobSliderTestcase extends BaseClass  
{
	LoginPage lp;
	MobSliderRepo ms;
  @Test
  public void chkImagePresent()
  {
	  lp=new LoginPage(driver);
	  lp.presteps();
	  ms=new MobSliderRepo(driver);
	  String img=ms.getImageSelected();
	  System.out.println(img);
  }
  
  @Test
  public void chkTitle()
  {
	  lp=new LoginPage(driver);
	  lp.presteps();
	  ms=new MobSliderRepo(driver);
	 String actual= ms.getTitle();
	 String expected="List Mobile Sliders";
	 Assert.assertEquals(actual,expected,Constant.titleErrorMsg);
  }
}
