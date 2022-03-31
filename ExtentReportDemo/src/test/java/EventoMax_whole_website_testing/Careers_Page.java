package EventoMax_whole_website_testing;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Careers_Page {

	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException, Exception {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(
				"target/Careers.html"); /* Test Report is saved in Target folder */
		extent.attachReporter(spark);

		// Test 1 RESTRATION FORM
		ExtentTest test1 = extent.createTest("EventoMax Home Page Test", "this is a test to validate Registration Form functionality");
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);

		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();

		test1.log(Status.INFO, "Starting Test Case, Enter URL");
		driver.get("https://www.eventomax.com/careers");
		driver.manage().window().maximize();
		test1.log(Status.INFO, "Maximize the window");
		if (driver.getTitle().equals("EventoMax | Careers")) { /*
																 * Issue: Ask Karlo why in Chrome browser title is
																 * <title>RemotoDojo | Home </title> RemotoDojo | Home
																 */
			test1.log(Status.PASS, "Navigated to the EventoMax Home Page");
		} else {
			test1.log(Status.FAIL, "Incorrect URL");
		}
		Thread.sleep(1000);

		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-CAREERS[1]/DIV[1]/DIV[2]/DIV[1]/APP-BUTTON[1]/BUTTON[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("id(\"open-positions\")/DIV[1]/DIV[2]/DIV[2]/DIV[1]/APP-POSITION-CARD[1]/DIV[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-POSITION[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/APP-BUTTON[1]/BUTTON[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("id(\"mat-input-0\")")).sendKeys("Kristel");
		Thread.sleep(800);
		driver.findElement(By.xpath("id(\"mat-input-1\")")).sendKeys("Juen");
		Thread.sleep(800);
		driver.findElement(By.xpath("id(\"mat-input-2\")")).sendKeys("KRISTEL.juen@cognitiv.com");
		Thread.sleep(800);
		driver.findElement(By.xpath("id(\"mat-input-3\")")).sendKeys("93102352647");
		Thread.sleep(800);
		driver.findElement(By.xpath("id(\"mat-input-4\")")).sendKeys("BABAG II, LAPU - LAPU CITY");
		Thread.sleep(800);
		driver.findElement(By.xpath("id(\"mat-select-value-3\")/SPAN[1]")).click();
		Thread.sleep(1000);
		
		/*Scroll into the Philippines*/
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement flag = driver.findElement(By.xpath("id(\"mat-option-412\")/SPAN[1]"));
		js.executeScript("arguments[0].scrollIntoView", flag);
		Thread.sleep(1000);
		flag.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"mat-select-value-5\")/SPAN[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"mat-option-488\")/SPAN[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("id(\"application-form-section\")/DIV[1]/DIV[1]/FORM[1]/DIV[3]/DIV[1]/APP-BUTTON[1]/BUTTON[1]")).click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec(projectPath + "/FileUploadScript/fileUploadScript.exe");
		Thread.sleep(2000);
		driver.findElement(By.xpath("id(\"application-form-section\")/DIV[1]/DIV[1]/FORM[1]/DIV[3]/APP-BUTTON[1]/BUTTON[1]")).click();
		Thread.sleep(3000);
		
		
		driver.close();
		driver.quit();
		test1.pass("Close the browser");
		test1.info("Test Completed ");
		extent.flush();
	}

}
