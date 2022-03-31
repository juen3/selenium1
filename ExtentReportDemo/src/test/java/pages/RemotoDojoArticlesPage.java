package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RemotoDojoArticlesPage {

private static WebElement element = null;
	
	public static WebElement Commerce_link(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[normalize-space()='E-Commerce']"));
		return element;
	}
	
	public static WebElement Cyber_monday_card(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='flex flex-col gap-4']//span[@class='title'][contains(text(),'Cyber Monday – A Stress Test for IT Outsourcing?')]"));
		return element;
	}
}