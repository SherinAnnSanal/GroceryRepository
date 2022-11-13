package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
public class Synchronisation {
	public void implicitWait(WebDriver driver,int time)
	{
	driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

	}
	public void pageLoadWait(WebDriver driver,int time)
	{
	driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);

	}
	public void Elementvisible(WebDriver driver, String location) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(location)));

	}

	public void clickElement(WebDriver driver, String target) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(target)));
	}
	public void fWait(WebDriver driver,By locator)
	{
	Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
	.withTimeout(Duration.ofSeconds(30))
	.pollingEvery(Duration.ofSeconds(5))
	.ignoring(NoSuchElementException.class);


	WebElement foo = fluentWait.until(new Function<WebDriver, WebElement>() {

	public WebElement apply(WebDriver driver) {

	if(driver.findElement(locator).isDisplayed())
	{
	 return driver.findElement(locator);
	}
	else
	return null;

	}
	});
	}

}
