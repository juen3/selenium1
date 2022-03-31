package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPageObjects;

public class GoogleSearchPageTest {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		googleSearchTest();
	}

	public static void googleSearchTest() throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
		
		driver.get("https://google.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		searchPageObj.setTextInSearchBox("A B C D");
		Thread.sleep(3000);
		searchPageObj.clickSearchButton();
		
		driver.close();
	}
}
