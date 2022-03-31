package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsBasicDemo {
	
	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");                                    /*Test Report is saved in Target folder*/
		extent.attachReporter(spark);
		ExtentTest test1 = extent.createTest("Google Search Test One", "this is a test to validate google search functionality");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		test1.log(Status.INFO, "Starting Test Case");
		test1.pass("Enter URL");
		driver.get("https://google.com");
		test1.pass("Navigated to google.com");
		
		driver.findElement(By.name("q")).sendKeys("Automation");
		test1.pass("Entered text in Searchbox");
		Thread.sleep(3000);
		driver.findElement(By.name("btnK")).click();
		test1.pass("Pressed keyboard enter key");
		driver.close();
		driver.quit();
		test1.pass("Closed the browser"); 
		test1.info("Test Completed ");
		

		ExtentTest test2 = extent.createTest("Google Search Test Two", "this is a test to validate google search functionality");
		
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		test2.log(Status.INFO, "Starting Test Case");
		test2.pass("Enter URL");
		driver.get("https://www.remotodojo.com/");
		
		if(driver.getTitle().equals("Google")) {
			test2.log(Status.PASS,"Navigated to the specified URL");
		}
		else {
			test2.log(Status.FAIL, "Incorrect URL");
		}
		
		driver.close();
		driver.quit();
		test2.pass("Closed the browser"); 
		test2.info("Test Completed ");
		extent.flush();

	}
}
