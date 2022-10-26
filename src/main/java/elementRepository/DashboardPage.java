package elementRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utilities.GeneralUtilities;

public class DashboardPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "i[class='fas fa-bars']")
	WebElement bar;

	@FindBy(css = "a[data-toggle='dropdown']")
	WebElement profileName;

	@FindBy(linkText = "Home")
	WebElement homeLink;

	@Test
	public String getColorHome() {

		return gu.stylePropertyValidation(homeLink, "color");

	}

	@Test
	public String getProfileName() {
		// return profileName.getText();
		return gu.getElementText(profileName);
	}

	@Test
	public boolean getVerifyBar() {
		return gu.isEnabled(bar);
	}

}
