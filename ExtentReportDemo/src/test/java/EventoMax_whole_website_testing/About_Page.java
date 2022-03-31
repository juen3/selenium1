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

public class About_Page {

	private static WebDriver driver = null;

	public static void main(String[] args) throws Exception {
		
		
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/About.html"); /* Test Report is saved in Target folder */
		extent.attachReporter(spark);
		
		/* TEST 1 */
		ExtentTest test1 = extent.createTest("EventoMax Who We are and Clientele Test", "Test purpose is to hover and show hidden texts of each section");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		test1.log(Status.INFO, "Starting Test Case, Enter URL");
		
		driver.get("https://www.eventomax.com/about");
		driver.manage().window().maximize();
		test1.log(Status.INFO, "Maximize the window");
		
		/* Hover Who We Are Section */
		WebElement about = driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[2]/BUTTON[1]"));
		Actions action2 = new Actions(driver);
		action2.moveToElement(about).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[2]/UL[1]/LI[1]")).click();
		test1.log(Status.PASS, "Navigate to Who We Are Section");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"who-we-are-section\"]/div[2]/app-benefits-card[1]/div")).click();
		Thread.sleep(1000);
		test1.log(Status.PASS, "Hover Clients Cards");
		driver.findElement(By.xpath("//*[@id=\"who-we-are-section\"]/div[2]/app-benefits-card[2]/div")).click();
		Thread.sleep(1000);
		test1.log(Status.PASS, "Hover Projects Cards");
		driver.findElement(By.xpath("//*[@id=\"who-we-are-section\"]/div[2]/app-benefits-card[3]/div")).click();
		Thread.sleep(1000);
		test1.log(Status.PASS, "Hover Employees Cards");
		driver.findElement(By.xpath("//*[@id=\"who-we-are-section\"]/div[2]/app-benefits-card[4]/div")).click();
		Thread.sleep(1000);
		test1.log(Status.PASS, "Hover Countries Cards");
		
		/* Scroll into Clientele */
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		WebElement flag2 = driver.findElement(By.xpath("/html/body/app-root/app-main/app-about/div[3]"));
		js2.executeScript("arguments[0].scrollIntoView();", flag2);
		Thread.sleep(2000);
		test1.log(Status.PASS, "Scroll into Clientele Section");
		
		test1.info("Couldn't hover the canvas doughnut");
		test1.info("Test 1 Completed");
		
		
		/* TEST 2 */
		ExtentTest test2 = extent.createTest("EventoMax The Bosses and Staff Section","Test purpose is to hover quotes");
		
		/* Hover The Bosses Section */
		WebElement boss = driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[2]/BUTTON[1]"));
		Actions boss1 = new Actions(driver);
		boss1.moveToElement(boss).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[2]/UL[1]/LI[4]")).click();
		Thread.sleep(1000);
		test2.log(Status.INFO, "Navigate to The Bosses Section");

		driver.findElement(By.xpath("//*[@id=\"bosses-section\"]/div[1]/app-staff-card/div/div")).click();
		Thread.sleep(1000);
		test2.log(Status.PASS, "Hover sir Leons' quotes");
		driver.findElement(By.xpath("//*[@id=\"bosses-section\"]/div[2]/div[3]/app-staff-card/div/div")).click();
		Thread.sleep(1000);
		test2.log(Status.PASS, "Hover Ians' quotes");

		/*Scroll to Sales Force*/
		JavascriptExecutor staff = (JavascriptExecutor) driver;
		WebElement staff1 = driver.findElement(By.xpath("/html/body/app-root/app-main/app-about/div[9]"));
		staff.executeScript("arguments[0].scrollIntoView();", staff1);
		Thread.sleep(1000);
		test2.log(Status.PASS, "Scroll to Sales Force");
		
		test2.log(Status.PASS, "Hover Ryans' quotes");
		driver.findElement(By.xpath("/html/body/app-root/app-main/app-about/div[10]/div/div[3]/div/app-staff-card[1]/div/div")).click();
		Thread.sleep(1000);
		test2.log(Status.PASS, "Hover Christyls' quotes");

		/* Scroll to Amazing Ninjas */
		JavascriptExecutor jamjam = (JavascriptExecutor) driver;
		WebElement jam = driver.findElement(By.xpath("/html/body/app-root/app-main/app-about/div[12]/div/div[2]/div[2]/app-staff-card[9]/div"));
		jamjam.executeScript("arguments[0].scrollIntoView();", jam);
		Thread.sleep(1000);
		test2.log(Status.PASS, "Scroll to Amazing Ninjas");
		driver.findElement(By.xpath("/html/body/app-root/app-main/app-about/div[12]/div/div[2]/div[2]/app-staff-card[18]/div/div")).click();
		Thread.sleep(1000);
		test2.log(Status.PASS, "Hover Kristels' quotes");
		driver.findElement(By.xpath("/html/body/app-root/app-main/app-about/div[12]/div/div[2]/div[2]/app-staff-card[20]/div/div")).click();
		Thread.sleep(1000);
		test2.log(Status.PASS, "Hover Karlos' quotes");
		
		test2.info("Test 2 Completed");
		
		
		/* TEST 3 */
		ExtentTest test3 = extent.createTest("EventoMax Careers and Brochure Section","Test Purpose is to display Careers and Brochure");
		
		/* Scroll to Visit Careers Section */
		JavascriptExecutor fot = (JavascriptExecutor) driver;
		WebElement fot1 = driver.findElement(By.xpath("/html/body/app-root/app-main/app-about/div[14]/img[2]"));
		fot.executeScript("arguments[0].scrollIntoView();", fot1);
		Thread.sleep(2000);
		test3.log(Status.INFO, "Navigate to Careers Section");
		
		/*Hover Brochure Section */
		WebElement bro = driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[2]/BUTTON[1]"));
		Actions bro1 = new Actions(driver);
		bro1.moveToElement(bro).perform();
		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[2]/UL[1]/LI[3]")).click();
		Thread.sleep(2000);
		test3.log(Status.INFO, "Navigate to Brochure Section");
		driver.findElement(By.xpath("id(\"brochure-section\")/DIV[2]/DIV[2]/APP-BUTTON[1]/BUTTON[1]")).click();
		Thread.sleep(6000);
		test3.log(Status.PASS, "Click Download Brochure");

		test3.pass("Close the browser");
		test3.info("Test 3 Completed ");
		
		driver.close();
		driver.quit();
		extent.flush();

	}
}
