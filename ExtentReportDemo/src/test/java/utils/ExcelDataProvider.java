package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class ExcelDataProvider {

//	public static void main(String[] args) {
//		String excelPath = "C:\\Users\\RemotoDojo\\eclipse-workspace\\ExtentReportDemo\\excel\\data.xlsx";
//		testData(excelPath, "Sheet1");
//	}
//	
	WebDriver driver = null;

	@BeforeTest /* ADDED function setUpTest() and set driver as class variable */
	public void setUpTest() {

		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		PropertiesFile.getProperties();

		System.setProperty("webdriver.chrome.driver",
				projectPath + "\\drivers\\chromedriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test(dataProvider = "test1data")
	public void test1(String username, String password) throws Exception {
		System.out.println(username + " | " + password);
		
		driver.get("https://www.remotodojo.com/accounts/login");
		driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(password);
		Thread.sleep(2000);

		
	}
	

	@DataProvider(name = "test1data")
	public Object[][] getData() {

		String excelPath = "C:\\Users\\RemotoDojo\\eclipse-workspace\\ExtentReportDemo\\excel\\data.xlsx";
		Object data[][] = testData(excelPath, "Sheet1");
		return data;
	}

	public Object[][] testData(String excelPath, String sheetName) {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();

		Object data[][] = new Object[rowCount - 1][colCount];

		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {

				String cellData = excel.getCellDataString(i, j);
//				System.out.print(cellData + " | ");
				data[i - 1][j] = cellData;
			}
			System.out.println();
		}
		return data;
		
	}
	
	@AfterTest
	public void closebroser(){
		driver.close();
	}

}
