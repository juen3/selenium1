package test;

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

public class EventoMax_AutoTest {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) throws Exception {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/EventoMax_Report.html"); /* Test Report is saved in Target folder */
		extent.attachReporter(spark);

		// Test 1 RESTRATION FORM
		ExtentTest test1 = extent.createTest("EventoMax Registration Test", "this is a test to validate Registration Form functionality");
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);

		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();

		test1.log(Status.INFO, "Starting Test Case, Enter URL");
		driver.get("https://www.eventomax.com/");
		driver.manage().window().maximize();
		test1.log(Status.INFO, "Maximize the window");
		if (driver.getTitle().equals("EventoMax | Home")) { /*
																 * Issue: Ask Karlo why in Chrome browser title is
																 * <title>RemotoDojo | Home </title> RemotoDojo  | Home 
																 */
			test1.log(Status.PASS, "Navigated to the EventoMax Home Page");
		} else {
			test1.log(Status.FAIL, "Incorrect URL");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-main/app-navbar/nav/div[3]/app-button/button")).click();
		test1.log(Status.PASS, "Clicked LOGIN button");

		if (driver.getTitle().equals("EventoMax | Accounts - Get-access")) {
			test1.log(Status.PASS, "Navigated to Registration Page");
			Thread.sleep(1000);
		} else {
			test1.log(Status.FAIL, "Not navigated to Registration Page");
		}
		Thread.sleep(1000);

		/* Scroll into the leave a reply form */
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement flag = driver.findElement(By.xpath("//p[normalize-space()='Already have an account?']"));
		test1.log(Status.PASS, "Scroll down into Footer");
		js1.executeScript("arguments[0].scrollIntoView();", flag);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys("Kristel");
		test1.log(Status.PASS, "Enter First name");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys("Juen");
		test1.log(Status.PASS, "Enter Last name");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"mat-input-2\"]")).sendKeys("9310232083");
		test1.log(Status.PASS, "Enter Contact Number");
		Thread.sleep(1000);
		WebElement email = driver.findElement(By.xpath("//*[@id=\"mat-input-3\"]"));
		email.sendKeys("KRISTEL.JUEN@COGNITIV.COM");
		test1.log(Status.PASS, "Enter Email");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"mat-input-4\"]")).sendKeys("RemotoDojo Inc.,");
		test1.log(Status.PASS, "Enter Company name");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"mat-checkbox-1\"]/label/span[1]")).click();
		test1.log(Status.PASS, "Clicked checkbox for Terms and Conditions");
		Thread.sleep(1000);
		
		//Comment for now since there's no captcha
//		driver.findElement(By.xpath("//ngx-recaptcha2[@class='ng-untouched ng-pristine ng-invalid']")).click();
//		test1.log(Status.PASS, "Clicked Recaptcha button");
//		Thread.sleep(1000);

		driver.close();
		driver.quit();
		test1.pass("Close the browser");
		test1.info("Test Completed ");
		
		// TEST 2 LOGIN FORM
				ExtentTest test2 = extent.createTest("EventoMax Login Test","this is a test to validate Login Form Functionality");
				System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver/chromedriver_win32/chromedriver.exe");
				driver = new ChromeDriver();
				test2.log(Status.INFO, "Starting Test Case, Enter URL");
				driver.get("https://www.eventomax.com/accounts/get-access");
				driver.manage().window().maximize();
				test2.log(Status.INFO, "Maximize the window");
				Thread.sleep(1000);
				if (driver.getTitle().equals("EventoMax | Accounts - Get-access")) {
					test2.log(Status.PASS, "Navigated to the EventoMax Login Page");
				} else {
					test2.log(Status.FAIL, "Incorrect URL");
				}
				Thread.sleep(1000);
				driver.findElement(By.xpath("/html/body/app-root/app-main/app-accounts/app-register/div/div/div/div[1]/div/div[2]/app-button/button")).click();
				test2.log(Status.PASS, "Clicked Login button");
				Thread.sleep(1000);
				
				WebElement test = driver.findElement(By.xpath("//*[@id=\"mat-input-5\"]"));
				test.sendKeys("kristel.juen");
				
