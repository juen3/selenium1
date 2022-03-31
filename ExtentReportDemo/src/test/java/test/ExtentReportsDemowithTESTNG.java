package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemowithTESTNG {
	ExtentReports extent;
	ExtentSparkReporter spark;
	
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("ExtentReportsDemowithTESTNG.html");                                    /*Test Report is saved in Target folder*/
		extent.attachReporter(spark);
		
		
	}

	@BeforeTest   /*ADDED function setUpTest() and set driver as class variable*/
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void test1() {
		
		
		ExtentTest test = extent.createTest("MyFirstTeSt", "Sample description");
		driver.get("https://www.google.com/");
		test.pass("Navigated to Google");
		test.log(Status.INFO, "This stem shows usage of log(status, details, etc.");
		test.info("This step shows usage of info(details)");
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromBase64String("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");
	}
	
	@Test
	public void test2() {
		ExtentTest test = extent.createTest("MyFirstTeSt", "Sample description");
		test.log(Status.INFO, "This stem shows usage of log(status, details, etc.");
		test.info("This step shows usage of info(details)");
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromBase64String("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");
	}
	
	@AfterTest
	public void tearDownTest() {
		
		//close browser
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
	}
	
	@AfterSuite
	public void tearDown() {
		extent.flush();
	}
}
