package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPage;

public class GoogleSearchTest {

	private static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		googleSearch();

	}
	
	public static void googleSearch() throws InterruptedException {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//Go to google.com
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		//enter text in search textbox
		// driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Automation Step by Step");
		
		GoogleSearchPage.textbox_search(driver).sendKeys("Automation Step by Step");
		
		Thread.sleep(3000);
		//click search button
		//driver.findElement(By.xpath("//div[@class='lJ9FBc']//input[@name='btnK']")).click();
		
		GoogleSearchPage.button_search(driver).click();
		Thread.sleep(3000);
		driver.close();
		
		System.out.println("Test Completed Successfully");
	}

	
	
}
