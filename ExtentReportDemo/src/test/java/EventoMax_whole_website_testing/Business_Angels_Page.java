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

public class Business_Angels_Page {

	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Angels.html"); /* Test Report is saved in Target folder */
		extent.attachReporter(spark);

		// Test 1 RESTRATION FORM
		ExtentTest test1 = extent.createTest("EventoMax Home Page Test", "this is a test to validate Registration Form functionality");
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);

		System.setProperty("webdriver.chrome.driver",
				projectPath + "/drivers/chromedriver/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();

		test1.log(Status.INFO, "Starting Test Case, Enter URL");
		driver.get("https://www.eventomax.com/business");
		driver.manage().window().maximize();
		test1.log(Status.INFO, "Maximize the window");
		if (driver.getTitle().equals("EventoMax | Business")) { /*
															 * Issue: Ask Karlo why in Chrome browser title is
															 * <title>RemotoDojo | Home </title> RemotoDojo | Home
															 */
			test1.log(Status.PASS, "Navigated to the EventoMax Home Page");
		} else {
			test1.log(Status.FAIL, "Incorrect URL");
		}
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement flag = driver.findElement(By.xpath("id(\"business-section\")/DIV[2]"));
		js.executeScript("arguments[0].scrollIntoView();", flag);
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"grow-business-section\")/DIV[1]/DIV[1]/DIV[2]/BUTTON[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"grow-business-section\")/DIV[1]/DIV[1]/DIV[2]/BUTTON[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"grow-business-section\")/DIV[1]/DIV[1]/DIV[2]/BUTTON[3]")).click();
		Thread.sleep(1000);
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement ques = driver.findElement(By.xpath("id(\"grow-business-section\")/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]"));
		js1.executeScript("arguments[0].scrollIntoView();", ques);
		Thread.sleep(1000);
		
		
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		WebElement advantage = driver.findElement(By.xpath("id(\"advantages-section\")/DIV[1]"));
		js2.executeScript("arguments[0].scrollIntoView();", advantage);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("id(\"advantages-section\")/DIV[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/APP-COLLAPSE-CARD[1]/DIV[1]/DIV[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"advantages-section\")/DIV[1]/DIV[1]/DIV[2]/DIV[1]/DIV[2]/APP-COLLAPSE-CARD[1]/DIV[1]/DIV[1]/SPAN[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"advantages-section\")/DIV[1]/DIV[1]/DIV[2]/DIV[1]/DIV[3]/APP-COLLAPSE-CARD[1]/DIV[1]/DIV[1]/SPAN[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"advantages-section\")/DIV[1]/DIV[1]/DIV[2]/DIV[1]/DIV[4]/APP-COLLAPSE-CARD[1]/DIV[1]/DIV[1]/SPAN[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"advantages-section\")/DIV[1]/DIV[1]/DIV[2]/DIV[1]/DIV[5]/APP-COLLAPSE-CARD[1]/DIV[1]/DIV[1]/SPAN[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"advantages-section\")/DIV[1]/DIV[1]/DIV[2]/DIV[1]/DIV[5]/APP-COLLAPSE-CARD[1]/DIV[1]/DIV[1]/SPAN[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"advantages-section\")/DIV[1]/DIV[1]/DIV[2]/DIV[2]/DIV[1]/APP-COLLAPSE-CARD[1]/DIV[1]/DIV[1]/SPAN[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"advantages-section\")/DIV[1]/DIV[1]/DIV[2]/DIV[2]/DIV[2]/APP-COLLAPSE-CARD[1]/DIV[1]/DIV[1]/SPAN[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"advantages-section\")/DIV[1]/DIV[1]/DIV[2]/DIV[2]/DIV[3]/APP-COLLAPSE-CARD[1]/DIV[1]/DIV[1]/SPAN[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"advantages-section\")/DIV[1]/DIV[1]/DIV[2]/DIV[2]/DIV[4]/APP-COLLAPSE-CARD[1]/DIV[1]/DIV[1]/SPAN[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"advantages-section\")/DIV[1]/DIV[1]/DIV[2]/DIV[2]/DIV[5]/APP-COLLAPSE-CARD[1]/DIV[1]/DIV[1]/SPAN[1]")).click();
		Thread.sleep(1000);
		
		WebElement angles = driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[4]/BUTTON[1]"));
		Actions ac = new Actions(driver);
		ac.moveToElement(angles).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[4]/UL[1]/LI[2]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("id(\"mat-input-0\")")).sendKeys("KRISTEL");
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"mat-input-1\")")).sendKeys("JUEN");
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"mat-input-2\")")).sendKeys("KRISTEL JUEN");
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"mat-input-3\")")).sendKeys("KRISTEL.juen@COGNITIV.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"mat-input-4\")")).sendKeys("9310235634");
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"mat-input-5\")")).sendKeys("Automation Testing");
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"get-in-touch-section\")/DIV[1]/FORM[1]/DIV[2]/APP-BUTTON[1]/BUTTON[1]")).click();
		Thread.sleep(2500);
		
		driver.close();
		driver.quit();
		test1.pass("Close the browser");
		test1.info("Test Completed ");
		extent.flush();
	}
}
