package UtilityClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Utility {

	public static String readExcelSheet(int row,int cell) throws EncryptedDocumentException, IOException {
		 File myFile = new File("C:\\Users\\umesh\\eclipse-workspace\\PortfolioAnalyst_Standalone_Application2\\ExcelSheets\\portfolioAnalyst.xlsx");
		 
		 Sheet mySheet = WorkbookFactory.create(myFile).getSheet("Sheet1");
		 String value = mySheet.getRow(row).getCell(cell).getStringCellValue();
		
		 return value;
	 }
		public static String readPropertyFile(String key) throws IOException  {
			Properties property = new Properties();
			FileInputStream myFile = new FileInputStream("C:\\Users\\umesh\\eclipse-workspace\\Unstop\\unstop.properties");
			property.load(myFile);
			String value1 = property.getProperty(key);
			return value1;
		 }
			
		
		
	 
	 public static void wait(int time,WebDriver driver) {
		 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
	 }
	 
	 public static void wait(Duration time,WebDriver driver,WebElement element) {
		 WebDriverWait w = new WebDriverWait(driver, time);
		 
		 w.until(ExpectedConditions.elementToBeClickable(element));
	 }
	 
	 public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element, Duration timeInSeconds) {
		    WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		    wait.until(ExpectedConditions.elementToBeClickable(element));
		    return element;
		}
	 

	 public static void TakeScreenShot(String fileName,WebDriver driver) throws IOException {
		 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Automation_Velocity\\Selenium\\screenshot\\"+fileName+".png");
		Reporter.log("Taking ScreenShots",true);
		FileHandler.copy(src, dest);
		
		 
	 }
	 public static void ScrollIntoView(WebElement element,WebDriver driver) {
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0],ScrollIntoView(true)",element);
	 }
	 
	}

