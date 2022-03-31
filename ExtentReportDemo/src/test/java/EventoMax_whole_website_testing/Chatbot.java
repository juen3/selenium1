package EventoMax_whole_website_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Chatbot {

	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(
				"target/Contact.html"); /* Test Report is saved in Target folder */
		extent.attachReporter(spark);

		// Test 8 Chatbot Test
		ExtentTest test8 = extent.createTest("RemotoDojo Home Page Test",
				"This is to test each section of the Home Page");
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);

		System.setProperty("webdriver.chrome.driver",
				projectPath + "/drivers/chromedriver/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();

		test8.log(Status.INFO, "Starting Test Case, Enter URL");
		driver.get("https://www.eventomax.com/");
		driver.manage().window().maximize();
		test8.log(Status.INFO, "Maximize the window");

		Thread.sleep(2000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		WebElement chat = driver.findElement(By.xpath("/html/body/df-messenger//div/button"));
//		js.executeScript("arguments[0].scrollIntoView();", chat);
//		chat.click();


		
		driver.findElement(By.xpath("//*[@id=\"messageList\"]/div")).click();

		Thread.sleep(2000);
		driver.close();
		driver.quit();
		test8.pass("Close the browser");
		test8.info("Test Completed ");

		extent.flush();

	}

}