//				
//				driver.findElement(By.xpath("//*[@id=\"mat-input-5\"]")).sendKeys("kristel.juen");
				test2.log(Status.FAIL, "Invalid Email");
				Thread.sleep(800);
				driver.findElement(By.xpath("//*[@id=\"mat-input-6\"]")).sendKeys("kristeljuen313");
				test2.log(Status.PASS, "Enter password");
				Thread.sleep(1000);

				driver.close();
				driver.quit();
				test2.pass("Close the browser");
				test2.info("Test Completed ");
				

				// TEST 3 Get in Touch Form Test
				ExtentTest test3 = extent.createTest("EventoMax Business Angels Test", "this is a test Get in Touch Form Functionality");
				System.setProperty("webdriver.chrome.driver",projectPath + "/drivers/chromedriver/chromedriver_win32/chromedriver.exe");
				driver = new ChromeDriver();
				test3.log(Status.INFO, "Starting Test Case, Enter URL");
				driver.get("https://www.eventomax.com/business");
				driver.manage().window().maximize();
				test3.log(Status.INFO, "Maximize the window");
				Thread.sleep(1000);
				if (driver.getTitle().equals("EventoMax | Business")) {
					test3.log(Status.PASS, "Navigated to the Business Angels Page");
				} else {
					test3.log(Status.FAIL, "Incorrect URL");
				}
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"business-section\"]/div[2]/div[1]/app-button/button/span")).click();
				test3.log(Status.PASS, "Clicked Get Stated button");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys("Bruce");
				Thread.sleep(800);
				test3.log(Status.PASS, "Enter First Name");
				driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys("Juen");
				Thread.sleep(800);
				test3.log(Status.PASS, "Enter Last Name");
				driver.findElement(By.xpath("//*[@id=\"mat-input-2\"]")).sendKeys("Bruce");
				Thread.sleep(800);
				test3.log(Status.PASS, "Start Name");
				driver.findElement(By.xpath("//*[@id=\"mat-input-3\"]")).sendKeys("bruce.juen@cognitiv.com");
				Thread.sleep(800);
				test3.log(Status.PASS, "Enter email address");
				driver.findElement(By.xpath("//*[@id=\"mat-input-4\"]")).sendKeys("9310232084");
				Thread.sleep(800);
				test3.log(Status.PASS, "Enter number");
				driver.findElement(By.xpath("//*[@id=\"mat-input-5\"]")).sendKeys("Remote Testing");
				Thread.sleep(800);
				test3.log(Status.PASS, "Enter message");
				driver.findElement(By.xpath("//*[@id=\"get-in-touch-section\"]/div/form/div[2]/app-button/button/span")).click();
				Thread.sleep(2000);
				driver.close();
				driver.quit();
				test3.pass("Close the browser");
				test3.info("Test Completed ");

				// TEST 4 Test for Articles form
				ExtentTest test4 = extent.createTest("EventoMax Articles Page", "this is a test Form Functionality");
				System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver_win32/chromedriver.exe");
				driver = new ChromeDriver();
				test4.log(Status.INFO, "Starting Test Case, Enter URL");
				driver.get("https://www.eventomax.com/");
				driver.manage().window().maximize();
				test4.log(Status.INFO, "Maximize the window");
				Thread.sleep(1000);
				if (driver.getTitle().equals("EventoMax | Home")) {
					test4.log(Status.PASS, "Navigated to the Articles Page");
				} else {
					test4.log(Status.FAIL, "Incorrect URL");
				}
				Thread.sleep(1000);
				/* Hover Action */
				WebElement articles = driver.findElement(By.xpath("/html/body/app-root/app-main/app-navbar/nav/div[3]/div[3]/button"));
				test4.log(Status.PASS, "Hover Articles button");
				Actions action1 = new Actions(driver);
				action1.moveToElement(articles).perform();
				Thread.sleep(1000);
				driver.findElement(By.xpath("/html/body/app-root/app-main/app-navbar/nav/div[3]/div[3]/ul/li[2]")).click();
				test4.log(Status.PASS, "Click Industry News");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"industry-news-section\"]/div/div[2]/app-article-card[3]/div/div[1]/span[2]")).click();
				test4.log(Status.PASS, "Click News 'Does Your IT Outsourcing Budget Fit Your Goals'");
				Thread.sleep(2000);

				/* Scroll into the leave a reply form */
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement flag1 = driver.findElement(By.xpath("/html/body/app-root/app-main/app-blog/div/div[2]/div/div[1]/div[2]/div[2]"));
				test4.log(Status.PASS, "Scroll down into Blogs/News Form");
				js.executeScript("arguments[0].scrollIntoView();", flag1);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"mat-input-3\"]")).sendKeys("Kristel Juen");
				test4.log(Status.PASS, "Enter Full Name");
				Thread.sleep(800);
				driver.findElement(By.xpath("//*[@id=\"mat-input-4\"]")).sendKeys("kristel.juen@cognitiv.com");
				test4.log(Status.PASS, "Enter E-mail Address");
				Thread.sleep(800);
				driver.findElement(By.xpath("//*[@id=\"mat-input-5\"]")).sendKeys("https://www.remotodojo.com/");
				test4.log(Status.PASS, "Enter Website URL");
				Thread.sleep(800);
				driver.findElement(By.xpath("//*[@id=\"mat-input-6\"]")).sendKeys("RemotoDojo Automation Testing");
				test4.log(Status.PASS, "Enter Comment");
				Thread.sleep(1000);

				driver.close();
				driver.quit();
				test4.pass("Close the browser");
				test4.info("Test Completed ");
				
				// Test 5 Text Validation
				ExtentTest test5 = extent.createTest("EventoMax Contact Page", "this is a test to Validate actual text");

				System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver_win32/chromedriver.exe");
				driver = new ChromeDriver();
				test5.log(Status.INFO, "Starting Test Case, Enter URL");
				driver.get("https://www.eventomax.com/");
				driver.manage().window().maximize();
				test5.log(Status.INFO, "Maximize the window");
				Thread.sleep(1000);
				if (driver.getTitle().equals("EventoMax | Home")) {
					test5.log(Status.PASS, "Navigated to the Home Page");
				} else {
					test5.log(Status.FAIL, "Incorrect URL");
				}
				Thread.sleep(1000);
				driver.findElement(By.xpath("//app-navbar//div[5]//button[1]")).click();
				Thread.sleep(1000);
				test5.log(Status.PASS, "Clicked Contact button");
				WebElement titleValidation = driver.findElement(By.xpath("//p[@class='my-2 text-xl font-poppins']"));
				Thread.sleep(1000);
				test5.log(Status.INFO, "Verify the Contact title is desplayed");
				// Verify the Registration title is displayed
				if (titleValidation.isDisplayed()) {
					System.out.println("Title is displayed");
					test5.log(Status.PASS, "Title is displayed");
				} else {
					System.out.println("Title is not displayed");
					test5.log(Status.PASS, "Title is not displayed");
				}
				test5.log(Status.INFO, "Validating the actual and expected text");
				// Validating the actual and expected text
				String expectedText = "Get your needs satisfied and ideas realized.";
				String actualText = titleValidation.getText();
				test5.log(Status.INFO, "Comparing text");
				// Comparing text
				if (actualText.equals(expectedText)) {
					System.out.println("The actual and expected text are the same. The title value is " + actualText);
					test5.log(Status.PASS, "The actual and expected texts are the same. The title value is " + actualText);
				} else {
					System.out.println("The actual and expected texts are not the same. The displayed text is " + actualText);
					test5.log(Status.FAIL, "The actual and expected texts are not the same. The displayed text is " + actualText);
				}

				driver.close();
				driver.quit();
				test5.pass("Close the browser");
				test5.info("Test Completed ");
				
				// Test 6 Text Validation
				ExtentTest test6 = extent.createTest("EventoMax Application Page", "this is a Form Functionality Test");

				System.setProperty("webdriver.chrome.driver",projectPath + "\\drivers\\chromedriver\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				test6.log(Status.INFO, "Starting Test Case, Enter URL");
				driver.get("https://www.eventomax.com/");
				driver.manage().window().maximize();
				test6.log(Status.INFO, "Maximize window");
				Thread.sleep(1000);
				/* Hover Action */
				WebElement about = driver
						.findElement(By.xpath("/html/body/app-root/app-main/app-navbar/nav/div[3]/div[2]/button"));
				test6.log(Status.PASS, "Hover About button");
				Actions action2 = new Actions(driver);
				action2.moveToElement(about).perform();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//li[contains(text(),'Join us')]")).click();
				test6.log(Status.PASS, "Click Join us");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//li[contains(text(),'Join us')]")).click();
				test6.log(Status.PASS, "Click Join us");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[normalize-space()='VISIT CAREERS']")).click();
				test6.log(Status.PASS, "Click View Careers");
				Thread.sleep(2000);

				driver.findElement(By.xpath("//div[@class='section-container padded']//div[1]//app-position-card[1]//div[1]//div[1]")).click();
				test6.log(Status.PASS, "Click iOS Developer - Swift");

				Thread.sleep(2000);
				driver.findElement(By.xpath("//app-button[@class='hidden lg:block']//button[@type='button']")).click();
				test6.log(Status.PASS, "Click Apply Now Button");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("Kristel");
				test6.log(Status.PASS, "Enter First Name");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("Juen");
				test6.log(Status.PASS, "Enter Last Name");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='mat-input-2']")).sendKeys("KRISTEL.juen@cognitiv.com");
				test6.log(Status.PASS, "Enter Email Address");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"mat-input-3\"]")).sendKeys("9310235047");
				test6.log(Status.PASS, "Enter Phone Number");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='mat-input-4']")).sendKeys("Lapu - Lapu City");
				test6.log(Status.PASS, "Enter Address");
				Thread.sleep(1000);

				WebElement cntry = driver.findElement(By.xpath("//*[@id=\"mat-select-value-3\"]/span"));
				
				cntry.click();
				Thread.sleep(1000);

				/* Scroll into the leave a reply form */
				JavascriptExecutor js2 = (JavascriptExecutor) driver;
				WebElement flag2 = driver.findElement(By.xpath("//*[@id=\"mat-option-412\"]"));
				
				js2.executeScript("arguments[0].scrollIntoView();", flag2);
				
				Thread.sleep(2000);
				flag2.click();
				test6.log(Status.PASS, "Enter Country");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"application-form-section\"]/div[1]/div/form/mat-form-field[6]/div/div[1]/div[3]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"mat-option-488\"]/span")).click();
				test6.log(Status.PASS, "Selected one of the choices of question Where did you hear about this offer?");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[normalize-space()='UPLOAD RESUME']")).click();
				test6.log(Status.PASS, "Click Upload Resume Button");
				Thread.sleep(2000);
				Runtime.getRuntime().exec(projectPath + "/FileUploadScript/fileUploadScript.exe");
				test6.log(Status.PASS, "Uploaded file");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[normalize-space()='SUBMIT']")).click();
				test6.log(Status.PASS, "Click Submit Button");
				Thread.sleep(4000);
				driver.close();
				driver.quit();
				test6.pass("Close the browser");
				test6.info("Test Completed ");

		extent.flush();

	}

}
