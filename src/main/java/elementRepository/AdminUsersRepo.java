package elementRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtilities;

public class AdminUsersRepo 
{
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	public AdminUsersRepo(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(id="user_type")
	WebElement userDropdown;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-users']")
			WebElement adminUsersMenu;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newBtn;
	
	@FindBy(id="username")
	WebElement usernameTxtBox;
	
	@FindBy(id="password")
	WebElement pwrdTxtbox;
	
	@FindBy(xpath="//button[@name='Create']")
	WebElement saveBtn;
	
@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
WebElement popupErrorMsg;
	
		public List<String> addUserList()
		{
			List<String>comp=new ArrayList();
			comp=gu.addList(comp,"Select");
			comp=gu.addList(comp,"Staff");
			comp=gu.addList(comp,"Admin");
			comp=gu.addList(comp,"Partner");
			comp=gu.addList(comp,"Delivery Boy");
			return comp;
		}
		Select selectObject;
		List<WebElement> userType=new ArrayList();
	public boolean compareUsertypes()

	{
		gu.scrollDownOperation(driver);
		gu.getClickElement(adminUsersMenu);
		gu.getClickElement(newBtn);
		List<String>expected=addUserList();
		Select selectObject=new Select(userDropdown);
		userType=gu.getAllOptions(selectObject);
		List<String>actual=gu.convertToStringList(userType);
		boolean status=gu.compareLists(actual ,expected);
		return status;
	
	}
	
	public boolean chkUniqueUsername()
	{
		gu.scrollDownOperation(driver);
		gu.getClickElement(adminUsersMenu);
		gu.getClickElement(newBtn);
		gu.sendKey(usernameTxtBox, "tester003");
		gu.sendKey(pwrdTxtbox, "tester");
		gu.selectFuncbyVisibletext(userDropdown, "Admin");
		gu.getClickElement(saveBtn);
		return gu.isDisplay(popupErrorMsg);
	}
}
