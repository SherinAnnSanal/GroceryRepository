package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalendarUtility {
	public void calendarFunction(WebDriver driver, String x, String y, String z) throws InterruptedException {

		String exDate = x;
		String exMnth = y;
		String exYear = z;
		WebElement date = driver.findElement(By.id("datepicker"));
		date.click();
		Thread.sleep(3000);
		String month = driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText();
		System.out.println(month);

		while (!driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText().contains("April"))// also can
																											// use
																											// equalsIgnoreCase
																											// instead
																											// of
																											// contains
		{
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}

		int count = driver.findElements(By.className("ui-state-default")).size();
		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.className("ui-state-default")).get(i).getText();
			if (text.equalsIgnoreCase("27")) {
				driver.findElements(By.className("ui-state-default")).get(i).click();
				break;
			}

		}

	}
}
