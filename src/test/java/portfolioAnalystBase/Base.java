package portfolioAnalystBase;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import portfolioAnalystUtility.Utility;


public class Base {
	protected WebDriver driver;
	//public WebDriver driver;
	public void LaunchUrl() throws IOException  {
		  System.setProperty("webdriver.chrome.driver", "C:\\Automation_Velocity\\Selenium\\chromedriver.exe");
		 ChromeOptions opt = new ChromeOptions();
		 opt.addArguments("--remote-allow-origins=*");
		  
		 driver = new ChromeDriver(opt);
		 driver.get(Utility.readPropertyFile("url"));
	     driver.manage().window().maximize();
	     }
}


