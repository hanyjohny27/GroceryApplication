package testscript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.ScreenshotUtility;

public class Base {
	WebDriver driver;
	Properties prop;
	FileInputStream fis;

//for running testcases with parameters
	@BeforeMethod(alwaysRun = true)
	@Parameters("browsers")
	public void browserInitialisation(String browsers) throws IOException {
		prop = new Properties();
		fis = new FileInputStream(Constant.CONFIGFILE);
		prop.load(fis);
		if (browsers.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browsers.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browsers.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		// for running testcases without parameters
		/*
		 * @BeforeMethod(alwaysRun=true) public void browserInitialisation() throws
		 * IOException { prop=new Properties(); fis=new
		 * FileInputStream(Constant.CONFIGFILE); prop.load(fis); driver=new
		 * ChromeDriver();
		 */
		// url launch
		driver.get(prop.getProperty("url"));
		// maximize browser
		driver.manage().window().maximize();
		driver.manage().window().fullscreen();
		// Applying implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult itestresult) throws IOException {
		if (itestresult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility screenshotutility = new ScreenshotUtility();
			screenshotutility.getScreenshot(driver, itestresult.getName());
		}
		// driver.close();
		// driver.quit();
	}

}
