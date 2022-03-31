package EventoMax_whole_website_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Contact_Page {
	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(
				"target/Contact.html"); /* Test Report is saved in Target folder */
		extent.attachReporter(spark);

		// Test 1 RESTRATION FORM
		ExtentTest test1 = extent.createTest("EventoMax Home Page Test",
				"this is a test to validate Registration Form functionality");
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);

		System.setProperty("webdriver.chrome.driver",
				projectPath + "/drivers/chromedriver/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();

		test1.log(Status.INFO, "Starting Test Case, Enter URL");
		driver.get("https://www.eventomax.com/");
		driver.manage().window().maximize();
		test1.log(Status.INFO, "Maximize the window");
		if (driver.getTitle().equals("EventoMax | Home")) { /*
															 * Issue: Ask Karlo why in Chrome browser title is
															 * <title>RemotoDojo | Home </title> RemotoDojo | Home
															 */
			test1.log(Status.PASS, "Navigated to the EventoMax Home Page");
		} else {
			test1.log(Status.FAIL, "Incorrect URL");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[5]/BUTTON[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"mat-select-value-1\")/SPAN[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"mat-option-243\")/SPAN[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"mat-input-0\")")).sendKeys("Kristel");
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"mat-input-1\")")).sendKeys("kristel.juen@cognitiv.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"mat-input-2\")")).sendKeys("9310235681");
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"mat-input-3\")")).sendKeys("Selenium Automation Testing");
		Thread.sleep(1000);

		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement footer = driver.findElement(By.xpath("id(\"contact-page\")/DIV[2]"));
		js.executeScript("arguments[0].scrollIntoView();", footer);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-FOOTER[1]/DIV[1]/DIV[1]/DIV[3]/DIV[1]/SPAN[3]")).click();
		Thread.sleep(2000);
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement info = driver.findElement(By.xpath("id(\"information-collected\")/DIV[1]"));
		js1.executeScript("arguments[0].scrollIntoView();", info);
		Thread.sleep(2000);
		
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		WebElement log = driver.findElement(By.xpath("id(\"log-files\")/DIV[1]"));
		js2.executeScript("arguments[0].scrollIntoView();", log);
		Thread.sleep(2000);
		
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		WebElement third = driver.findElement(By.xpath("id(\"third-party-policy\")/DIV[1]"));
		js3.executeScript("arguments[0].scrollIntoView();", third);
		Thread.sleep(2000);
		
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		WebElement right = driver.findElement(By.xpath("id(\"data-protect-rights\")/P[1]"));
		js4.executeScript("arguments[0].scrollIntoView();", right);
		Thread.sleep(2000);
		
		driver.close();
		driver.quit();
		test1.pass("Close the browser");
		test1.info("Test Completed ");
		extent.flush();
	}
}
