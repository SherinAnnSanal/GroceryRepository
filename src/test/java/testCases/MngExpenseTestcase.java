package testCases;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.MngExpenseRepositoryPage;

public class MngExpenseTestcase extends BaseClass {
	LoginPage lp;
	MngExpenseRepositoryPage expOb;
	
	
	  public static void testBasic() throws IOException 
	  {
		  prop = new Properties();
	  FileInputStream fileIO = new FileInputStream( System.getProperty("user.dir")+ "\\src\\main\\resources\\Properties\\Config.properties");
	  
	  prop.load(fileIO);
	  }
	 


	@Test
	public void chkresetBtn() {
		lp = new LoginPage(driver);
		lp.presteps();
		expOb = new MngExpenseRepositoryPage(driver);

		String actual = expOb.getStyleResetBtn();
		// System.out.println("BG color :"+actual);
		String expected = "rgba(255, 193, 7, 1)";
		Assert.assertEquals(actual, expected, Constant.bgColorErrorMsg);
	}

 @Test
	public void chkSearchBtn() {
		lp = new LoginPage(driver);
		lp.presteps();
		expOb = new MngExpenseRepositoryPage(driver);

		String actual = expOb.getStyleSearchBtn();
		String expected = "16px";
		Assert.assertEquals(actual, expected, Constant.styleError);

	}

	@Test
	public void chkFileUpload() throws AWTException, IOException, InterruptedException {

		testBasic();
		String image = System.getProperty("user.dir") + prop.getProperty("imgPath");
		lp = new LoginPage(driver);
		lp.presteps();
		expOb = new MngExpenseRepositoryPage(driver);

		boolean actual = expOb.fileUpload(image);
		
		boolean expected = true;
		Assert.assertEquals(actual, expected,Constant.textErrorMsg);
	}
@Test
public void chkCalendar() throws InterruptedException
{
	lp = new LoginPage(driver);
	lp.presteps();
	expOb = new MngExpenseRepositoryPage(driver);
	expOb.setDate();

	
	
}
}
