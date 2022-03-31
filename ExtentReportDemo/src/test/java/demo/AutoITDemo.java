package demo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoITDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		test();
	}
	
	public static void test() throws IOException, InterruptedException {
		
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver_win32/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://stage.remotodojo.com/careers/apply/0#application-form-section");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"application-form-section\"]/div[1]/div/form/div[3]/div/app-button/button")).click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec(projectPath + "/FileUploadScript/fileUploadScript.exe");
		
		Thread.sleep(3000);
		
		driver.close();
		driver.quit();
	}
}
