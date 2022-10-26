package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class LoginPage {
WebDriver driver;
ExcelRead excelUtility;
GeneralUtilities gu=new GeneralUtilities() ;

/*
 * public List<String> getLoginDetails() { excelUtility = new ExcelRead();
 * List<String> excelList = excelUtility.readDataFromExcel("Sheet1"); return
 * excelList; }
 */

    

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public List<String> getLoginDetails() {
		excelUtility = new ExcelRead();
		List<String> excelList = excelUtility.readDataFromExcel("Sheet1");
		return excelList;
	}

    

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement userName;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
    WebElement signin;

    @FindBy(xpath = "//a[@data-toggle='dropdown']")
    WebElement profileName;

    @FindBy(xpath = "//label[contains(text(),'Remember Me')]")
    WebElement rememberCheckBox;

    @FindBy(xpath = "//input[@id='remember']")
    WebElement verificationOfRememberCheckBox;

    public void getUserName(String username) {
        userName.sendKeys(username);
    }

    public void getPassWord(String password1) {
        password.sendKeys(password1);
    }

    public void clickSignin() {
    signin.click();
        // signin.click()
    }

 public boolean getRememberMe()
 {
	 return gu.isSelected(verificationOfRememberCheckBox);
 }

    public String profileVerification() {
        //return profileName.getText();
    	return gu.getElementText(profileName);
    }

    
    

    

    public void presteps() {
        getUserName("admin");
        getPassWord("admin");
        clickSignin();
       
    }
    
    public boolean textArea_username()
    {
    	return userName.isEnabled();
    }

}


