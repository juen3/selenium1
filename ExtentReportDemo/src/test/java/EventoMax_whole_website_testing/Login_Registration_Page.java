package EventoMax_whole_website_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Login_Registration_Page {

	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Login.html"); /* Test Report is saved in Target folder */
		extent.attachReporter(spark);

		// Test 1 RESTRATION FORM
		ExtentTest test1 = extent.createTest("EventoMax Home Page Test","this is a test to validate Registration Form functionality");
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);

		System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver/chromedriver_win32/chromedriver.exe");
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

		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/APP-BUTTON[1]/BUTTON[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("id(\"mat-input-0\")")).sendKeys("KRISTEL");
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"mat-input-1\")")).sendKeys("Juen");
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"mat-input-2\")")).sendKeys("93102354494");
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"mat-input-3\")")).sendKeys("KRISTEL.JUEN@COGNITIV.COM");
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"mat-input-4\")")).sendKeys("Automation Testing");
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"mat-checkbox-1\")/LABEL[1]/SPAN[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-ACCOUNTS[1]/APP-REGISTER[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/APP-BUTTON[1]/BUTTON[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"mat-input-5\")")).sendKeys("kristel.juen@cognitiv.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"mat-input-6\")")).sendKeys("Kristeljuen313!");
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"mat-checkbox-3\")/LABEL[1]/SPAN[1]")).click();
		Thread.sleep(1000);

		driver.close();
		driver.quit();
		test1.pass("Close the browser");
		test1.info("Test Completed ");
		extent.flush();
	}
}
