package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {
	
	WebDriver driver = null;
	By textbox_search = By.name("q");
	By button_search = By.xpath("//div[@class='lJ9FBc']//input[@name='btnK']");
	
	public GoogleSearchPageObjects(WebDriver driver) {    /*pwd ra sad WebDriver driver1*/
		this.driver = driver;                            /*pwd ra sad driver = driver1*/
	}
	public void setTextInSearchBox(String text) {
		driver.findElement(textbox_search).sendKeys(text);
	}
	
	public void clickSearchButton() {
		driver.findElement(button_search).sendKeys(Keys.RETURN);
	}

}
