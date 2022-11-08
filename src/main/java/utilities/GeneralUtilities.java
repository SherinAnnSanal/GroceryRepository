package utilities;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public boolean isDisplay(WebElement element) {
		boolean status = element.isDisplayed();
		return status;
	}

	public boolean isEnabled(WebElement element) {
		boolean status = element.isEnabled();
		return status;
	}

	public void sendKey(WebElement element, String s) {
		element.sendKeys(s);
	}

	public String getToolTip(WebElement element) {
		return element.getAttribute("title");
	}

	public void getClickElement(WebElement element) {
		element.click();
	}

	public void mediumDelay(int x) throws InterruptedException {
		Thread.sleep(x);
	}

	public void selectFuncbyindex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);

	}

	public void selectFuncbyValue(WebElement element, String value) {
		Select select1 = new Select(element);
		select1.selectByValue(value);

	}

	public String selectFuncbyVisibletext(WebElement element, String visibletext) {
		Select select = new Select(element);
		select.selectByVisibleText(visibletext);
		WebElement selectedValue = select.getFirstSelectedOption();
		// List <WebElement>dropList=select.getOptions();
		return (selectedValue.getText());

	}

	public String FirstSelectedOption(WebElement element) {
		Select select1 = new Select(element);
		String firstoption = select1.getFirstSelectedOption().getText();
		return (firstoption);
	}

	public List<WebElement> getAllOptions(Select s) {

		List<WebElement> op = s.getOptions();

		return op;

	}
	
	
	public List<String> convertToStringList(List<WebElement> weList) {
		List<String> strList = new ArrayList<String>();
		for (int i = 0; i < weList.size(); i++) {

			strList.add(weList.get(i).getText());
		}

		return strList;

	}

	
	public String stylePropertyValidation(WebElement element, String propertyType) {
		return element.getCssValue(propertyType);
	}

	public boolean isSelected(WebElement element) {
		return element.isSelected();
	}

	//List<String> list = new ArrayList<>();

	public List<String> addList(List<String>list,String s) {

		list.add(s);

		return list;
	}
	public void alertHandlingaccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public String alerttext(WebDriver driver) {
		return (driver.switchTo().alert().getText());
	}

	public void scrollDownOperation(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2500)");
	}
	public boolean getElementTextList(List<WebElement> chkList, String element) {

		boolean value = true;
		for (int i = 0; i < chkList.size(); i++) {

			String text = chkList.get(i).getText();

			if (!text.equals(element))

			{
				value = false;

			}
		}

		return value;
	}
	
	public boolean compareLists(List<String> actuallist, List<String> expectedlist) {
		boolean value = true;
		for (int i = 0; i < actuallist.size(); i++) {
			if (!actuallist.get(i).equals(expectedlist.get(i))) {
				value = false;

			}
		}

		return value;
	}


	

	
	}



