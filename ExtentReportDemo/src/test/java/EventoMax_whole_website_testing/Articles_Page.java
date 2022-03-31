package EventoMax_whole_website_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Articles_Page {

	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Articles.html"); /* Test Report is saved in Target folder */
		extent.attachReporter(spark);

		ExtentTest test1 = extent.createTest("EventoMax Home Page Test", "this is a test to validate Registration Form functionality");
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);

		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();

		test1.log(Status.INFO, "Starting Test Case, Enter URL");
		driver.get("https://www.eventomax.com/");
		driver.manage().window().maximize();
		test1.log(Status.INFO, "Maximize the window");
		Thread.sleep(1000);

		/* Hover Articles Section */
		WebElement about = driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[3]/BUTTON[1]"));
		Actions action2 = new Actions(driver);
		action2.moveToElement(about).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[3]/UL[1]/LI[2]")).click();
		test1.log(Status.PASS, "Navigate to Industry News Section");
		Thread.sleep(2000);
		driver.findElement(By.xpath("id(\"industry-news-section\")/DIV[1]/DIV[2]/APP-ARTICLE-CARD[1]/DIV[1]/DIV[2]/DIV[1]/SPAN[1]")).click();
		Thread.sleep(2000);
		test1.log(Status.PASS, "Select Cyber Monday News");
		
		/* Scroll to Reply Form*/
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement flag = driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-BLOG[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/DIV[2]"));
		js.executeScript("arguments[0].scrollIntoView();", flag);
		Thread.sleep(2000);
		test1.log(Status.PASS, "Scroll to Leave a Reply Form");
		
		/* Fill - up Form*/
		driver.findElement(By.xpath("id(\"mat-input-3\")")).sendKeys("KRISTEL JUEN");
		Thread.sleep(800);
		test1.log(Status.PASS, "Enter Full Name");
		driver.findElement(By.xpath("id(\"mat-input-4\")")).sendKeys("KRISTEL.juen@COGNitiv.com");
		Thread.sleep(800);
		test1.log(Status.PASS, "Enter Email");
		driver.findElement(By.xpath("id(\"mat-input-5\")")).sendKeys("https://www.eventomax.com/");
		Thread.sleep(800);
		test1.log(Status.PASS, "Enter Website URL");
		driver.findElement(By.xpath("id(\"mat-input-6\")")).sendKeys("Selenium Automation Testing");
		Thread.sleep(800);
		test1.log(Status.PASS, "Enter Comment");
		driver.findElement(By.xpath("id(\"mat-checkbox-1\")/LABEL[1]/SPAN[1]")).click();
		Thread.sleep(1000);
		test1.log(Status.PASS, "Click Checkbox");
		
		/*Go back to Articles Page*/
		driver.get("https://www.eventomax.com/articles#blog-section");
		Thread.sleep(1000);
		test1.log(Status.PASS, "Go back to Articles Page");
		WebElement search =    driver.findElement(By.xpath("id(\"mat-input-1\")"));
		search.sendKeys("Days at the Dojo", Keys.RETURN);
		Thread.sleep(1000);
		test1.log(Status.PASS, "Search Days at the Dojo");
		
		/* Click Blogs Categories*/
		driver.findElement(By.xpath("id(\"blog-section\")/DIV[1]/DIV[2]/DIV[3]/DIV[2]/APP-LIST-ITEM[1]/DIV[1]/SPAN[1]")).click();
		Thread.sleep(1000);
		test1.log(Status.PASS, "Click Affordable Software Engineer");
		driver.findElement(By.xpath("id(\"blog-section\")/DIV[1]/DIV[2]/DIV[3]/DIV[2]/APP-LIST-ITEM[2]/DIV[1]/SPAN[1]")).click();
		Thread.sleep(1000);
		test1.log(Status.PASS, "Click Days at the Dojo");
		driver.findElement(By.xpath("id(\"blog-section\")/DIV[1]/DIV[2]/DIV[3]/DIV[2]/APP-LIST-ITEM[3]/DIV[1]/SPAN[1]")).click();
		Thread.sleep(1000);
		test1.log(Status.PASS, "Click DOJI Newsletter");
		driver.findElement(By.xpath("id(\"blog-section\")/DIV[1]/DIV[2]/DIV[3]/DIV[2]/APP-LIST-ITEM[4]/DIV[1]/SPAN[1]")).click();
		Thread.sleep(1000);
		test1.log(Status.PASS, "Click E-Commerce");
		driver.findElement(By.xpath("id(\"blog-section\")/DIV[1]/DIV[2]/DIV[3]/DIV[2]/APP-LIST-ITEM[5]/DIV[1]/SPAN[1]")).click();
		Thread.sleep(1000);
		test1.log(Status.PASS, "Click IT Recruitment");
		driver.findElement(By.xpath("id(\"blog-section\")/DIV[1]/DIV[2]/DIV[3]/DIV[2]/APP-LIST-ITEM[6]/DIV[1]/SPAN[1]")).click();
		Thread.sleep(1000);
		test1.log(Status.PASS, "Click Outsourcing");
		driver.findElement(By.xpath("id(\"blog-section\")/DIV[1]/DIV[2]/DIV[3]/DIV[2]/APP-LIST-ITEM[7]/DIV[1]/SPAN[1]")).click();
		Thread.sleep(1000);
		test1.log(Status.PASS, "Click Responsive Web Design");
		driver.findElement(By.xpath("id(\"blog-section\")/DIV[1]/DIV[2]/DIV[3]/DIV[2]/APP-LIST-ITEM[8]/DIV[1]/SPAN[1]")).click();
		Thread.sleep(1000);
		test1.log(Status.PASS, "Click SEO");
		driver.findElement(By.xpath("id(\"blog-section\")/DIV[1]/DIV[2]/DIV[3]/DIV[2]/APP-LIST-ITEM[9]/DIV[1]/SPAN[1]")).click();
		Thread.sleep(1000);
		test1.log(Status.PASS, "Click Website Development");
		
		/*Scroll Industry News Section*/
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement news = driver.findElement(By.xpath("id(\"blog-section\")/DIV[1]/DIV[2]/DIV[3]/DIV[2]/APP-LIST-ITEM[9]/DIV[1]/SPAN[1]"));
		js1.executeScript("arguments[0].scrollIntoView();", news);
		Thread.sleep(2000);
		test1.log(Status.PASS, "Scroll to Industry News Section");
		
		/* Click Page 2 */
		driver.findElement(By.xpath("id(\"industry-news-section\")/DIV[1]/DIV[3]/APP-PAGINATOR[1]/DIV[1]/DIV[1]/BUTTON[3]")).click();
		Thread.sleep(1000);
		test1.log(Status.PASS, "Click Page 2");
		/* Click Page 3*/
		driver.findElement(By.xpath("id(\"industry-news-section\")/DIV[1]/DIV[3]/APP-PAGINATOR[1]/DIV[1]/DIV[1]/BUTTON[5]")).click();
		Thread.sleep(1000);
		test1.log(Status.PASS, "Click Page 3");
		
		driver.close();
		driver.quit();
		test1.pass("Close the browser");
		test1.info("Test Completed ");
		extent.flush();
	}
}
