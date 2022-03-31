package test;

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

public class RemotoDojo_Test {
	private static WebDriver driver = null;

	public static void main(String[] args) throws Exception {

		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(
				"target/RemotoDojo_ExtentReport.html"); /* Test Report is saved in Target folder */
		extent.attachReporter(spark);

		// Test 1 RESTRATION FORM
		ExtentTest test1 = extent.createTest("RemotoDojo Home Page Test",
				"This is to test each section of the Home Page");
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);

		System.setProperty("webdriver.chrome.driver",
				projectPath + "/drivers/chromedriver/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();

		test1.log(Status.INFO, "Starting Test Case, Enter URL");
		driver.get("https://www.remotodojo.com/");
		driver.manage().window().maximize();
		test1.log(Status.INFO, "Maximize the window");
		if (driver.getTitle().equals("RemotoDojo | Home")) {
			test1.log(Status.PASS, "Navigated to the RemotoDojo Home Page");
		} else {
			test1.log(Status.FAIL, "Incorrect URL");
		}
		Thread.sleep(1000);

		/* Hover Services Section */
		WebElement ser = driver.findElement(
				By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[1]/BUTTON[1]"));
		Actions ser2 = new Actions(driver);
		ser2.moveToElement(ser).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[1]/UL[1]/LI[2]"))
				.click();
		Thread.sleep(1000);
		test1.log(Status.INFO, "Navigate to Services");

		/* Click Cards Services */
		driver.findElement(By.xpath("id(\"mat-tab-label-1-1\")/DIV[1]")).click();
		Thread.sleep(800);
		test1.log(Status.PASS, "Click on IT Services tab");

		/* Click Responsive Websites */
		driver.findElement(By.cssSelector("div.ng-tns-c60-4 div.border-primary div.p-1")).click();
		Thread.sleep(800);
		test1.log(Status.PASS, "Click Responsive Websites");

		/* Click Website as a Service */
		WebElement titleValidation = driver.findElement(By.xpath(
				"/html/body/app-root/app-main/app-home/div/div/div[4]/div/div[2]/div[1]/mat-tab-group/div/mat-tab-body[2]/div/div[2]/div[1]/div[2]"));
		Thread.sleep(800);
		// Verify the Registration title is displayed
		if (titleValidation.isDisplayed()) {
			System.out.println("Title is displayed");
		} else {
			System.out.println("Title is not displayed");
		}

		// Validating the actual and expected text
		String expectedText = "Website as a Service";
		String actualText = titleValidation.getText();
		// Comparing text
		if (actualText.equals(expectedText)) {
			System.out.println("The actual and expected text are the same. The title value is " + actualText);
			titleValidation.click();
		} else {
			System.out.println("The actual and expected texts are not the same. The displayed text is " + actualText);
		}
		Thread.sleep(800);
		test1.log(Status.PASS, "Click Website as a Service");

		/* Click Content Creation */
		WebElement titleValidation1 = driver.findElement(By.xpath(
				"/html/body/app-root/app-main/app-home/div/div/div[4]/div/div[2]/div[1]/mat-tab-group/div/mat-tab-body[2]/div/div[3]/div[1]/div[2]"));
		Thread.sleep(800);
		// Verify the Registration title is displayed
		if (titleValidation1.isDisplayed()) {
			System.out.println("Title is displayed");
		} else {
			System.out.println("Title is not displayed");
		}
		// Validating the actual and expected text
		String expectedText1 = "Content Creation";
		String actualText1 = titleValidation1.getText();
		// Comparing text
		if (actualText1.equals(expectedText1)) {
			System.out.println("The actual and expected text are the same. The title value is " + actualText1);
			titleValidation1.click();
		} else {
			System.out.println("The actual and expected texts are not the same. The displayed text is " + actualText1);
		}
		Thread.sleep(1000);
		test1.log(Status.PASS, "Click Content Creation");

		/* Hover Why Us Section */
		WebElement why = driver.findElement(
				By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[1]/BUTTON[1]"));
		Actions why1 = new Actions(driver);
		why1.moveToElement(why).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[1]/UL[1]/LI[3]"))
				.click();
		test1.log(Status.INFO, "Navigate to Why Us Section");
		Thread.sleep(800);

		WebElement sg = driver.findElement(
				By.xpath("/html/body/app-root/app-main/app-home/div/div/div[6]/div[1]/div[2]/div/div[1]/div"));
		Actions sg1 = new Actions(driver);
		sg1.moveToElement(sg).perform();
		Thread.sleep(800);
		test1.log(Status.PASS, "Hover Singapore bar");

		WebElement aus = driver.findElement(
				By.xpath("/html/body/app-root/app-main/app-home/div/div/div[6]/div[1]/div[2]/div/div[2]/div"));
		Actions aus1 = new Actions(driver);
		aus1.moveToElement(aus).perform();
		Thread.sleep(800);
		test1.log(Status.PASS, "Hover Australia bar");

		WebElement uk = driver.findElement(
				By.xpath("/html/body/app-root/app-main/app-home/div/div/div[6]/div[1]/div[2]/div/div[3]/div"));
		Actions uk1 = new Actions(driver);
		uk1.moveToElement(uk).perform();
		Thread.sleep(800);
		test1.log(Status.PASS, "Hover United Kingdom bar");

		WebElement usa = driver.findElement(
				By.xpath("/html/body/app-root/app-main/app-home/div/div/div[6]/div[1]/div[2]/div/div[4]/div"));
		Actions usa1 = new Actions(driver);
		usa1.moveToElement(usa).perform();
		Thread.sleep(800);
		test1.log(Status.PASS, "Hover USA bar");

		/* Scroll into pricing */
		JavascriptExecutor price = (JavascriptExecutor) driver;
		WebElement price2 = driver
				.findElement(By.xpath("/html/body/app-root/app-main/app-home/div/div/div[6]/div[1]/div[1]/span"));
		price.executeScript("arguments[0].scrollIntoView();", price2);
		Thread.sleep(1000);
		test1.log(Status.PASS, "Scroll to Pricing Section");
		driver.findElement(
				By.xpath("/html/body/app-root/app-main/app-home/div/div/div[6]/div[3]/div[2]/div[1]/div[3]/button[2]"))
				.click();
		Thread.sleep(1000);
		test1.log(Status.PASS, "Select IT Pricing");

		/* Hover Our Works Section */
		WebElement our = driver.findElement(
				By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[1]/BUTTON[1]"));
		Actions our1 = new Actions(driver);
		our1.moveToElement(our).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[1]/UL[1]/LI[4]"))
				.click();
		test1.log(Status.INFO, "Navigate to Our Works Section");
		Thread.sleep(2000);

		/* Scroll into testimonials */
		JavascriptExecutor test = (JavascriptExecutor) driver;
		WebElement js = driver.findElement(By
				.xpath("/html/body/app-root/app-main/app-home/div/div/div[8]/div[1]/div[2]/owl-carousel-o/div/div[2]"));
		test.executeScript("arguments[0].scrollIntoView();", js);
		Thread.sleep(2000);
		test1.log(Status.PASS, "Scroll to Testimonials Section");

		/* Scroll into world */
		JavascriptExecutor world = (JavascriptExecutor) driver;
		WebElement world1 = driver.findElement(
				By.xpath("/html/body/app-root/app-main/app-home/div/div/div[8]/div[3]/div[2]/div/div/div[4]/div[2]/p"));
		world.executeScript("arguments[0].scrollIntoView();", world1);
		Thread.sleep(1000);
		test1.log(Status.PASS, "Scroll to World Map");

		driver.findElement(By.xpath("id(\"canada\")")).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("id(\"usa\")")).click();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"Path_192\")")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"Australia\")")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"Path_174\")")).click();
		Thread.sleep(1000);

		/* Hover Contact Section */
		WebElement con = driver.findElement(
				By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[1]/BUTTON[1]"));
		Actions con1 = new Actions(driver);
		con1.moveToElement(con).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[1]/UL[1]/LI[5]"))
				.click();
		Thread.sleep(1000);
		test1.log(Status.INFO, "Navigate to Contact Section");

		driver.close();
		driver.quit();
		test1.pass("Close the browser");
		test1.info("Test Completed ");

		/* TEST 2 */
		ExtentTest test2 = extent.createTest("RemotoDojo About Page",
				"Test purpose is to hover and show hidden texts of each section");
		System.setProperty("webdriver.chrome.driver",
				projectPath + "/drivers/chromedriver/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		test2.log(Status.INFO, "Starting Test Case, Enter URL");

		driver.get("https://www.remotodojo.com/about");
		driver.manage().window().maximize();
		test2.log(Status.INFO, "Maximize the window");

		/* Hover Who We Are Section */
		WebElement about = driver
				.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[2]/BUTTON[1]"));
		Actions action2 = new Actions(driver);
		action2.moveToElement(about).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[2]/UL[1]/LI[1]"))
				.click();
		test2.log(Status.PASS, "Navigate to Who We Are Section");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"who-we-are-section\"]/div[2]/app-benefits-card[1]/div")).click();
		Thread.sleep(1000);
		test2.log(Status.PASS, "Hover Clients Cards");
		driver.findElement(By.xpath("//*[@id=\"who-we-are-section\"]/div[2]/app-benefits-card[2]/div")).click();
		Thread.sleep(1000);
		test2.log(Status.PASS, "Hover Projects Cards");
		driver.findElement(By.xpath("//*[@id=\"who-we-are-section\"]/div[2]/app-benefits-card[3]/div")).click();
		Thread.sleep(1000);
		test2.log(Status.PASS, "Hover Employees Cards");
		driver.findElement(By.xpath("//*[@id=\"who-we-are-section\"]/div[2]/app-benefits-card[4]/div")).click();
		Thread.sleep(1000);
		test2.log(Status.PASS, "Hover Countries Cards");

		/* Scroll into Clientele */
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		WebElement flag2 = driver.findElement(By.xpath("/html/body/app-root/app-main/app-about/div[3]"));
		js2.executeScript("arguments[0].scrollIntoView();", flag2);
		Thread.sleep(2000);
		test2.log(Status.PASS, "Scroll into Clientele Section");

		test2.info("Couldn't hover the canvas doughnut");

		/* Hover The Bosses Section */
		WebElement boss = driver
				.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[2]/BUTTON[1]"));
		Actions boss1 = new Actions(driver);
		boss1.moveToElement(boss).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[2]/UL[1]/LI[4]"))
				.click();
		Thread.sleep(1000);
		test2.log(Status.INFO, "Navigate to The Bosses Section");

		driver.findElement(By.xpath("//*[@id=\"bosses-section\"]/div[1]/app-staff-card/div/div")).click();
		Thread.sleep(1000);
		test2.log(Status.PASS, "Hover sir Leons' quotes");
		driver.findElement(By.xpath("//*[@id=\"bosses-section\"]/div[2]/div[3]/app-staff-card/div/div")).click();
		Thread.sleep(1000);
		test2.log(Status.PASS, "Hover Ians' quotes");

		/* Scroll to Sales Force */
		JavascriptExecutor staff = (JavascriptExecutor) driver;
		WebElement staff1 = driver.findElement(By.xpath("/html/body/app-root/app-main/app-about/div[9]"));
		staff.executeScript("arguments[0].scrollIntoView();", staff1);
		Thread.sleep(1000);
		test2.log(Status.PASS, "Scroll to Sales Force");

		test2.log(Status.PASS, "Hover Ryans' quotes");
		driver.findElement(
				By.xpath("/html/body/app-root/app-main/app-about/div[10]/div/div[3]/div/app-staff-card[1]/div/div"))
				.click();
		Thread.sleep(1000);
		test2.log(Status.PASS, "Hover Christyls' quotes");

		/* Scroll to Amazing Ninjas */
		JavascriptExecutor jamjam = (JavascriptExecutor) driver;
		WebElement jam = driver.findElement(
				By.xpath("/html/body/app-root/app-main/app-about/div[12]/div/div[2]/div[2]/app-staff-card[9]/div"));
		jamjam.executeScript("arguments[0].scrollIntoView();", jam);
		Thread.sleep(1000);
		test2.log(Status.PASS, "Scroll to Amazing Ninjas");
		driver.findElement(
				By.xpath("/html/body/app-root/app-main/app-about/div[12]/div/div[2]/div[2]/app-staff-card[18]/div/div"))
				.click();
		Thread.sleep(1000);
		test2.log(Status.PASS, "Hover Kristels' quotes");
		driver.findElement(
				By.xpath("/html/body/app-root/app-main/app-about/div[12]/div/div[2]/div[2]/app-staff-card[20]/div/div"))
				.click();
		Thread.sleep(1000);
		test2.log(Status.PASS, "Hover Karlos' quotes");

		/* Scroll to Visit Careers Section */
		JavascriptExecutor fot = (JavascriptExecutor) driver;
		WebElement fot1 = driver.findElement(By.xpath("/html/body/app-root/app-main/app-about/div[14]/img[2]"));
		fot.executeScript("arguments[0].scrollIntoView();", fot1);
		Thread.sleep(2000);
		test2.log(Status.INFO, "Navigate to Careers Section");

		/* Hover Brochure Section */
		WebElement bro = driver
				.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[2]/BUTTON[1]"));
		Actions bro1 = new Actions(driver);
		bro1.moveToElement(bro).perform();
		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[2]/UL[1]/LI[3]"))
				.click();
		Thread.sleep(2000);
		test2.log(Status.INFO, "Navigate to Brochure Section");
		driver.findElement(By.xpath("id(\"brochure-section\")/DIV[2]/DIV[2]/APP-BUTTON[1]/BUTTON[1]")).click();
		Thread.sleep(7000);
		test2.log(Status.PASS, "Click Download Brochure");

		driver.close();
		driver.quit();
		test2.pass("Close the browser");
		test2.info("Test 2 Completed ");

		// Test 3
		ExtentTest test3 = extent.createTest("RemotoDojo Careers Page",
				"this is a test to validate Application Form functionality");

		System.setProperty("webdriver.chrome.driver",
				projectPath + "/drivers/chromedriver/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();

		test3.log(Status.INFO, "Starting Test Case, Enter URL");
		driver.get("https://www.remotodojo.com/careers");
		driver.manage().window().maximize();
		test3.log(Status.INFO, "Maximize the window");
		Thread.sleep(1000);

		driver.findElement(
				By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-CAREERS[1]/DIV[1]/DIV[2]/DIV[1]/APP-BUTTON[1]/BUTTON[1]"))
				.click();
		Thread.sleep(2000);
		test3.log(Status.PASS, "Click View Positions");
		driver.findElement(By.xpath("id(\"open-positions\")/DIV[1]/DIV[2]/DIV[2]/DIV[1]/APP-POSITION-CARD[1]/DIV[1]"))
				.click();
		Thread.sleep(2000);
		test3.log(Status.PASS, "Select iOS Developer - Swift");
		driver.findElement(By.xpath(
				"//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-POSITION[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/APP-BUTTON[1]/BUTTON[1]"))
				.click();
		Thread.sleep(2000);
		test3.log(Status.PASS, "Click Apply Now button");
		driver.findElement(By.xpath("id(\"mat-input-0\")")).sendKeys("Kristel");
		Thread.sleep(800);
		test3.log(Status.PASS, "Enter First Name");
		driver.findElement(By.xpath("id(\"mat-input-1\")")).sendKeys("Juen");
		Thread.sleep(800);
		test3.log(Status.PASS, "Enter Last Name");
		driver.findElement(By.xpath("id(\"mat-input-2\")")).sendKeys("KRISTEL.juen@cognitiv.com");
		Thread.sleep(800);
		test3.log(Status.PASS, "Enter E-mail Address");
		driver.findElement(By.xpath("id(\"mat-input-3\")")).sendKeys("93102352647");
		Thread.sleep(800);
		test3.log(Status.PASS, "Enter Phone Number");
		driver.findElement(By.xpath("id(\"mat-input-4\")")).sendKeys("BABAG II, LAPU - LAPU CITY");
		Thread.sleep(800);
		test3.log(Status.PASS, "Enter Address");
		driver.findElement(By.xpath("id(\"mat-select-value-3\")/SPAN[1]")).click();
		Thread.sleep(1000);

		/* Scroll into the Philippines */
		JavascriptExecutor cntry = (JavascriptExecutor) driver;
		WebElement cntry1 = driver.findElement(By.xpath("id(\"mat-option-412\")/SPAN[1]"));
		cntry.executeScript("arguments[0].scrollIntoView", cntry1);
		cntry1.click();
		test3.log(Status.PASS, "Select Philippines");
		Thread.sleep(1000);

		driver.findElement(By.xpath("id(\"mat-select-value-5\")/SPAN[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"mat-option-488\")/SPAN[1]")).click();
		test3.log(Status.PASS, "Select I rather not say");
		Thread.sleep(2000);
		driver.findElement(By
				.xpath("id(\"application-form-section\")/DIV[1]/DIV[1]/FORM[1]/DIV[3]/DIV[1]/APP-BUTTON[1]/BUTTON[1]"))
				.click();
		Thread.sleep(2000);
		test3.log(Status.PASS, "Click Upload Resume");
		Runtime.getRuntime().exec(projectPath + "/FileUploadScript/fileUploadScript.exe");
		Thread.sleep(2000);
		test3.log(Status.PASS, "Upload Resume");
		driver.findElement(
				By.xpath("id(\"application-form-section\")/DIV[1]/DIV[1]/FORM[1]/DIV[3]/APP-BUTTON[1]/BUTTON[1]"))
				.click();
		Thread.sleep(3000);
		test3.log(Status.PASS, "Click Submit button");

		driver.close();
		driver.quit();
		test3.pass("Close the browser");
		test3.info("Test Completed ");

		// Test 4 ARTICLES
		ExtentTest test4 = extent.createTest("RemotoDojo Articles Page",
				"this test is to validate form and clickable elements functionalities");

		System.setProperty("webdriver.chrome.driver",
				projectPath + "/drivers/chromedriver/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		test4.log(Status.INFO, "Starting Test Case, Enter URL");
		driver.get("https://www.remotodojo.com/");
		driver.manage().window().maximize();
		test4.log(Status.INFO, "Maximize the window");
		Thread.sleep(1000);

		/* Hover Articles Section */
		WebElement news = driver
				.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[3]/BUTTON[1]"));
		Actions news2 = new Actions(driver);
		news2.moveToElement(news).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[3]/UL[1]/LI[2]"))
				.click();
		test4.log(Status.PASS, "Navigate to Industry News Section");
		Thread.sleep(2000);
		driver.findElement(By
				.xpath("id(\"industry-news-section\")/DIV[1]/DIV[2]/APP-ARTICLE-CARD[1]/DIV[1]/DIV[2]/DIV[1]/SPAN[1]"))
				.click();
		Thread.sleep(2000);
		test4.log(Status.PASS, "Select Cyber Monday News");

		/* Scroll to Reply Form */
		JavascriptExecutor form = (JavascriptExecutor) driver;
		WebElement form1 = driver.findElement(
				By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-BLOG[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[2]/DIV[2]"));
		form.executeScript("arguments[0].scrollIntoView();", form1);
		Thread.sleep(2000);
		test4.log(Status.PASS, "Scroll to Leave a Reply Form");

		/* Fill - up Form */
		driver.findElement(By.xpath("id(\"mat-input-3\")")).sendKeys("KRISTEL JUEN");
		Thread.sleep(800);
		test4.log(Status.PASS, "Enter Full Name");
		driver.findElement(By.xpath("id(\"mat-input-4\")")).sendKeys("KRISTEL.juen@COGNitiv.com");
		Thread.sleep(800);
		test4.log(Status.PASS, "Enter Email");
		driver.findElement(By.xpath("id(\"mat-input-5\")")).sendKeys("https://www.eventomax.com/");
		Thread.sleep(800);
		test4.log(Status.PASS, "Enter Website URL");
		driver.findElement(By.xpath("id(\"mat-input-6\")")).sendKeys("Selenium Automation Testing");
		Thread.sleep(800);
		test4.log(Status.PASS, "Enter Comment");
		driver.findElement(By.xpath("id(\"mat-checkbox-1\")/LABEL[1]/SPAN[1]")).click();
		Thread.sleep(1000);
		test4.log(Status.PASS, "Click Checkbox");

		/* Go back to Articles Page */
		driver.get("https://www.remotodojo.com/articles#blog-section");
		Thread.sleep(1000);
		test4.log(Status.PASS, "Go back to Articles Page");
		WebElement search = driver.findElement(By.xpath("id(\"mat-input-1\")"));
		search.sendKeys("Days at the Dojo", Keys.RETURN);
		Thread.sleep(1000);
		test4.log(Status.PASS, "Search Days at the Dojo");

		/* Click Blogs Categories */
		driver.findElement(By.xpath("id(\"blog-section\")/DIV[1]/DIV[2]/DIV[3]/DIV[2]/APP-LIST-ITEM[1]/DIV[1]/SPAN[1]"))
				.click();
		Thread.sleep(1000);
		test4.log(Status.PASS, "Click Affordable Software Engineer");
		driver.findElement(By.xpath("id(\"blog-section\")/DIV[1]/DIV[2]/DIV[3]/DIV[2]/APP-LIST-ITEM[2]/DIV[1]/SPAN[1]"))
				.click();
		Thread.sleep(1000);
		test4.log(Status.PASS, "Click Days at the Dojo");
		driver.findElement(By.xpath("id(\"blog-section\")/DIV[1]/DIV[2]/DIV[3]/DIV[2]/APP-LIST-ITEM[3]/DIV[1]/SPAN[1]"))
				.click();
		Thread.sleep(1000);
		test4.log(Status.PASS, "Click DOJI Newsletter");
		driver.findElement(By.xpath("id(\"blog-section\")/DIV[1]/DIV[2]/DIV[3]/DIV[2]/APP-LIST-ITEM[4]/DIV[1]/SPAN[1]"))
				.click();
		Thread.sleep(1000);
		test4.log(Status.PASS, "Click E-Commerce");
		driver.findElement(By.xpath("id(\"blog-section\")/DIV[1]/DIV[2]/DIV[3]/DIV[2]/APP-LIST-ITEM[5]/DIV[1]/SPAN[1]"))
				.click();
		Thread.sleep(1000);
		test4.log(Status.PASS, "Click IT Recruitment");
		driver.findElement(By.xpath("id(\"blog-section\")/DIV[1]/DIV[2]/DIV[3]/DIV[2]/APP-LIST-ITEM[6]/DIV[1]/SPAN[1]"))
				.click();
		Thread.sleep(1000);
		test4.log(Status.PASS, "Click Outsourcing");
		driver.findElement(By.xpath("id(\"blog-section\")/DIV[1]/DIV[2]/DIV[3]/DIV[2]/APP-LIST-ITEM[7]/DIV[1]/SPAN[1]"))
				.click();
		Thread.sleep(1000);
		test4.log(Status.PASS, "Click Responsive Web Design");
		driver.findElement(By.xpath("id(\"blog-section\")/DIV[1]/DIV[2]/DIV[3]/DIV[2]/APP-LIST-ITEM[8]/DIV[1]/SPAN[1]"))
				.click();
		Thread.sleep(1000);
		test4.log(Status.PASS, "Click SEO");
		driver.findElement(By.xpath("id(\"blog-section\")/DIV[1]/DIV[2]/DIV[3]/DIV[2]/APP-LIST-ITEM[9]/DIV[1]/SPAN[1]"))
				.click();
		Thread.sleep(1000);
		test4.log(Status.PASS, "Click Website Development");

		/* Scroll Industry News Section */
		JavascriptExecutor ind = (JavascriptExecutor) driver;
		WebElement ind1 = driver.findElement(
				By.xpath("id(\"blog-section\")/DIV[1]/DIV[2]/DIV[3]/DIV[2]/APP-LIST-ITEM[9]/DIV[1]/SPAN[1]"));
		ind.executeScript("arguments[0].scrollIntoView();", ind1);
		Thread.sleep(2000);
		test4.log(Status.PASS, "Scroll to Industry News Section");

		/* Click Page 2 */
		driver.findElement(
				By.xpath("id(\"industry-news-section\")/DIV[1]/DIV[3]/APP-PAGINATOR[1]/DIV[1]/DIV[1]/BUTTON[3]"))
				.click();
		Thread.sleep(1000);
		test4.log(Status.PASS, "Click Page 2");
		/* Click Page 3 */
		driver.findElement(
				By.xpath("id(\"industry-news-section\")/DIV[1]/DIV[3]/APP-PAGINATOR[1]/DIV[1]/DIV[1]/BUTTON[5]"))
				.click();
		Thread.sleep(1000);
		test4.log(Status.PASS, "Click Page 3");

		driver.close();
		driver.quit();
		test4.pass("Close the browser");
		test4.info("Test Completed ");

		// Test 5 RESTRATION FORM
		ExtentTest test5 = extent.createTest("RemotoDojo Business Angels Page",
				"Purpose of this test is to automate scroll and validate Get in Touch form functionality.");

		System.setProperty("webdriver.chrome.driver",
				projectPath + "/drivers/chromedriver/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();

		test5.log(Status.INFO, "Starting Test Case, Enter URL");
		driver.get("https://www.remotodojo.com/business");
		driver.manage().window().maximize();
		test5.log(Status.INFO, "Maximize the window");
		Thread.sleep(1000);

		JavascriptExecutor grow = (JavascriptExecutor) driver;
		WebElement grow1 = driver.findElement(By.xpath("id(\"business-section\")/DIV[2]"));
		grow.executeScript("arguments[0].scrollIntoView();", grow1);
		test5.log(Status.PASS, "Scroll to Grow your business Section");
		Thread.sleep(1000);
		driver.findElement(By.xpath("id(\"grow-business-section\")/DIV[1]/DIV[1]/DIV[2]/BUTTON[1]")).click();
		Thread.sleep(1000);
		test5.log(Status.PASS, "Hover Connections");
		driver.findElement(By.xpath("id(\"grow-business-section\")/DIV[1]/DIV[1]/DIV[2]/BUTTON[2]")).click();
		Thread.sleep(1000);
		test5.log(Status.PASS, "Hover Funding");
		driver.findElement(By.xpath("id(\"grow-business-section\")/DIV[1]/DIV[1]/DIV[2]/BUTTON[3]")).click();
		Thread.sleep(1000);
		test5.log(Status.PASS, "Hover Mentoring");

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement ques = driver
				.findElement(By.xpath("id(\"grow-business-section\")/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]"));
		js1.executeScript("arguments[0].scrollIntoView();", ques);
		Thread.sleep(1000);

		JavascriptExecutor ad = (JavascriptExecutor) driver;
		WebElement advantage = driver.findElement(By.xpath("id(\"advantages-section\")/DIV[1]"));
		ad.executeScript("arguments[0].scrollIntoView();", advantage);
		Thread.sleep(1000);
		test5.log(Status.PASS, "Scroll to Advantage Section");

		driver.findElement(By.xpath(
				"id(\"advantages-section\")/DIV[1]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/APP-COLLAPSE-CARD[1]/DIV[1]/DIV[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"id(\"advantages-section\")/DIV[1]/DIV[1]/DIV[2]/DIV[1]/DIV[2]/APP-COLLAPSE-CARD[1]/DIV[1]/DIV[1]/SPAN[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"id(\"advantages-section\")/DIV[1]/DIV[1]/DIV[2]/DIV[1]/DIV[3]/APP-COLLAPSE-CARD[1]/DIV[1]/DIV[1]/SPAN[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"id(\"advantages-section\")/DIV[1]/DIV[1]/DIV[2]/DIV[1]/DIV[4]/APP-COLLAPSE-CARD[1]/DIV[1]/DIV[1]/SPAN[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"id(\"advantages-section\")/DIV[1]/DIV[1]/DIV[2]/DIV[1]/DIV[5]/APP-COLLAPSE-CARD[1]/DIV[1]/DIV[1]/SPAN[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"id(\"advantages-section\")/DIV[1]/DIV[1]/DIV[2]/DIV[1]/DIV[5]/APP-COLLAPSE-CARD[1]/DIV[1]/DIV[1]/SPAN[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"id(\"advantages-section\")/DIV[1]/DIV[1]/DIV[2]/DIV[2]/DIV[1]/APP-COLLAPSE-CARD[1]/DIV[1]/DIV[1]/SPAN[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"id(\"advantages-section\")/DIV[1]/DIV[1]/DIV[2]/DIV[2]/DIV[2]/APP-COLLAPSE-CARD[1]/DIV[1]/DIV[1]/SPAN[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"id(\"advantages-section\")/DIV[1]/DIV[1]/DIV[2]/DIV[2]/DIV[3]/APP-COLLAPSE-CARD[1]/DIV[1]/DIV[1]/SPAN[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"id(\"advantages-section\")/DIV[1]/DIV[1]/DIV[2]/DIV[2]/DIV[4]/APP-COLLAPSE-CARD[1]/DIV[1]/DIV[1]/SPAN[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"id(\"advantages-section\")/DIV[1]/DIV[1]/DIV[2]/DIV[2]/DIV[5]/APP-COLLAPSE-CARD[1]/DIV[1]/DIV[1]/SPAN[1]"))
				.click();
		Thread.sleep(1000);

		test5.log(Status.PASS, "Display each advantages");
		WebElement angles = driver
				.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[4]/BUTTON[1]"));
		Actions ac = new Actions(driver);
		ac.moveToElement(angles).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[4]/UL[1]/LI[2]"))
				.click();
		Thread.sleep(1000);
		test5.log(Status.PASS, "Navigate on Get in Touch Form");

		driver.findElement(By.xpath("id(\"mat-input-0\")")).sendKeys("KRISTEL");
		Thread.sleep(1000);
		test5.log(Status.PASS, "Enter First Name");
		driver.findElement(By.xpath("id(\"mat-input-1\")")).sendKeys("JUEN");
		Thread.sleep(1000);
		test5.log(Status.PASS, "Enter Last Name");
		driver.findElement(By.xpath("id(\"mat-input-2\")")).sendKeys("KRISTEL JUEN");
		Thread.sleep(1000);
		test5.log(Status.PASS, "Enter Startup Name");
		driver.findElement(By.xpath("id(\"mat-input-3\")")).sendKeys("KRISTEL.juen@COGNITIV.com");
		Thread.sleep(1000);
		test5.log(Status.PASS, "Enter E-mail Address");
		driver.findElement(By.xpath("id(\"mat-input-4\")")).sendKeys("9310235634");
		Thread.sleep(1000);
		test5.log(Status.PASS, "Enter Phone Number");
		driver.findElement(By.xpath("id(\"mat-input-5\")")).sendKeys("Automation Testing");
		Thread.sleep(1000);
		test5.log(Status.PASS, "Enter Message");
		driver.findElement(By.xpath("id(\"get-in-touch-section\")/DIV[1]/FORM[1]/DIV[2]/APP-BUTTON[1]/BUTTON[1]"))
				.click();
		Thread.sleep(2500);
		test5.log(Status.PASS, "Click Submit button");

		driver.close();
		driver.quit();
		test5.pass("Close the browser");
		test5.info("Test Completed ");

		// Test 6 CONTACT FORM
		ExtentTest test6 = extent.createTest("RemotoDojo Contact Page",
				"this is a test to validate Contact Form functionality and display Privacy Policy.");

		System.setProperty("webdriver.chrome.driver",
				projectPath + "/drivers/chromedriver/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();

		test6.log(Status.INFO, "Starting Test Case, Enter URL");
		driver.get("https://www.remotodojo.com/contact");
		driver.manage().window().maximize();
		test6.log(Status.INFO, "Maximize the window");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/DIV[5]/BUTTON[1]"))
				.click();
		Thread.sleep(1000);
		test6.log(Status.PASS, "Click Contact button");
		driver.findElement(By.xpath("id(\"mat-select-value-1\")/SPAN[1]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("id(\"mat-option-243\")/SPAN[1]")).click();
		Thread.sleep(1000);
		test6.log(Status.PASS, "Select Service");
		driver.findElement(By.xpath("id(\"mat-input-0\")")).sendKeys("Kristel");
		Thread.sleep(1000);
		test6.log(Status.PASS, "Enter First Name");
		driver.findElement(By.xpath("id(\"mat-input-1\")")).sendKeys("kristel.juen@cognitiv.com");
		Thread.sleep(1000);
		test6.log(Status.PASS, "Enter E-mail Address");
		driver.findElement(By.xpath("id(\"mat-input-2\")")).sendKeys("9310235681");
		Thread.sleep(1000);
		test6.log(Status.PASS, "Enter Phone Number");
		driver.findElement(By.xpath("id(\"mat-input-3\")")).sendKeys("Selenium Automation Testing");
		Thread.sleep(1000);
		test6.log(Status.PASS, "Enter Message");

		JavascriptExecutor pol = (JavascriptExecutor) driver;
		WebElement footer = driver.findElement(By.xpath("id(\"contact-page\")/DIV[2]"));
		pol.executeScript("arguments[0].scrollIntoView();", footer);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-FOOTER[1]/DIV[1]/DIV[1]/DIV[3]/DIV[1]/SPAN[3]"))
				.click();
		Thread.sleep(2000);
		test6.log(Status.PASS, "Click Privacy Policy");

		JavascriptExecutor infos = (JavascriptExecutor) driver;
		WebElement info = driver.findElement(By.xpath("id(\"information-collected\")/DIV[1]"));
		infos.executeScript("arguments[0].scrollIntoView();", info);
		Thread.sleep(2000);

		JavascriptExecutor logs = (JavascriptExecutor) driver;
		WebElement log = driver.findElement(By.xpath("id(\"log-files\")/DIV[1]"));
		logs.executeScript("arguments[0].scrollIntoView();", log);
		Thread.sleep(2000);

		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		WebElement third = driver.findElement(By.xpath("id(\"third-party-policy\")/DIV[1]"));
		js3.executeScript("arguments[0].scrollIntoView();", third);
		Thread.sleep(2000);

		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		WebElement right = driver.findElement(By.xpath("id(\"data-protect-rights\")/P[1]"));
		js4.executeScript("arguments[0].scrollIntoView();", right);
		Thread.sleep(2000);
		test6.log(Status.PASS, "Scroll Page");

		driver.close();
		driver.quit();
		test6.pass("Close the browser");
		test6.info("Test Completed ");

		// Test 7 REGISTRATION AND LOGIN
		ExtentTest test7 = extent.createTest("RemotoDojo Registration and Log-in Page",
				"this is a test to validate Registration and Log-in Form functionality");

		System.setProperty("webdriver.chrome.driver",
				projectPath + "/drivers/chromedriver/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();

		test7.log(Status.INFO, "Starting Test Case, Enter URL");
		driver.get("https://www.remotodojo.com/");
		driver.manage().window().maximize();
		test7.log(Status.INFO, "Maximize the window");
		Thread.sleep(1000);

		driver.findElement(
				By.xpath("//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-NAVBAR[1]/NAV[1]/DIV[3]/APP-BUTTON[1]/BUTTON[1]")).click();
		Thread.sleep(2000);
		test7.log(Status.PASS, "Click Log-in Page");
		driver.findElement(By.xpath("id(\"mat-input-0\")")).sendKeys("KRISTEL");
		Thread.sleep(1000);
		test7.log(Status.PASS, "Enter First Name");
		driver.findElement(By.xpath("id(\"mat-input-1\")")).sendKeys("Juen");
		Thread.sleep(1000);
		test7.log(Status.PASS, "Enter Last");
		driver.findElement(By.xpath("id(\"mat-input-2\")")).sendKeys("93102354494");
		Thread.sleep(1000);
		test7.log(Status.PASS, "Enter Phone Number");
		driver.findElement(By.xpath("id(\"mat-input-3\")")).sendKeys("KRISTEL.JUEN@COGNITIV.COM");
		Thread.sleep(1000);
		test7.log(Status.PASS, "Enter E-mail Address");
		driver.findElement(By.xpath("id(\"mat-input-4\")")).sendKeys("Automation Testing");
		Thread.sleep(1000);
		test7.log(Status.PASS, "Enter Message");
		driver.findElement(By.xpath("id(\"mat-checkbox-1\")/LABEL[1]/SPAN[1]")).click();
		Thread.sleep(1000);
		test7.log(Status.PASS, "Click I agree Privacy Policy");
		driver.findElement(By.xpath(
				"//BODY/APP-ROOT[1]/APP-MAIN[1]/APP-ACCOUNTS[1]/APP-REGISTER[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/APP-BUTTON[1]/BUTTON[1]"))
				.click();
		Thread.sleep(1000);
		test7.log(Status.PASS, "Click Login button");
		driver.findElement(By.xpath("id(\"mat-input-5\")")).sendKeys("kristel.juen@cognitiv.com");
		Thread.sleep(1000);
		test7.log(Status.PASS, "Enter E-mail Address");
		driver.findElement(By.xpath("id(\"mat-input-6\")")).sendKeys("Kristeljuen313!");
		Thread.sleep(1000);
		test7.log(Status.PASS, "Enter Password");
		driver.findElement(By.xpath("id(\"mat-checkbox-3\")/LABEL[1]/SPAN[1]")).click();
		Thread.sleep(1000);
		test7.log(Status.PASS, "Click Remember me checkbox");

		driver.close();
		driver.quit();
		test7.pass("Close the browser");
		test7.info("Test Completed ");
		

//		// Test 8 Chatbot Test
//		ExtentTest test8 = extent.createTest("RemotoDojo Home Page Test",
//				"This is to test each section of the Home Page");
//
//		System.setProperty("webdriver.chrome.driver",
//				projectPath + "/drivers/chromedriver/chromedriver_win32/chromedriver.exe");
//		driver = new ChromeDriver();
//
//		test8.log(Status.INFO, "Starting Test Case, Enter URL");
//		driver.get("https://www.remotodojo.com/");
//		driver.manage().window().maximize();
//		test8.log(Status.INFO, "Maximize the window");
//
//		
//		driver.findElement(By.xpath("//BODY/DF-MESSENGER[1]")).click();
//		
//		
//		driver.close();
//		driver.quit();
//		test8.pass("Close the browser");
//		test8.info("Test Completed ");
		
		extent.flush();

	}
}
