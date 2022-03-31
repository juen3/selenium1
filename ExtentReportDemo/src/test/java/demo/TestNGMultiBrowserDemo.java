package demo;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class TestNGMultiBrowserDemo {

	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");
	
	@org.testng.annotations.Parameters("browserName") //NA SET ANG BROWSER SA TESTNG3.XML WHICH IS CHROME   adto ra sad ka mag run as testNG Suite
	@BeforeTest
	public void setup(String browserName) {
		System.out.println("Browser name is : " + browserName);
		System.out.println("Thread id : "+Thread.currentThread().getId());
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath+"\\drivers\\geckodriver\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath+"\\drivers\\edge\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
	}
	
	@Test
	public void test1() throws InterruptedException {
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");
	}
}
