import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DesiredCapabilities_Demo {

	public static void main(String[] args) throws InterruptedException {

		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		
		
		System.setProperty("webdriver.ie.driver", projectPath+"\\drivers\\iedriver\\IEDriverServer_x64_4.0.0\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("ABCD");
		Thread.sleep(1000);
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		driver.close();
		driver.quit();
		
		

	}

}
