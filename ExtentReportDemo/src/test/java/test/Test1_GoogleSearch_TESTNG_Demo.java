package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class Test1_GoogleSearch_TESTNG_Demo {

//	public static void main(String[] args) throws InterruptedException {               TESTNG DOESNT NEED MAIN METHOD, IT WILL AUTOMATICALLY RUN THE PROJECT
//		// TODO Auto-generated method stub
//		googleSearch();
//
//	}
	
	WebDriver driver = null;    
	public static String browserName = null;
	
	@BeforeTest   /*ADDED function setUpTest() and set driver as class variable*/
	public void setUpTest() {

		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		PropertiesFile.getProperties();
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath+"\\drivers\\geckodriver\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}
	
	
	@Test
	public  void googleSearch() throws InterruptedException {                            /*Deleted the STATIC*/
		
		//Go to google.com
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		//enter text in search textbox
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Automation Step by Step");
		
		Thread.sleep(1000);
		//click search button
		driver.findElement(By.xpath("//input[@name='btnK']")).click();
		Thread.sleep(1000);
		
	}

	@AfterTest
	public void tearDownTest() {
		
		//close browser
//		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
		PropertiesFile.setProperties();
	}
}
