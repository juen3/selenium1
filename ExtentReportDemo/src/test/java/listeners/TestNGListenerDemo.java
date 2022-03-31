package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo {
	
	@Test
	public void test1(){
		System.out.println("I am inside Test 1");
	}
	
	@Test
	public void test2() throws Exception{
		System.out.println("I am inside Test 2");


		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: "+projectPath);
		
//		System.setProperty("webdriver.gecko.driver", projectPath+"\\drivers\\geckodriver\\geckodriver-v0.30.0-win64\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
		
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("abcd");
		Thread.sleep(1000);
		driver.close();
	}
	
	@Test
	public void test3(){
		System.out.println("I am inside Test 3");
		throw new SkipException("This test is skipped");
	}
}
