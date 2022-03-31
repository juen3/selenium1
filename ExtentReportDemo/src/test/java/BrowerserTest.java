import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowerserTest {

	public static void main(String[] args) throws InterruptedException {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: "+projectPath);
		
//		System.setProperty("webdriver.gecko.driver", projectPath+"\\drivers\\geckodriver\\geckodriver-v0.30.0-win64\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
		
		//System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver_win32\\chromedriver.exe"); == this is because we set system variables Path 
		WebDriver driver = new ChromeDriver();
		
		
		//System.setProperty("webdriver.ie.driver", projectPath+"\\drivers\\iedriver\\IEDriverServer_x64_4.0.0\\IEDriverServer.exe");
		//WebDriver driver = new InternetExplorerDriver();
		
		driver.get("https://www.remotodojo.com/accounts/get-access");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//div[@class='actions']//span[@class='text-xs'][normalize-space()='CONSULT NOW']")).click();
		
		List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));
		int count = listOfInputElements.size();
		System.out.println("Count of Input elements: " +count);
		Thread.sleep(3000);
		driver.close();
	} 
}
