   package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.Screenshotcapture;

public class BaseClass {
	WebDriver driver;
	public static Properties prop;
	Screenshotcapture sc;

	public static void testBasic() throws IOException {
		prop = new Properties();
		FileInputStream fileIO = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\Config.properties");
		prop.load(fileIO);
		
	}

	@Parameters("Browser")
	@BeforeMethod(alwaysRun=true)
	public void beforemethod(String browser) throws InterruptedException, IOException {

		if (browser.equals("chrome")) {
			testBasic();

			System.setProperty(prop.getProperty("chromeBrowserDriver"),
					System.getProperty("user.dir") + prop.getProperty("chromeDriverPath"));
			

			driver = new ChromeDriver();
		} /*
			 * else if (browser.equals("edge")) { testBasic();
			 * 
			 * System.setProperty(prop.getProperty("edgeBrowserDriver"),
			 * System.getProperty("user.dir") + prop.getProperty("edgeDriverPath")); driver
			 * = new EdgeDriver(); }
			 */
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod

	public void aftermethod(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == iTestResult.FAILURE) {
			sc = new Screenshotcapture();
			sc.Screenshotcapturefunc(driver, iTestResult.getName());//pass control of driver and function name also

		}
		driver.close();

	}
}
