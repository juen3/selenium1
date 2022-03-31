package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.RemotoDojoArticlesPage;

public class RemotoDojoArticlesTest {

	private static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ArticlesTest();
	}
	
	public static void ArticlesTest() throws InterruptedException {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//Go to google.com
		driver.get("https://www.remotodojo.com/articles#blog-section");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		RemotoDojoArticlesPage.Commerce_link(driver).click();
		
		Thread.sleep(3000);
		
		
		RemotoDojoArticlesPage.Cyber_monday_card(driver).click();
		Thread.sleep(3000);
		driver.close();
		
		System.out.println("Test Completed Successfully");
	}

	
}
