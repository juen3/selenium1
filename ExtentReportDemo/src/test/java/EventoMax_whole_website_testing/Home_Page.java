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

public class Home_Page {
	private static WebDriver driver = null;

	public static void main(String[] args) throws Exception {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(
				"target/HomePage.html"); /* Test Report is saved in Target folder */
		extent.attachReporter(spark);

		// Test 1 RESTRATION FORM
		ExtentTest test1 = extent.createTest("EventoMax Home Page Test", "this is a test to validate Registration Form functionality");
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

		/* Hover Home Services Section */
		WebElement about = driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[1]/BUTTON[1]/SPAN[1]/IMG[1]"));
		test1.log(Status.PASS, "Hover About button");
		Actions action2 = new Actions(driver);
		action2.moveToElement(about).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[1]/UL[1]/LI[2]"))
				.click();
		test1.log(Status.PASS, "Click Services");
		Thread.sleep(1000);

		/* Click Cards Services */
		/* Click Responsive Websites */
		driver.findElement(By.xpath("id(\"mat-tab-label-1-1\")/DIV[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div.ng-tns-c58-4 div.border-primary div.p-1")).click();
		Thread.sleep(1000);

		/* Click Website as a Service */
		WebElement titleValidation = driver.findElement(By.xpath("/html/body/app-root/app-main/app-home/div/div/div[4]/div/div[2]/div[1]/mat-tab-group/div/mat-tab-body[2]/div/div[2]/div[1]/div[2]"));
		Thread.sleep(800);
		test1.log(Status.INFO, "Verify the Contact title is desplayed");
		// Verify the Registration title is displayed
		if (titleValidation.isDisplayed()) {
			System.out.println("Title is displayed");
			test1.log(Status.PASS, "Title is displayed");
		} else {
			System.out.println("Title is not displayed");
			test1.log(Status.PASS, "Title is not displayed");
		}
		test1.log(Status.INFO, "Validating the actual and expected text");
		// Validating the actual and expected text
		String expectedText = "Website as a Service";
		String actualText = titleValidation.getText();
		test1.log(Status.INFO, "Comparing text");
		// Comparing text
		if (actualText.equals(expectedText)) {
			System.out.println("The actual and expected text are the same. The title value is " + actualText);
			test1.log(Status.PASS, "The actual and expected texts are the same. The title value is " + actualText);
			titleValidation.click();
		} else {
			System.out.println("The actual and expected texts are not the same. The displayed text is " + actualText);
			test1.log(Status.FAIL, "The actual and expected texts are not the same. The displayed text is " + actualText);
		}
		Thread.sleep(1000);

		/* Click Content Creation */
		WebElement titleValidation1 = driver.findElement(By.xpath("/html/body/app-root/app-main/app-home/div/div/div[4]/div/div[2]/div[1]/mat-tab-group/div/mat-tab-body[2]/div/div[3]/div[1]/div[2]"));
		Thread.sleep(800);
		test1.log(Status.INFO, "Verify the Contact title is desplayed");
		// Verify the Registration title is displayed
		if (titleValidation1.isDisplayed()) {
			System.out.println("Title is displayed");
			test1.log(Status.PASS, "Title is displayed");
		} else {
			System.out.println("Title is not displayed");
			test1.log(Status.PASS, "Title is not displayed");
		}
		test1.log(Status.INFO, "Validating the actual and expected text");
		// Validating the actual and expected text
		String expectedText1 = "Content Creation";
		String actualText1 = titleValidation1.getText();
		test1.log(Status.INFO, "Comparing text");
		// Comparing text
		if (actualText1.equals(expectedText1)) {
			System.out.println("The actual and expected text are the same. The title value is " + actualText1);
			test1.log(Status.PASS, "The actual and expected texts are the same. The title value is " + actualText1);
			titleValidation1.click();
		} else {
			System.out.println("The actual and expected texts are not the same. The displayed text is " + actualText1);
			test1.log(Status.FAIL, "The actual and expected texts are not the same. The displayed text is " + actualText1);
		}
		Thread.sleep(1000);

		/* Hover Why Us Section */
		WebElement why = driver.findElement(
				By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[1]/BUTTON[1]/SPAN[1]/IMG[1]"));
		test1.log(Status.PASS, "Hover About button");
		Actions why1 = new Actions(driver);
		why1.moveToElement(why).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[1]/UL[1]/LI[3]"))
				.click();
		test1.log(Status.PASS, "Click Services");
		Thread.sleep(1000);

		WebElement sg = driver.findElement(
				By.xpath("/html/body/app-root/app-main/app-home/div/div/div[6]/div[1]/div[2]/div/div[1]/div"));
		test1.log(Status.PASS, "Hover About button");
		Actions sg1 = new Actions(driver);
		sg1.moveToElement(sg).perform();
		Thread.sleep(1000);

		WebElement aus = driver.findElement(
				By.xpath("/html/body/app-root/app-main/app-home/div/div/div[6]/div[1]/div[2]/div/div[2]/div"));
		test1.log(Status.PASS, "Hover About button");
		Actions aus1 = new Actions(driver);
		aus1.moveToElement(aus).perform();
		Thread.sleep(1000);

		WebElement uk = driver.findElement(
				By.xpath("/html/body/app-root/app-main/app-home/div/div/div[6]/div[1]/div[2]/div/div[3]/div"));
		test1.log(Status.PASS, "Hover About button");
		Actions uk1 = new Actions(driver);
		uk1.moveToElement(uk).perform();
		Thread.sleep(1000);

		WebElement usa = driver.findElement(
				By.xpath("/html/body/app-root/app-main/app-home/div/div/div[6]/div[1]/div[2]/div/div[4]/div"));
		test1.log(Status.PASS, "Hover About button");
		Actions usa1 = new Actions(driver);
		usa1.moveToElement(usa).perform();
		Thread.sleep(1000);

		/* Scroll into pricing */
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		WebElement flag2 = driver
				.findElement(By.xpath("/html/body/app-root/app-main/app-home/div/div/div[6]/div[1]/div[1]/span"));

		js2.executeScript("arguments[0].scrollIntoView();", flag2);

		Thread.sleep(2000);
		driver.findElement(
				By.xpath("/html/body/app-root/app-main/app-home/div/div/div[6]/div[3]/div[2]/div[1]/div[3]/button[2]"))
				.click();
		Thread.sleep(2000);

		/* Hover Our Works Section */
		WebElement our = driver.findElement(
				By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[1]/BUTTON[1]/SPAN[1]/IMG[1]"));
		test1.log(Status.PASS, "Hover About button");
		Actions our1 = new Actions(driver);
		our1.moveToElement(our).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[1]/UL[1]/LI[4]"))
				.click();
		test1.log(Status.PASS, "Click Services");
		Thread.sleep(2000);

		/* Scroll into testimonials */
		JavascriptExecutor test = (JavascriptExecutor) driver;
		WebElement js = driver.findElement(By
				.xpath("/html/body/app-root/app-main/app-home/div/div/div[8]/div[1]/div[2]/owl-carousel-o/div/div[2]"));

		test.executeScript("arguments[0].scrollIntoView();", js);
		Thread.sleep(2000);

		/* Scroll into world */
		JavascriptExecutor world = (JavascriptExecutor) driver;
		WebElement world1 = driver.findElement(
				By.xpath("/html/body/app-root/app-main/app-home/div/div/div[8]/div[3]/div[2]/div/div/div[4]/div[2]/p"));

		world.executeScript("arguments[0].scrollIntoView();", world1);
		Thread.sleep(2000);

		/* Hover Contact Section */
		WebElement con = driver.findElement(
				By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[1]/BUTTON[1]/SPAN[1]/IMG[1]"));
		test1.log(Status.PASS, "Hover About button");
		Actions con1 = new Actions(driver);
		con1.moveToElement(con).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[1]/UL[1]/LI[5]")).click();
		test1.log(Status.PASS, "Click Services");
		Thread.sleep(2000);

		driver.close();
		driver.quit();
		test1.pass("Close the browser");
		test1.info("Test Completed ");
		extent.flush();

	}
}
